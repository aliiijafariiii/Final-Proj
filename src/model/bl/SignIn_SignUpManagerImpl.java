package model.bl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import model.util.Utils;

/**
 * Created by Ali on 2/15/2016.
 */
public class SignIn_SignUpManagerImpl implements SignIn_SignUpManager {

    private static SignIn_SignUpManagerImpl signIn_signUpManager = new SignIn_SignUpManagerImpl();
    public static SignIn_SignUpManagerImpl getSignIn_signUpManager() {
        return signIn_signUpManager;
    }
    public SignIn_SignUpManagerImpl() {}

    @Override
    public HttpResponse<String> signIn(String userJSON) throws Exception {
        HttpResponse<String> response = Unirest.post(Utils.getUrlString() + "/login")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN", null)
                .body(userJSON)
                .asString();

        return response;
    }

    @Override
    public HttpResponse<String> signUp(String userJSON) throws Exception {
        HttpResponse<String> response = Unirest.post(Utils.getUrlString() + "/users")
                .header("content-type", "application/json")
                .body(userJSON)
                .asString();
        return response;
    }
}
