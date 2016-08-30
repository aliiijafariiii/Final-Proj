package model.bl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import model.util.Utils;
import org.apache.commons.io.FilenameUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.util.UUID;

/**
 * Created by ali on 1/24/2016.
 */
public class UserManagerImpl implements UserManager {
    private static UserManagerImpl userManager = new UserManagerImpl();

    public static UserManagerImpl getUserManager() {
        return userManager;
    }

    public UserManagerImpl() {
    }

    @Override
    public String registerUser(String userJSON) throws Exception {

        HttpResponse<String> response = Unirest.post(Utils.getUrlString()+"/users")
                .header("content-type", "application/json")
                .header("cache-control", "no-cache")
                .body(userJSON)
                .asString();

        return response.getBody();
    }

    @Override
    public CloseableHttpResponse registerProfileFile(File file) throws Exception {
        String ext = FilenameUtils.getExtension(file.getPath());
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost uploadFile = new HttpPost(Utils.getUrlString()+"/users/upload");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("picture", file, ContentType.MULTIPART_FORM_DATA, UUID.randomUUID().toString()+"."+ext);
        HttpEntity multipart = builder.build();
        uploadFile.setEntity(multipart);
        CloseableHttpResponse uploadResponse = httpClient.execute(uploadFile);

        return uploadResponse;
    }
}
