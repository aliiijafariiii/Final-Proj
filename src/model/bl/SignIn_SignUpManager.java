package model.bl;

/**
 * Created by Ali on 2/15/2016.
 */
public interface SignIn_SignUpManager {
    public String signIn(String userJSON)throws Exception;
    public String signUp(String userJSON)throws Exception;
}
