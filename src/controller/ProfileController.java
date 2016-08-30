package controller;

import com.mashape.unirest.http.HttpResponse;
import model.bl.UserManager;
import model.bl.UserManagerImpl;
import model.to.UserTo;
import model.util.Utils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.mainForms.ProfileForm;
import view.mainForms.UploadForm;
import view.primary.SignIn_SignUpForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;

/**
 * Created by ali on 8/30/16.
 */
public class ProfileController implements ActionListener {

    private static ProfileController profileController = new ProfileController();

    public static ProfileController getPostController() {
        return profileController;
    }

    public ProfileController() {
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

    public void UpdateProfileInfo() throws Exception {

        UserManagerImpl userManager = UserManagerImpl.getUserManager();

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialog = JOptionPane.showConfirmDialog(null, "Do you want save your changes?", "Question", dialogButton);
        if (dialog == JOptionPane.YES_OPTION) {

            CloseableHttpResponse response = userManager.registerProfileFile(ProfileForm.getImage());
            String picAdd = EntityUtils.toString(response.getEntity());
            if (response.getStatusLine().getStatusCode() == 200) {
        }
        if (dialog == JOptionPane.NO_OPTION){}




//                JSONObject jsonObject1 = new JSONObject();
//                JSONObject jsonObject2 = new JSONObject();
//                JSONArray jsonArray2 = new JSONArray();
//                jsonObject1.put("id", null);
//                jsonObject1.put("content", UploadForm.getContentText().getText());
//                jsonObject1.put("picAddress", picAdd);
//                jsonObject2.put("id", UserTo.getId());
//                jsonObject1.put("writer", jsonObject2);
//                for (int p = 0; p < TagTo.getIdForPost().size(); p++) {
//                    JSONObject j = new JSONObject();
//                    j.put("id", TagTo.getIdForPost().get(p));
//                    jsonArray2.add(j);
//                }
//                jsonObject1.put("tags", jsonArray2);
//                HttpResponse<String> FullResponse = postManager.registerPostFull(jsonObject1.toJSONString());
//                JOptionPane.showMessageDialog(null, "success Post");
//                UploadForm.getFrame().dispose();



            }
        }

    public void EditAboutInfo() throws Exception {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id",null);
        jsonObject.put("userName", SignIn_SignUpForm.getNewUsername().getText());
        jsonObject.put("passWord", SignIn_SignUpForm.getNewPassword().getText());
        jsonObject.put("email", SignIn_SignUpForm.getNewEmail().getText());

//        HttpResponse<String> response = signIn_signUpManager.signUp(jsonObject.toJSONString());
//
//        JSONParser jsonParser = new JSONParser();
//        JSONObject jsonObject2 = (JSONObject) jsonParser.parse(response.getBody());
//
//        UserTo.setId((Long) jsonObject2.get("id"));
//        UserTo.setUsername((String) jsonObject2.get("userName"));
//        UserTo.setAuthToken((String) jsonObject2.get("authToken"));
//        UserTo.setLastSeen((Long) jsonObject2.get("lastSeen"));
//        UserTo.setEmail((String) jsonObject2.get("email"));
//        UserTo.setPassword((String) jsonObject2.get("passWord"));
//        UserTo.setPicAddress((String) jsonObject2.get("PicAddress"));
//        UserTo.setDetails((String) jsonObject2.get("details"));

        BufferedWriter writer = new BufferedWriter(new FileWriter(Utils.getAddressString()+"/a.txt"));
        writer.write(UserTo.getAuthToken());
        writer.close();

    }


    }





