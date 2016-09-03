package model.bl;

import com.mashape.unirest.http.HttpResponse;

/**
 * Created by ali on 4/27/16.
 */
public interface MessageManager {
    public HttpResponse<String> registerMessage(String MessageJSON) throws Exception;
//    public HttpResponse<String> getRecievedMessages(long id) throws Exception;
//    public HttpResponse<String> getSendedMessages(long id) throws Exception;


    public HttpResponse<String> getAllUsers() throws Exception;

    public HttpResponse<String> getAllFriends(long id) throws Exception;
    public HttpResponse<String> getFriendsChatHistory(long id) throws Exception;
    public HttpResponse<String> getConversationForFill(long id) throws Exception;

    public HttpResponse<String> checkNewMessage() throws Exception;
}
