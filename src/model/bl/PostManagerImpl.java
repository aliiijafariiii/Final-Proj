package model.bl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import model.bl.PostManager;
import model.to.UserTo;
import model.util.UrlUtil;

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
    public HttpResponse<String> registerPost(String postJSON,File file,UserTo userTo) throws Exception {



        HttpResponse<String> response = Unirest.post(UrlUtil.getUrlString()+"/posts")
                .header("content-type", "application/json")
                .header("cache-control", "no-cache")
                .header("X-AUTH-TOKEN",userTo.getAuthToken())
                .body(postJSON)
                .asString();

        return response;
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
