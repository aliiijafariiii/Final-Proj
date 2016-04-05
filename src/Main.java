import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import model.to.TagTo;
import model.to.UserTo;
import model.util.UrlUtil;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import view.mainForms.UploadForm;
import view.primary.MainPanel;
import view.primary.SignIn_SignUpForm;
import view.mainForms.UserForm;
import view.util.ProssesBarForm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ali on 1/22/2016.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        ProssesBarForm prossesBarForm = new ProssesBarForm();
        String token = new Scanner(new File("/home/ali/Desktop/a.txt")).useDelimiter("\\Z").next();

        HttpResponse<String> response = null;

        if (token != null) {

            response = Unirest.get(UrlUtil.getUrlString() + "/myuser")
                    .header("content-type", "application/json")
                    .header("X-AUTH-TOKEN", token)
                    .asString();
        }

        if (response.getStatus() == 200) {

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(response.getBody());

            UserTo userTo = new UserTo();
            UserTo.setId((Long) jsonObject.get("id"));
            UserTo.setUsername((String) jsonObject.get("userName"));
            UserTo.setAuthToken((String) jsonObject.get("authToken"));
            UserTo.setLastSeen((Long) jsonObject.get("lastSeen"));
            UserTo.setEmail((String) jsonObject.get("email"));
            UserTo.setPassword((String) jsonObject.get("passWord"));
            UserTo.setPicAddress((String) jsonObject.get("PicAddress"));

            new MainPanel();
            UserForm u = new UserForm();
            u.getIdlabel().setText(String.valueOf(userTo.getId()));
            u.getNamelabel().setText(userTo.getUsername());
            u.getLastseenlabel().setText(String.valueOf(userTo.getLastSeen()));

            prossesBarForm.getjFrame().dispose();



        } else {

            new SignIn_SignUpForm();
            prossesBarForm.getjFrame().dispose();


        }

////////////////////////////////////////////

//        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/ali/Desktop/a.txt"));
//        writer.write("baba");
//        writer.close();




//        String s = "#ali#baba#yahoo#ali#baba#yahoo";
//            List list = new ArrayList();
//            List tags = new ArrayList();
//            int b ;
//            for (int i =0;i<s.length();i++){
//                if (s.charAt(i)=='#'){
//                   list.add(i);
//           }
//       }
//        list.add(s.length());
//        for (int j =0;j<list.size()-1;j++){
//            tags.add(s.substring(1+Integer.valueOf((Integer) list.get(j)), Integer.valueOf((Integer) list.get(j+1))));
//        }

//        JSONObject jsonObject1 = new JSONObject();
//        JSONObject jsonObject2 = new JSONObject();
//        JSONArray jsonArray2 = new JSONArray();
//
//        jsonObject1.put("id", null);
//        jsonObject1.put("content", "baba");
//        jsonObject1.put("picAddress", "salam");
//        jsonObject2.put("id", 1);
//        jsonObject1.put("writer", jsonObject2);
//
//        // System.out.println(TagTo.getIdForPost());
//
//        for (int p = 0; p < 2; p++) {
//            JSONObject j = new JSONObject();
//            j.put("id",p);
//            jsonArray2.add(j);
//        }
////                JSONObject jsonObject3 = new JSONObject();
////                jsonObject3.put("tags",jsonArray2);
//        jsonObject1.put("tags", jsonArray2);
//
//        System.out.println(jsonObject1.toJSONString());


     //   System.out.println(tags);



    }
}
