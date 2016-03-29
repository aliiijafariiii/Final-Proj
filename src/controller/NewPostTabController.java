package controller;


import com.mashape.unirest.http.HttpResponse;
import model.bl.PostManager;
import model.bl.PostManagerImpl;
import model.to.UserTo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.MainForm;
import view.SignIn_SignUpForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.Iterator;

/**
 * Created by ali on 3/24/16.
 */
public class NewPostTabController implements ActionListener {
    private static NewPostTabController newPostTabController = new NewPostTabController();

    public static NewPostTabController getNewPostTabController() {
        return newPostTabController;
    }

    public NewPostTabController() {
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

    public void SendNewPost() throws Exception{

        UserTo userTo = new UserTo();

        JSONObject jsonObject = new JSONObject();



        jsonObject.put("content", MainForm.getPostcontent().getText());
        jsonObject.put("file", MainForm.getSelectedFile());


        PostManager postManager = PostManagerImpl.getPostManager();
        HttpResponse<String> response = postManager.registerPost(jsonObject.toJSONString(),null,userTo);




    }


    public void UpdateAndManageNewsFeed() throws Exception{

        PostManager postManager = PostManagerImpl.getPostManager();
        String s = postManager.getPosts().getBody();

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(s);

        Iterator<JSONObject> jsonObjectIterator = jsonArray.iterator();
        while  (jsonObjectIterator.hasNext()){
            JSONObject jsonObject = jsonObjectIterator.next();
            jsonObject.get("id");
            jsonObject.get("content");
            //inja bayad panel set shavad
        }




    }
}
