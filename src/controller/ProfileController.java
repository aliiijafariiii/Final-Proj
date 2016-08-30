package controller;

import com.mashape.unirest.http.HttpResponse;
import model.bl.UserManager;
import model.bl.UserManagerImpl;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import view.mainForms.ProfileForm;
import view.mainForms.UploadForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        CloseableHttpResponse response = userManager.registerProfileFile(ProfileForm.getImage());
            String picAdd = EntityUtils.toString(response.getEntity());
            if (response.getStatusLine().getStatusCode() == 200) {


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
    }





