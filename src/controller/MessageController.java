package controller;

import com.mashape.unirest.http.HttpResponse;
import model.bl.MessageManager;
import model.bl.MessageManagerImpl;
import model.to.UserTo;
import org.json.simple.JSONObject;
import view.mainForms.MassageFrom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

/**
 * Created by ali on 4/27/16.
 */
public class MessageController implements ActionListener {

    private static MessageController messageController = new MessageController();
    public static MessageController getMessageController() {
        return messageController;
    }
    public MessageController() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Method method = this.getClass().getDeclaredMethod(e.getActionCommand());
            method.invoke(this);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void OpenMessageForm() throws Exception {

        MessageManager messageManager = MessageManagerImpl.getMessageManager();
        HttpResponse<String> usersFriend = messageManager.getAllFriends(UserTo.getId());

        HttpResponse<String> usersChatHistory = messageManager.getFriendsChatHistory(UserTo.getId());

    }

    public void SendNewMessage() throws Exception {
        MessageManager messageManager = MessageManagerImpl.getMessageManager();

        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        jsonObject1.put("id",null);
        jsonObject1.put("content", MassageFrom.getTextArea().getText());
        jsonObject2.put("id", UserTo.getId());
        jsonObject1.put("sender",jsonObject2);
        JSONObject jsonObject3 = new JSONObject();
        /////inja bayad ba esme taraf ye get bere be server ta id bargarde
        jsonObject3.put("id",0);
        /////
        jsonObject1.put("reciver",jsonObject3);

        HttpResponse<String> response = messageManager.registerMessage(jsonObject1.toJSONString());


    }

    }
