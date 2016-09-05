package controller;

import com.mashape.unirest.http.HttpResponse;
import model.bl.MessageManager;
import model.bl.MessageManagerImpl;
import model.to.UserTo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.mainForms.MassageFrom;
import view.mainForms.UserForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by ali on 4/27/16.
 */
public class MessageController implements ActionListener {

    private static MessageController messageController = new MessageController();
    private static  java.util.Timer timer;


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
        List bb = new ArrayList();
        JSONParser jsonParser = new JSONParser();
        if (!usersFriend.getBody().equals("[]")) {
            MassageFrom m = new MassageFrom();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(usersFriend.getBody());
            Iterator<JSONObject> jsonObjectIterator = jsonArray.iterator();
            while (jsonObjectIterator.hasNext()) {
                JSONObject jsonObject = jsonObjectIterator.next();
                m.getFriendDTM().addElement(String.valueOf(jsonObject.get("id")) + "-" + String.valueOf(jsonObject.get("userName")));
                bb.add(String.valueOf(jsonObject.get("id")) + "-" + String.valueOf(jsonObject.get("userName")));

            }
        }
        ////////////////////////
        HttpResponse<String> UsersHistory = messageManager.getFriendsChatHistory(UserTo.getId());
        System.out.println(UsersHistory.getBody());
        if (!UsersHistory.getBody().equals("[]")) {
        JSONArray jsonArray2 = (JSONArray) jsonParser.parse(UsersHistory.getBody());
        Iterator<JSONObject> jsonObjectIterator2 = jsonArray2.iterator();
        while (jsonObjectIterator2.hasNext()) {
            JSONObject jsonObject2 = jsonObjectIterator2.next();
            String reciver = String.valueOf(jsonObject2.get("reciver"));
            String sender = String.valueOf(jsonObject2.get("sender"));

                    for (int i = 0;i<bb.size();i++){
                        String m = bb.get(i).toString();
                        int b = m.indexOf('-');
                        System.out.println("1->"+reciver.substring(15,reciver.length()-1));
                        System.out.println("2->"+m.charAt(0));
                        if (b==1){
                            if (reciver.substring(15,reciver.length()-1).equals(String.valueOf(m.charAt(0)))||
                                sender.substring(15,sender.length()-1).equals(String.valueOf(m.charAt(0)))){

//                                        MassageFrom.getHistoryDTM().addElement("id"+ "-" + m.substring(b + 1, m.length()));
                                MassageFrom.getHistoryDTM().addElement(m);
                                }

                            }
                        }
            System.out.println(MassageFrom.getHistoryDTM().getSize());
                    }
//            for (int i = 0;i<bb.size();i++){
//                String m = bb.get(i).toString();
//                int b = m.indexOf('-');
//                System.out.println("b_>"+b);
//                if (b==1){
//                    String reciver = String.valueOf(jsonObject2.get("reciver"));
//                    String sender = String.valueOf(jsonObject2.get("sender"));
//                    System.out.println(m);
//                    ////////////////////
//                    System.out.println(reciver.substring(15,reciver.length()-1));
//                    System.out.println(sender.substring(15,sender.length()-1));
//                    ////////////////////
//                if (reciver.substring(15,reciver.length()-1)==m.substring(0,b-1)||sender.substring(15,sender.length()-1)==m.substring(0,b-1)) {
//                    MassageFrom.getHistoryDTM().addElement(String.valueOf(jsonObject2.get("id")) + "-" + m.substring(b + 1, m.length()));
////                    System.out.println(String.valueOf(jsonObject2.get("id")) + "-" + m.substring(b + 1, m.length()));
//                }
//                }else{
//                    MassageFrom.getHistoryDTM().addElement(String.valueOf(jsonObject2.get("id")) + "-" + m.substring(2, m.length()));
////                    System.out.println(String.valueOf(jsonObject2.get("id")) + "-" + m.substring(2, m.length()));
//                    }
//                }

        }
            ////////////////////////
        TimerTask t = new TimerTask() {
                @Override
                public void run() {
                    try {
                            HttpResponse<String> response = messageManager.checkNewMessage();
                            if (response.getBody()!="[]"){
                                JSONParser jp = new JSONParser();
                                JSONArray ja = (JSONArray) jp.parse(response.getBody());
                                Iterator<JSONObject> jsonObjectIterator3 = ja.iterator();
                                while(jsonObjectIterator3.hasNext()){
                                    JSONObject jsonObject = jsonObjectIterator3.next();
                                if (MassageFrom.getMassageLabel().getText().length()!=0){
                                    int i = MassageFrom.getMassageLabel().getText().length();
                                    String n = MassageFrom.getMassageLabel().getText().substring(6,i-7);
                                    MassageFrom.getMassageLabel().setText("<html>"+n+"<br>"+ jsonObject.get("sender")+":"+jsonObject.get("content")+"</html>");
                                }else{
                                   MassageFrom.getMassageLabel().setText("<html>"+ jsonObject.get("sender")+":"+jsonObject.get("content")+"</html>");
                                }
                            }}
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            timer = new java.util.Timer();
            timer.schedule(t, 0,2000);
        }

    public void ExitMessageForm() throws Exception{
        MassageFrom.getFrame().dispose();
        timer.cancel();
    }


    public void SendNewMessage() throws Exception {
        MessageManager messageManager = MessageManagerImpl.getMessageManager();

        if (!MassageFrom.getFriendList().isSelectionEmpty()){

        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        jsonObject1.put("id",null);
        jsonObject1.put("content", MassageFrom.getTextArea().getText());
        jsonObject2.put("id", UserTo.getId());
        jsonObject1.put("sender",jsonObject2);
        JSONObject jsonObject3 = new JSONObject();
        String s = MassageFrom.getFriendDTM().getElementAt(MassageFrom.getFriendList().getSelectedIndex());
        String index = String.valueOf(s.charAt(0));
        jsonObject3.put("id",index);
        /////
        jsonObject1.put("reciver",jsonObject3);
        HttpResponse<String> response = messageManager.registerMessage(jsonObject1.toJSONString());
        /////////////////////////
        if (MassageFrom.getMassageLabel().getText().length()!=0){
        int i = MassageFrom.getMassageLabel().getText().length();
        String n = MassageFrom.getMassageLabel().getText().substring(6,i-7);
        MassageFrom.getMassageLabel().setText("<html>"+n+"<br>"+ UserForm.getNamelabel().getText()+":"+MassageFrom.getTextArea().getText()+"</html>");
        }else{
            MassageFrom.getMassageLabel().setText("<html>"+ UserForm.getNamelabel().getText()+":"+MassageFrom.getTextArea().getText()+"</html>");
        }
        MassageFrom.getTextArea().setText("");
    }
        else{
            JOptionPane.showMessageDialog(null,"Please select one user!","warning",JOptionPane.ERROR_MESSAGE);
        }
    }
}
