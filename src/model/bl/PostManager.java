package model.bl;

import com.mashape.unirest.http.HttpResponse;
import model.to.UserTo;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.File;

/**
 * Created by ali on 1/24/2016.
 */
public interface PostManager {
    public HttpResponse<String> registerPostText(String postJSON, File file, UserTo userTo)throws Exception;
    public CloseableHttpResponse registerPostFile(String postJSON, File file, UserTo userTo) throws Exception;
    public HttpResponse<String> getPosts() throws Exception;

}
