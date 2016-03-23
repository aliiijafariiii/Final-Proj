import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import model.to.UserTo;
import model.util.UrlUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.MainForm;
import view.SignIn_SignUpForm;

import java.io.*;
import java.util.Scanner;

/**
 * Created by ali on 1/22/2016.
 */
public class Main {

    public static void main(String[] args) throws Exception {


        String token = new Scanner(new File("/home/ali/Desktop/a.txt")).useDelimiter("\\Z").next();

        HttpResponse<String> response = null;

        if (token != null) {

            response = Unirest.get(UrlUtil.getUrlString() + "/myuser")
                    .header("content-type", "application/json")
                    .header("X-AUTH-TOKEN", token)
                    .asString();
        }


        if (response.getStatus() == 200) {

            System.out.println(response.getBody());

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(response.getBody());

            UserTo userTo = new UserTo();
            userTo.setId((Long) jsonObject.get("id"));
            userTo.setUsername((String) jsonObject.get("userName"));
            userTo.setAuthToken((String) jsonObject.get("authToken"));
            userTo.setPicAddress((String) jsonObject.get("picAddress"));

            new MainForm();


        } else {

            new SignIn_SignUpForm();
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
//        HttpResponse<String> responsee = Unirest.post("http://192.168.1.8:9000/users/upload")
//                .header("content-type", "multipart/form-data; boundary=---011000010111000001101001")
//                .header("cache-control", "no-cache")
//                .header("postman-token", "f4818ede-5aa8-0b7e-7d15-802f109ba7de")
//                .body("-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"picture\"; filename=\"Elecomp-01.jpg\"\r\nContent-Type: image/jpeg\r\n\r\n\r\n-----011000010111000001101001--")
//                .asString();
//        System.out.println(response.getBody());
        ///////////////////////////////////////////////////////////////////////////////////
//
//new MainForm();


//        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/ali/Desktop/a.txt"));
//        writer.write("baba");
//        writer.close();


    }
}
