package model.bl;

import com.mashape.unirest.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.File;

/**
 * Created by ali on 1/24/2016.
 */
public interface UserManager {
    public String registerUser(String userJSON)throws Exception;
    public CloseableHttpResponse registerProfileFile(File file) throws Exception;
    public HttpResponse<String> searchUser(String word) throws Exception;
    public HttpResponse<String> getUserInfo(long id) throws Exception;
    public HttpResponse<String> getWriterOfPost(long id) throws Exception;

}
