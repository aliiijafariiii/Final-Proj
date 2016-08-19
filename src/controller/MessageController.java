package controller;

import com.mashape.unirest.http.HttpResponse;
import model.bl.MessageManager;
import model.bl.MessageManagerImpl;
import model.to.UserTo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.mainForms.MassageFrom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        HttpResponse<String> usersFriend = messageManager.getAllUsers();
        JSONParser jsonParser = new JSONParser();
        if (!usersFriend.getBody().equals("[]")) {
            MassageFrom m = new MassageFrom();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(usersFriend.getBody());
            Iterator<JSONObject> jsonObjectIterator = jsonArray.iterator();
            while (jsonObjectIterator.hasNext()) {
                JSONObject jsonObject = jsonObjectIterator.next();
                m.getFriendDTM().addElement(String.valueOf(jsonObject.get("id"))+"-"+String.valueOf(jsonObject.get("userName")));
            }



    }}

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
        String s = MassageFrom.getFriendDTM().getElementAt(MassageFrom.getFriendList().getSelectedIndex());
        String index = String.valueOf(s.charAt(0));
        System.out.println(s);
        System.out.println(index);
        jsonObject3.put("id",index);
        /////
        jsonObject1.put("reciver",jsonObject3);
        System.out.println(jsonObject1.toJSONString());
        HttpResponse<String> response = messageManager.registerMessage(jsonObject1.toJSONString());


    }

    }
