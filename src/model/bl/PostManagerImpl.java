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

/**
 * Created by ali on 1/24/2016.
 */
public class PostManagerImpl implements PostManager {
    private static PostManagerImpl postManager = new PostManagerImpl();

    public static PostManagerImpl getPostManager() {
        return postManager;
    }

    public PostManagerImpl() {
    }

    @Override
    public HttpResponse<String> registerPostText(String postJSON,File file,UserTo userTo) throws Exception {
        
        HttpResponse<String> response = Unirest.post(UrlUtil.getUrlString()+"/posts")
                .header("content-type", "application/json")
                .header("cache-control", "no-cache")
                .header("X-AUTH-TOKEN",userTo.getAuthToken())
                .body(postJSON)
                .asString();

        return response;
    }

    @Override
    public CloseableHttpResponse registerPostFile(String postJSON,File file,UserTo userTo) throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost uploadFile = new HttpPost(UrlUtil.getUrlString()+"/upload");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("picture", file, ContentType.MULTIPART_FORM_DATA, "file.jpg");
        HttpEntity multipart = builder.build();
        uploadFile.setEntity(multipart);
        CloseableHttpResponse uploadResponse = httpClient.execute(uploadFile);
        System.out.println(uploadResponse.getStatusLine().getStatusCode());

        return uploadResponse;
    }


    @Override
    public HttpResponse<String> getPosts() throws Exception {
        UserTo userTo = new UserTo();
        HttpResponse<String> response = Unirest.get(UrlUtil.getUrlString() + "/posts")
                .header("content-type", "application/json")
                .header("X-AUTH_TOKEN",userTo.getAuthToken())
                .asString();
        return response;

    }
}
