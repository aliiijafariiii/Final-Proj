package model.bl;

import com.mashape.unirest.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;

import javax.swing.*;
import java.io.File;

/**
 * Created by ali on 1/24/2016.
 */
public interface PostManager {

    public HttpResponse<String> registerPostFull(String postJSON) throws Exception;
    public CloseableHttpResponse registerPostFile(File file) throws Exception;
    public HttpResponse<String> registerTags(String TagsJSON) throws Exception;
    public HttpResponse<String> getTags() throws Exception;
    public HttpResponse<String> getTagsByname(String name) throws Exception;
    public HttpResponse<String> getPostsByTime() throws Exception;
    public ImageIcon getImage(String url) throws Exception;
    public HttpResponse<String> getAllUsers() throws Exception ;
    public HttpResponse<String> getPostsOfUser(long user_id) throws Exception ;

    public HttpResponse<String> getPostsLikes(long post_id) throws Exception;
    public HttpResponse<String> getPostsDislikes(long post_id) throws Exception;
    public HttpResponse<String> getPostsComments(long post_id) throws Exception;

    public HttpResponse<String> removePostsLikes(long post_id) throws Exception;
    public HttpResponse<String> removePostsDislikes(long post_id) throws Exception;
    public HttpResponse<String> removePostsComments(long post_id) throws Exception;

    public HttpResponse<String> addPostsLikes(String json) throws Exception;
    public HttpResponse<String> addPostsDislikes(String json) throws Exception;
    public HttpResponse<String> addPostsComments(String json) throws Exception;




}
