package model.bl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import model.util.Utils;

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
}
