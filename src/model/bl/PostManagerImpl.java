package model.bl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import model.bl.PostManager;
import model.to.UserTo;
import model.util.UrlUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.util.Scanner;

/**
 * Created by ali on 1/24/2016.
 */
public class PostManagerImpl implements PostManager {

    private static PostManagerImpl postManager = new PostManagerImpl();
    public static PostManagerImpl getPostManager() {
        return postManager;
    }
    public PostManagerImpl() {}

    @Override
    public HttpResponse<String> registerPostFull(String postJSON) throws Exception {

        HttpResponse<String> response = Unirest.post(UrlUtil.getUrlString()+"/posts")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .body(postJSON)
                .asString();

        return response;
    }

    @Override
    public CloseableHttpResponse registerPostFile(File file) throws Exception {

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost uploadFile = new HttpPost("http://localhost:9000/posts/upload");
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("picture", file, ContentType.MULTIPART_FORM_DATA, "file.jpg");
            HttpEntity multipart = builder.build();
            uploadFile.setEntity(multipart);
            CloseableHttpResponse uploadResponse = httpClient.execute(uploadFile);

            return uploadResponse;
    }

    @Override
    public HttpResponse<String> registerTags(String TagsJSON) throws Exception {

        HttpResponse<String> response = Unirest.post(UrlUtil.getUrlString()+"/tags")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .body(TagsJSON)
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> getTags() throws Exception {
        HttpResponse<String> response = Unirest.get(UrlUtil.getUrlString()+"/tags")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> getTagsByname(String name) throws Exception {
        HttpResponse<String> response = Unirest.get(UrlUtil.getUrlString()+"/tags/"+name)
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .asString();
        return response;
    }


}
