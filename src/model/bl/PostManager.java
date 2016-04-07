package model.bl;

import com.mashape.unirest.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;

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


}
