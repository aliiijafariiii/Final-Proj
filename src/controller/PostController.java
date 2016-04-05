package controller;
import com.mashape.unirest.http.HttpResponse;
import model.bl.PostManager;
import model.bl.PostManagerImpl;
import model.to.TagTo;
import model.to.UserTo;
import model.util.TagUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.mainForms.UploadForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class PostController implements ActionListener {

    private static PostController postController = new PostController();
    public static PostController getPostController() {
        return postController;
    }
    public PostController() {}

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Method method = this.getClass().getDeclaredMethod(e.getActionCommand());
            method.invoke(this);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void SendNewPost() throws Exception {

            PostManager postManager = PostManagerImpl.getPostManager();
            TagUtil tagUtil = TagUtil.getTagUtil();
            HttpResponse res = tagUtil.MakeTagForSend();

         //   System.out.println(res.getBody());

        if (res.getStatus()==200){
 ////////////////////////////////////////////////////////////////////////////////////////////////////////
            CloseableHttpResponse response = postManager.registerPostFile(UploadForm.getImage());
            String picAdd = EntityUtils.toString(response.getEntity());

            if (response.getStatusLine().getStatusCode() == 200) {

                JSONObject jsonObject1 = new JSONObject();
                JSONObject jsonObject2 = new JSONObject();
                JSONArray jsonArray2 = new JSONArray();

                jsonObject1.put("id", null);
                jsonObject1.put("content", UploadForm.getContentText().getText());
                jsonObject1.put("picAddress", picAdd);
                jsonObject2.put("id", UserTo.getId());
                jsonObject1.put("writer", jsonObject2);

                for (int p = 0; p < TagTo.getIdForPost().size(); p++) {
                    JSONObject j = new JSONObject();
                    j.put("id", TagTo.getIdForPost().get(p));
                    jsonArray2.add(j);
                }

                jsonObject1.put("tags", jsonArray2);
                System.out.println(jsonObject1.toJSONString());
                HttpResponse<String> FullResponse = postManager.registerPostFull(jsonObject1.toJSONString());
                JOptionPane.showMessageDialog(null,"success Post");

            }
        }

        }
    }

