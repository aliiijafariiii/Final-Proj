package controller;
import com.mashape.unirest.http.HttpResponse;
import model.bl.PostManager;
import model.bl.PostManagerImpl;
import model.to.PostJsonTo;
import model.to.PostTo;
import model.to.TagTo;
import model.to.UserTo;
import model.util.TagUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.mainForms.FeedForm;
import view.mainForms.UploadForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                HttpResponse<String> FullResponse = postManager.registerPostFull(jsonObject1.toJSONString());
                JOptionPane.showMessageDialog(null,"success Post");
            }
        }
    }
    public void FillNewsFeed() throws Exception{

        PostManager postManager = PostManagerImpl.getPostManager();
        HttpResponse<String> postsResponse = postManager.getPostsByTime();

        List<JSONObject> postJson = new ArrayList<JSONObject>();
        JSONParser jsonParser = new JSONParser();
        if (!postsResponse.getBody().equals("[]")) {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(postsResponse.getBody());
            Iterator<JSONObject> jsonObjectIterator = jsonArray.iterator();
            while (jsonObjectIterator.hasNext()) {
                JSONObject jsonObject = jsonObjectIterator.next();
                postJson.add(jsonObject);
            }
        }

        PostJsonTo postJsonTo = new PostJsonTo();
        postJsonTo.setPostsJson(postJson);

        FeedForm feedForm = new FeedForm();
        JSONParser jp = new JSONParser();
        JSONObject pp = (JSONObject) jp.parse(String.valueOf(postJson.get(0)));

        ImageIcon image = postManager.getImage(String.valueOf(pp.get("picAddress")));
        feedForm.getImagelabel().setIcon(image);
        feedForm.getContentlabel().setText(String.valueOf(pp.get("content")));

        Date d = new Date((Long) pp.get("publishDate"));
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        feedForm.getTimelabel().setText(dateFormat1.format(d)+" "+dateFormat2.format(d));
        feedForm.getPostIdlabel().setText(String.valueOf(pp.get("id")));


        PostTo postTo = new PostTo();
        postTo.setContent(String.valueOf(pp.get("content")));
        postTo.setId((Long) pp.get("id"));
        postTo.setPublishDate((Long) pp.get("publishDate"));
        postTo.setIndex(0);
        postTo.setPicAddress(String.valueOf(pp.get("picAddress")));

    }
    public void NextButton_FillNewsFeed() throws Exception{

        PostJsonTo postJsonTo = new PostJsonTo();
        PostTo postTo = new PostTo();

if (postTo.getIndex()+1<postJsonTo.getPostsJson().size()) {

    JSONParser jp = new JSONParser();
    JSONObject pp = (JSONObject) jp.parse(String.valueOf(postJsonTo.getPostsJson().get((int) postTo.getIndex() + 1)));


    PostManager postManager = PostManagerImpl.getPostManager();
    ImageIcon image = postManager.getImage(String.valueOf(pp.get("picAddress")));
    FeedForm.getImagelabel().setIcon(image);
    FeedForm.getContentlabel().setText(String.valueOf(pp.get("content")));

    Date d = new Date((Long) pp.get("publishDate"));
    DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
    FeedForm.getTimelabel().setText(dateFormat1.format(d) + " " + dateFormat2.format(d));
    FeedForm.getPostIdlabel().setText(String.valueOf(pp.get("id")));

    postTo.setIndex(postTo.getIndex() + 1);

    postTo.setContent(String.valueOf(pp.get("content")));
    postTo.setId((Long) pp.get("id"));
    postTo.setPublishDate((Long) pp.get("publishDate"));
    postTo.setPicAddress(String.valueOf(pp.get("picAddress")));
}else {
        FeedForm.getNextPostbtn().setEnabled(false);
        JOptionPane.showMessageDialog(null,"There Is No Another Post To Show!");
}
    }
    public void PrivousButton_FillNewsFeed() throws Exception{


        PostJsonTo postJsonTo = new PostJsonTo();
        PostTo postTo = new PostTo();


        if (postTo.getIndex()>0) {

            JSONParser jp = new JSONParser();
            JSONObject pp = (JSONObject) jp.parse(String.valueOf(postJsonTo.getPostsJson().get((int) postTo.getIndex() -1)));


            PostManager postManager = PostManagerImpl.getPostManager();
            ImageIcon image = postManager.getImage(String.valueOf(pp.get("picAddress")));
            FeedForm.getImagelabel().setIcon(image);
            FeedForm.getContentlabel().setText(String.valueOf(pp.get("content")));

            Date d = new Date((Long) pp.get("publishDate"));
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
            FeedForm.getTimelabel().setText(dateFormat1.format(d) + " " + dateFormat2.format(d));
            FeedForm.getPostIdlabel().setText(String.valueOf(pp.get("id")));

            postTo.setIndex(postTo.getIndex() -1);

            postTo.setContent(String.valueOf(pp.get("content")));
            postTo.setId((Long) pp.get("id"));
            postTo.setPublishDate((Long) pp.get("publishDate"));
            postTo.setPicAddress(String.valueOf(pp.get("picAddress")));
        }else{
            FeedForm.getPrviousPostbtn().setEnabled(false);
            JOptionPane.showMessageDialog(null,"There Is No Another Post To Show!");
        }
    }


    public void SendNewLike() throws Exception{
        PostManager postManager = PostManagerImpl.getPostManager();



        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONObject jsonObject3 = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonObject1.put("id", null);
        jsonObject2.put("id",FeedForm.getPostIdlabel().getText());
        jsonArray.add(jsonObject2);
        jsonObject1.put("posts", jsonArray);
        jsonObject3.put("id", UserTo.getId());
        jsonObject1.put("lover", jsonObject3);

        System.out.println(jsonObject1.toJSONString());

        HttpResponse<String> FullResponse = postManager.addPostsLikes(jsonObject1.toJSONString());
        if (FullResponse.getStatus() == 200){
            FeedForm.getLikeBtn().setBackground(Color.green);
        }
    }
    public void SendNewDislike() throws Exception{
        PostManager postManager = PostManagerImpl.getPostManager();

        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONObject jsonObject3 = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonObject1.put("id", null);
        jsonObject2.put("id",FeedForm.getPostIdlabel().getText());
        jsonArray.add(jsonObject2);
        jsonObject1.put("posts", jsonArray);
        jsonObject3.put("id", UserTo.getId());
        jsonObject1.put("disliker", jsonObject3);

        System.out.println(jsonObject1.toJSONString());

        HttpResponse<String> FullResponse = postManager.addPostsDislikes(jsonObject1.toJSONString());
        if (FullResponse.getStatus() == 200){
            FeedForm.getDislikeBtn().setBackground(Color.green);
        }
    }


    public void SendNewComment() throws Exception{}


