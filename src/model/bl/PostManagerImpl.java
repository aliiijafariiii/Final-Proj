package model.bl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import model.bl.PostManager;
import model.util.UrlUtil;

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
    public String registerPost(String postJSON) throws Exception {
        HttpResponse<String> response = Unirest.post(UrlUtil.getUrlString()+"/posts")
                .header("content-type", "application/json")
                .header("cache-control", "no-cache")
                .body(postJSON)
                .asString();

        return response.getBody();
    }
}
