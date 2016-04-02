import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import model.to.UserTo;
import model.util.UrlUtil;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import view.MainPanel;
import view.SignIn_SignUpForm;
import view.mainForms.UserForm;
import view.util.ProssesBarForm;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;
import java.util.Date;
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
            userTo.setId((Long) jsonObject.get("id"));
            userTo.setUsername((String) jsonObject.get("userName"));
            userTo.setAuthToken((String) jsonObject.get("authToken"));
            userTo.setLastSeen((Long) jsonObject.get("lastSeen"));
            userTo.setEmail((String) jsonObject.get("email"));
            userTo.setPassword((String) jsonObject.get("passWord"));
            userTo.setPicAddress((String) jsonObject.get("PicAddress"));

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

///////////////////////////////////////////////////////////////////////////////////////////////////////////
//        HttpResponse<String> response = Unirest.post("http://192.168.1.8:9000/users")
//                .header("content-type", "application/json")
//                .header("cache-control", "no-cache")
//                .header("postman-token", "bf1fcf6b-968e-be14-4e03-8b95cd7c59ae")
//                .body("{\"id\":null,\"userName\":\"Daei2\",\"posts\":null}")
//                .asString();
//
//        System.out.println(response.getBody());
///////////////////////////////////////////////////////////////////////////////////////////////////////////
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost uploadFile = new HttpPost("http://localhost:9000/users/upload");
//        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        builder.addBinaryBody("picture", new File("/home/ali/Desktop/a.jpg"), ContentType.MULTIPART_FORM_DATA, "file.jpg");
//        HttpEntity multipart = builder.build();
//        uploadFile.setEntity(multipart);
//        CloseableHttpResponse uploadResponse = httpClient.execute(uploadFile);
//        System.out.println(uploadResponse.getStatusLine().getStatusCode());

//////////////////////////////
//
//new MainForm();


//        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/ali/Desktop/a.txt"));
//        writer.write("baba");
//        writer.close();
       // new UserForm();
     //   new MainPanel();




//        /////////////////////
//        ProssesBarForm prossesBarForm = new ProssesBarForm();
//        Thread.sleep(5000);
//        prossesBarForm.getjFrame().dispose();



    }
}
