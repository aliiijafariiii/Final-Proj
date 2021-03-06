import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import model.to.UserTo;
import model.util.Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import view.primary.MainPanel;
import view.primary.SignIn_SignUpForm;
import view.mainForms.UserForm;
import view.util.ProssesBarForm;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by ali on 1/22/2016.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        ProssesBarForm prossesBarForm = new ProssesBarForm();
        String token = new Scanner(new File(Utils.getAddressString()+"/a.txt")).useDelimiter("\\Z").next();
        HttpResponse<String> response = null;
        if (token != null) {
            response = Unirest.get(Utils.getUrlString() + "/myuser")
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

            Date d = new Date(UserTo.getLastSeen());
            DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");

            u.getLastseenlabel().setText(dateFormat1.format(d)+" "+dateFormat2.format(d));


            prossesBarForm.getjFrame().dispose();
        } else {
            new SignIn_SignUpForm();
            prossesBarForm.getjFrame().dispose();
        }
///////////////////////////////////////////////////////////////

//new SignIn_SignUpForm();


///////////////////////////////////////////////////////////////
//        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/ali/Desktop/b.txt"));
//        writer.write("baba");
//        writer.close();
//                new MassageFrom();




    }
}