/////////////////////////////////////////////////////////////////////////////
    public void ShowLikes() throws Exception{

        PostManager postManager = PostManagerImpl.getPostManager();
        HttpResponse<String> response = postManager.getPostsLikes(0);

//        List<JSONObject> postJson = new ArrayList<JSONObject>();
        JSONParser jsonParser = new JSONParser();
        if (!response.getBody().equals("[]")) {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(response.getBody());
            Iterator<JSONObject> jsonObjectIterator = jsonArray.iterator();
            while (jsonObjectIterator.hasNext()) {
                JSONObject jsonObject = jsonObjectIterator.next();
//                postJson.add(jsonObject);
            }
        }
    }

    public void ShowDislikes() throws Exception{

        PostManager postManager = PostManagerImpl.getPostManager();
        HttpResponse<String> response = postManager.getPostsDislikes(0);

        //        List<JSONObject> postJson = new ArrayList<JSONObject>();
        JSONParser jsonParser = new JSONParser();
        if (!response.getBody().equals("[]")) {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(response.getBody());
            Iterator<JSONObject> jsonObjectIterator = jsonArray.iterator();
            while (jsonObjectIterator.hasNext()) {
                JSONObject jsonObject = jsonObjectIterator.next();
//                postJson.add(jsonObject);
            }
        }
    }

    public void ShowComments() throws Exception{

        PostManager postManager = PostManagerImpl.getPostManager();
        HttpResponse<String> response = postManager.getPostsLikes(0);

        //        List<JSONObject> postJson = new ArrayList<JSONObject>();
        JSONParser jsonParser = new JSONParser();
        if (!response.getBody().equals("[]")) {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(response.getBody());
            Iterator<JSONObject> jsonObjectIterator = jsonArray.iterator();
            while (jsonObjectIterator.hasNext()) {
                JSONObject jsonObject = jsonObjectIterator.next();
//                postJson.add(jsonObject);
            }
        }
    }
}

