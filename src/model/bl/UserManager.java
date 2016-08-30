package model.bl;

import org.apache.http.client.methods.CloseableHttpResponse;

import java.io.File;

/**
 * Created by ali on 1/24/2016.
 */
public interface UserManager {
    public String registerUser(String userJSON)throws Exception;
    public CloseableHttpResponse registerProfileFile(File file) throws Exception;

}
