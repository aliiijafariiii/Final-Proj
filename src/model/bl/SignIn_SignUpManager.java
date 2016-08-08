package model.bl;

import com.mashape.unirest.http.HttpResponse;

/**
 * Created by Ali on 2/15/2016.
 */
public interface SignIn_SignUpManager {
    public HttpResponse<String> signIn(String userJSON)throws Exception;
    public HttpResponse<String> signUp(String userJSON)throws Exception;
    public HttpResponse<String> ChecksignUp(String userJSON)throws Exception;
    public HttpResponse<String> logOut() throws Exception;
}
