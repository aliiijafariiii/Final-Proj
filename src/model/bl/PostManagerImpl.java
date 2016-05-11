package model.bl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import model.to.UserTo;
import model.util.Utils;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

public class PostManagerImpl implements PostManager {

    private static PostManagerImpl postManager = new PostManagerImpl();
    public static PostManagerImpl getPostManager() {
        return postManager;
    }
    public PostManagerImpl() {}

    @Override
    public HttpResponse<String> registerPostFull(String postJSON) throws Exception {

        HttpResponse<String> response = Unirest.post(Utils.getUrlString()+"/posts")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .body(postJSON)
                .asString();

        return response;
    }

    @Override
    public CloseableHttpResponse registerPostFile(File file) throws Exception {

            String ext = FilenameUtils.getExtension(file.getPath());
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost uploadFile = new HttpPost(Utils.getUrlString()+"/posts/upload");
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("picture", file, ContentType.MULTIPART_FORM_DATA, UUID.randomUUID().toString()+"."+ext);
            HttpEntity multipart = builder.build();
            uploadFile.setEntity(multipart);
            CloseableHttpResponse uploadResponse = httpClient.execute(uploadFile);

            return uploadResponse;
    }

    @Override
    public HttpResponse<String> registerTags(String TagsJSON) throws Exception {

        HttpResponse<String> response = Unirest.post(Utils.getUrlString()+"/tags")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .body(TagsJSON)
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> getTags() throws Exception {
        HttpResponse<String> response = Unirest.get(Utils.getUrlString()+"/tags")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> getTagsByname(String name) throws Exception {
        HttpResponse<String> response = Unirest.get(Utils.getUrlString()+"/tags/"+name)
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> getPostsByTime() throws Exception {
        HttpResponse<String> response = Unirest.get(Utils.getUrlString()+"/posts/"+new Date().getTime()+"/string")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .asString();
        return response;
    }

    @Override
    public ImageIcon getImage(String url) throws Exception {
        URL u = new URL(Utils.getUrlString()+"/assets"+url);
        Image image = ImageIO.read(u);
        ImageIcon icon = new ImageIcon(image);
        return icon;
    }

    @Override
    public HttpResponse<String> getPostsLikes(long post_id) throws Exception {
        HttpResponse<String> response = Unirest.get(Utils.getUrlString()+"/posts/"+post_id+"/loves")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> getPostsDislikes(long post_id) throws Exception {
        HttpResponse<String> response = Unirest.get(Utils.getUrlString()+"/posts/"+post_id+"/dislikes")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> getPostsComments(long post_id) throws Exception {
        HttpResponse<String> response = Unirest.get(Utils.getUrlString()+"/posts/"+post_id+"/comments")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> removePostsLikes(long post_id) throws Exception {
        HttpResponse<String> response = Unirest.delete(Utils.getUrlString()+"/loves/"+post_id)
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> removePostsDislikes(long post_id) throws Exception {
        HttpResponse<String> response = Unirest.delete(Utils.getUrlString()+"/dislikes/"+post_id)
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> removePostsComments(long post_id) throws Exception {
        HttpResponse<String> response = Unirest.delete(Utils.getUrlString()+"/comments/"+post_id)
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> addPostsLikes(String json) throws Exception {
        HttpResponse<String> response = Unirest.post(Utils.getUrlString()+"/loves")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .body(json)
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> addPostsDislikes(String json) throws Exception {
        HttpResponse<String> response = Unirest.post(Utils.getUrlString()+"/dislikes")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .body(json)
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> addPostsComments(String json) throws Exception {
        HttpResponse<String> response = Unirest.post(Utils.getUrlString()+"/comments")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .body(json)
                .asString();
        return response;
    }


}
