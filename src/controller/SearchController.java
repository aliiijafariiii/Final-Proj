package controller;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import model.bl.PostManager;
import model.bl.PostManagerImpl;
import model.bl.UserManager;
import model.bl.UserManagerImpl;
import model.to.PostJsonTo;
import model.to.PostTo;
import model.to.UserTo;
import model.util.Utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.mainForms.ReviewForm;
import view.util.SearchForm;
import view.util.ShowUserInfoForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ali on 9/2/16.
 */
public class SearchController implements ActionListener {

    private static SearchController searchController = new SearchController();

    public static SearchController getProfileController() {
        return searchController;
    }

    public SearchController() {
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

    public void SearchForUsers() throws Exception {
        SearchForm.getUsersDTM().clear();
        UserManagerImpl userManager = UserManagerImpl.getUserManager();
        HttpResponse<String> response = userManager.searchUser(SearchForm.getSearchText().getText());

        JSONParser jsonParser = new JSONParser();
        if (!response.getBody().equals("[]")) {
            System.out.println(response.getStatus());
            System.out.println(response.getStatusText());
            JSONArray jsonArray = (JSONArray) jsonParser.parse(response.getBody());
            Iterator<JSONObject> jsonObjectIterator = jsonArray.iterator();
            while (jsonObjectIterator.hasNext()) {
                JSONObject jsonObject = jsonObjectIterator.next();

                SearchForm.getUsersDTM().addElement(jsonObject.get("id") + "-" + jsonObject.get("userName"));
            }
            SearchForm.getShowPostsBtn().setEnabled(true);
            SearchForm.getShowProfileBtn().setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null,"Not Found","warning",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ShowPostsOfUser() throws Exception{


        PostManager postManager = PostManagerImpl.getPostManager();
        String s = SearchForm.getUserList().getSelectedValue();
        int i = s.indexOf('-');
        long l = Long.parseLong(s.substring(0,i));
        HttpResponse<String> postsResponse = postManager.getPostsOfUser(l);

        List<JSONObject> postJson = new ArrayList<JSONObject>();
        JSONParser jsonParser = new JSONParser();
        if (!postsResponse.getBody().equals("[]")) {

            JSONArray jsonArray = (JSONArray) jsonParser.parse(postsResponse.getBody());
            Iterator<JSONObject> jsonObjectIterator = jsonArray.iterator();
            while (jsonObjectIterator.hasNext()) {
                JSONObject jsonObject = jsonObjectIterator.next();
                postJson.add(jsonObject);
            }
            PostJsonTo postJsonTo = new PostJsonTo();
            postJsonTo.setPostsJson(postJson);

            ReviewForm reviewForm = new ReviewForm();
            JSONParser jp = new JSONParser();
            JSONObject pp = (JSONObject) jp.parse(String.valueOf(postJson.get(0)));

            ImageIcon image = postManager.getImage(String.valueOf(pp.get("picAddress")));
            reviewForm.getImagelabel().setIcon(image);
            reviewForm.getContentlabel().setText(String.valueOf(pp.get("content")));

            Date d = new Date((Long) pp.get("publishDate"));
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
            reviewForm.getTimelabel().setText(dateFormat1.format(d) + " " + dateFormat2.format(d));
            reviewForm.getPostIdlabel().setText(String.valueOf(pp.get("id")));

            PostTo postTo = new PostTo();
            postTo.setContent(String.valueOf(pp.get("content")));
            postTo.setId((Long) pp.get("id"));
            postTo.setPublishDate((Long) pp.get("publishDate"));
            postTo.setIndex(0);
            postTo.setPicAddress(String.valueOf(pp.get("picAddress")));
        } else {
            JOptionPane.showMessageDialog(null, "<html>There is no post to show!<br>This user dont upload any posts yet</html> ");
        }



        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    }

    public void NextButton_FillNewsFeed() throws Exception {
        PostJsonTo postJsonTo = new PostJsonTo();
        PostTo postTo = new PostTo();
        if (postTo.getIndex() + 1 < postJsonTo.getPostsJson().size()) {

            JSONParser jp = new JSONParser();
            JSONObject pp = (JSONObject) jp.parse(String.valueOf(postJsonTo.getPostsJson().get((int) postTo.getIndex() + 1)));

            PostManager postManager = PostManagerImpl.getPostManager();
            ImageIcon image = postManager.getImage(String.valueOf(pp.get("picAddress")));
            ReviewForm.getImagelabel().setIcon(image);
            ReviewForm.getContentlabel().setText(String.valueOf(pp.get("content")));

            Date d = new Date((Long) pp.get("publishDate"));
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
            ReviewForm.getTimelabel().setText(dateFormat1.format(d) + " " + dateFormat2.format(d));
            ReviewForm.getPostIdlabel().setText(String.valueOf(pp.get("id")));

            postTo.setIndex(postTo.getIndex() + 1);
            postTo.setContent(String.valueOf(pp.get("content")));
            postTo.setId((Long) pp.get("id"));
            postTo.setPublishDate((Long) pp.get("publishDate"));
            postTo.setPicAddress(String.valueOf(pp.get("picAddress")));
        } else {
//            ReviewForm.getNextPostbtn().setEnabled(false);
            JOptionPane.showMessageDialog(null, "There Is No Another Post To Show!");
        }
    }

    public void PrivousButton_FillNewsFeed() throws Exception {

        PostJsonTo postJsonTo = new PostJsonTo();
        PostTo postTo = new PostTo();

        if (postTo.getIndex() > 0) {

            JSONParser jp = new JSONParser();
            JSONObject pp = (JSONObject) jp.parse(String.valueOf(postJsonTo.getPostsJson().get((int) postTo.getIndex() - 1)));

            PostManager postManager = PostManagerImpl.getPostManager();
            ImageIcon image = postManager.getImage(String.valueOf(pp.get("picAddress")));
            ReviewForm.getImagelabel().setIcon(image);
            ReviewForm.getContentlabel().setText(String.valueOf(pp.get("content")));

            Date d = new Date((Long) pp.get("publishDate"));
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
            ReviewForm.getTimelabel().setText(dateFormat1.format(d) + " " + dateFormat2.format(d));
            ReviewForm.getPostIdlabel().setText(String.valueOf(pp.get("id")));

            postTo.setIndex(postTo.getIndex() - 1);
            postTo.setContent(String.valueOf(pp.get("content")));
            postTo.setId((Long) pp.get("id"));
            postTo.setPublishDate((Long) pp.get("publishDate"));
            postTo.setPicAddress(String.valueOf(pp.get("picAddress")));
        } else {
//            ReviewForm.getPrviousPostbtn().setEnabled(false);
            JOptionPane.showMessageDialog(null, "There Is No Another Post To Show!");
        }
    }

    public void ShowProfileOfUser() throws Exception{

        UserManagerImpl userManager = UserManagerImpl.getUserManager();
        String s = SearchForm.getUserList().getSelectedValue();
        int i = s.indexOf('-');
        long l = Long.parseLong(s.substring(0,i));
        HttpResponse<String> usersResponse = userManager.getUserInfo(l);

        if (usersResponse.getStatus() == 200) {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(usersResponse.getBody());

        ShowUserInfoForm u = new ShowUserInfoForm();
        u.getIdlabel().setText(String.valueOf(jsonObject.get("id")));
        u.getNamelabel().setText(String.valueOf(jsonObject.get("userName")));

        Date d = new Date();
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");

        u.getLastseenlabel().setText(dateFormat1.format(d) + " " + dateFormat2.format(d));
    }}
}