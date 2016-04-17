package model.to;

import org.json.simple.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 4/17/16.
 */
public class PostJsonTo implements Serializable {

    private static List<JSONObject> postsJson;

    public PostJsonTo() {
    }

    public static List<JSONObject> getPostsJson() {
        return postsJson;
    }

    public static void setPostsJson(List<JSONObject> postsJson) {
        PostJsonTo.postsJson = postsJson;
    }
}
