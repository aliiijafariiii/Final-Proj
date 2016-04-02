import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import model.to.UserTo;
import model.util.UrlUtil;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import view.MainPanel;
import view.SignIn_SignUpForm;
import view.UploadForm;
import view.UserForm;

import java.io.*;
import java.util.Scanner;

/**
 * Created by ali on 1/22/2016.
 */
public class Main {

    public static void main(String[] args) throws Exception {
//
//
//        String token = new Scanner(new File("/home/ali/Desktop/a.txt")).useDelimiter("\\Z").next();
//
//        HttpResponse<String> response = null;
//
//        if (token != null) {
//
//            response = Unirest.get(UrlUtil.getUrlString() + "/myuser")
//                    .header("content-type", "application/json")
//                    .header("X-AUTH-TOKEN", token)
//                    .asString();
//        }
//
//
//        if (response.getStatus() == 200) {
//
//            System.out.println(response.getBody());
//
//            JSONParser jsonParser = new JSONParser();
//            JSONObject jsonObject = (JSONObject) jsonParser.parse(response.getBody());
//
//            UserTo userTo = new UserTo();
//            userTo.setId((Long) jsonObject.get("id"));
//            userTo.setUsername((String) jsonObject.get("userName"));
//            userTo.setAuthToken((String) jsonObject.get("authToken"));
//            userTo.setPicAddress((String) jsonObject.get("picAddress"));
//
//            new MainForm();
//
//
//        } else {
//
//            new SignIn_SignUpForm();
//        }

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
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost uploadFile = new HttpPost("http://localhost:9000/users/upload");

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
       // builder.addTextBody("field1", "yes", ContentType.TEXT_PLAIN);
        builder.addBinaryBody("picture", new File("/home/ali/Desktop/a.jpg"), ContentType.MULTIPART_FORM_DATA, "file.jpg");
        HttpEntity multipart = builder.build();

        uploadFile.setEntity(multipart);

        CloseableHttpResponse response = httpClient.execute(uploadFile);
        HttpEntity responseEntity = response.getEntity();
        System.out.println(response.getStatusLine().getStatusCode());

//////////////////////////////
//
//new MainForm();


//        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/ali/Desktop/a.txt"));
//        writer.write("baba");
//        writer.close();
       // new UserForm();
     //   new MainPanel();

    }
}
