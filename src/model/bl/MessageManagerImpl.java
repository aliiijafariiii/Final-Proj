package model.bl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import model.to.UserTo;
import model.util.UrlUtil;

/**
 * Created by ali on 4/27/16.
 */
public class MessageManagerImpl implements MessageManager {

    private static MessageManagerImpl messageManager = new MessageManagerImpl();
    public static MessageManagerImpl getMessageManager() {
        return messageManager;
    }
    public MessageManagerImpl() {
    }


    @Override
    public HttpResponse<String> registerMessage(String MessageJSON) throws Exception {
        HttpResponse<String> response = Unirest.post(UrlUtil.getUrlString()+"/messages")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN", UserTo.getAuthToken())
                .body(MessageJSON)
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> getAllFriends(long id) throws Exception {
        HttpResponse<String> response = Unirest.get(UrlUtil.getUrlString()+"/users/"+id+"/friends")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> getFriendsChatHistory(long id) throws Exception {
        HttpResponse<String> response = Unirest.get(UrlUtil.getUrlString()+"/messages/"+id)
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .asString();
        return response;
    }

    @Override
    public HttpResponse<String> getConversationForFill(long id) throws Exception {
        HttpResponse<String> response = Unirest.get(UrlUtil.getUrlString()+"/conversation/"+id+"/"+UserTo.getId())
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN",UserTo.getAuthToken())
                .asString();
        return response;
    }
}
