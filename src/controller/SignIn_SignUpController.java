package controller;

import com.mashape.unirest.http.HttpResponse;
import model.bl.SignIn_SignUpManager;
import model.bl.SignIn_SignUpManagerImpl;
import model.to.UserTo;
import model.util.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.primary.MainPanel;
import view.primary.SignIn_SignUpForm;
import view.mainForms.UserForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignIn_SignUpController implements ActionListener {

    private static SignIn_SignUpController userSignUpController = new SignIn_SignUpController();
    public static SignIn_SignUpController getUserSignUpController() {
        return userSignUpController;
    }
    public SignIn_SignUpController() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Method method = this.getClass().getDeclaredMethod(e.getActionCommand());
            method.invoke(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

        public void signin() throws Exception{
//
//            JSONObject jsonObject = new JSONObject();
//
//            jsonObject.put("user", SignIn_SignUpForm.getUsername().getText());
//            jsonObject.put("pass", SignIn_SignUpForm.getPassword().getText());
//
//            System.out.println(jsonObject.toJSONString());
//
//            SignIn_SignUpManager signIn_signUpManager = SignIn_SignUpManagerImpl.getSignIn_signUpManager();
//            HttpResponse<String> response = signIn_signUpManager.signIn(jsonObject.toJSONString());
//
//            System.out.println(response.getBody());
//
//            JSONParser jsonParser = new JSONParser();
//            JSONObject jsonObject2 = (JSONObject) jsonParser.parse(response.getBody());
//
//            UserTo userTo = new UserTo();
//            userTo.setId((Long) jsonObject2.get("id"));
//            userTo.setUsername((String) jsonObject2.get("userName"));
//            userTo.setAuthToken((String) jsonObject2.get("authToken"));
//            userTo.setPicAddress((String) jsonObject2.get("picAddress"));
//            userTo.setAuthToken(String.valueOf(response.getHeaders().));
//
//            BufferedWriter writer = new BufferedWriter(new FileWriter("/home/ali/Desktop/a.txt"));
//            writer.write(userTo.getAuthToken());
//            writer.close();
//
//            SignIn_SignUpForm.getFrame().dispose();
//
//           new MainForm();
        }

    public void signup()throws Exception{

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id",null);
        jsonObject.put("userName", SignIn_SignUpForm.getNewUsername().getText());
        jsonObject.put("passWord", SignIn_SignUpForm.getNewPassword().getText());
        jsonObject.put("email", SignIn_SignUpForm.getNewEmail().getText());

        SignIn_SignUpManager signIn_signUpManager = SignIn_SignUpManagerImpl.getSignIn_signUpManager();
        HttpResponse<String> response = signIn_signUpManager.signUp(jsonObject.toJSONString());

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject2 = (JSONObject) jsonParser.parse(response.getBody());


        UserTo.setId((Long) jsonObject2.get("id"));
        UserTo.setUsername((String) jsonObject2.get("userName"));
        UserTo.setAuthToken((String) jsonObject2.get("authToken"));
        UserTo.setLastSeen((Long) jsonObject2.get("lastSeen"));
        UserTo.setEmail((String) jsonObject2.get("email"));
        UserTo.setPassword((String) jsonObject2.get("passWord"));
        UserTo.setPicAddress((String) jsonObject2.get("PicAddress"));

        BufferedWriter writer = new BufferedWriter(new FileWriter(Utils.getAddressString()+"/a.txt"));
        writer.write(UserTo.getAuthToken());
        writer.close();

        Thread.sleep(1000);
        SignIn_SignUpForm.getFrame().dispose();

        new MainPanel();
        UserForm u = new UserForm();
        u.getIdlabel().setText(String.valueOf(UserTo.getId()));
        u.getNamelabel().setText(UserTo.getUsername());

        Date d = new Date(UserTo.getLastSeen());
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");

        u.getLastseenlabel().setText(dateFormat1.format(d)+" "+dateFormat2.format(d));



    }
}
