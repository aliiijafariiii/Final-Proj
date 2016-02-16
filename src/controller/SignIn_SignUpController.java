package controller;



import model.bl.UserManager;
import model.bl.UserManagerImpl;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.SignIn_SignUpForm;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

/**
 * Created by ali on 1/24/2016.
 */
public class SignIn_SignUpController implements ActionListener {

    private static SignIn_SignUpController userSignUpController = new SignIn_SignUpController();

    public static SignIn_SignUpController getUserSignUpController() {
        return userSignUpController;
    }

    public SignIn_SignUpController() {
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

        public void register() throws Exception{



//            User_signUpTo userSignUpTo = new User_signUpTo(0,SignIn_SignUpForm.getUsername().getText(),
//                    SignIn_SignUpForm.getPassword().getText(),
//                    SignIn_SignUpForm.getEmail().getText());

            JSONObject jsonObject = new JSONObject();

//            jsonObject.put("userName", userSignUpTo.getUsername());
//            jsonObject.put("passWord", userSignUpTo.getPassword());
//            jsonObject.put("email", userSignUpTo.getEmail());

            UserManager userManager = UserManagerImpl.getUserManager();
            String response = userManager.registerUser(jsonObject.toJSONString());


            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject1= (JSONObject) jsonParser.parse(response);

         //   userSignUpTo.setId((Long) jsonObject1.get("id"));

            System.out.println(response);

            JOptionPane.showMessageDialog(null,"inserted");


            SignIn_SignUpForm.getFrame().dispose();
        }

}
