package model.bl;

import com.mashape.unirest.http.HttpResponse;
import model.to.UserTo;

import java.io.File;

/**
 * Created by ali on 1/24/2016.
 */
public interface PostManager {
    public HttpResponse<String> registerPost(String postJSON, File file, UserTo userTo)throws Exception;
    public HttpResponse<String> getPosts() throws Exception;

}
