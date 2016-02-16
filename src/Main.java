import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import controller.SignIn_SignUpController;
import model.to.UserTo;
import model.util.UrlUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.MainForm;
import view.SignIn_SignUpForm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by ali on 1/22/2016.
 */
public class Main {

    public static void main(String[] args) throws Exception{

        File f = new File("C:\\test.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        StringBuffer sb = new StringBuffer();
        String eachLine = br.readLine();

        while (eachLine != null) {
            sb.append(eachLine);
            sb.append("\n");
            eachLine = br.readLine();
        }


        HttpResponse<String> response = Unirest.get(UrlUtil.getUrlString()+":9000/users")
                .header("content-type", "application/json")
                .header("X-AUTH-TOKEN", sb.toString())
                .asString();

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject= (JSONObject) jsonParser.parse(String.valueOf(response));

//
        if (response.getStatus()==200){
            UserTo userTo = new UserTo();
            userTo.setId((Long) jsonObject.get("id"));
            userTo.setUsername((String) jsonObject.get("userName"));
            userTo.setPicAddress((String) jsonObject.get("picAddress"));

            new MainForm();
        }else{
            new SignIn_SignUpForm();
        }
//        System.out.println(response.getBody());
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
//        HttpResponse<String> response = Unirest.post("http://192.168.1.8:9000/users/upload")
//                .header("content-type", "multipart/form-data; boundary=---011000010111000001101001")
//                .header("cache-control", "no-cache")
//                .header("postman-token", "f4818ede-5aa8-0b7e-7d15-802f109ba7de")
//                .body("-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"picture\"; filename=\"Elecomp-01.jpg\"\r\nContent-Type: image/jpeg\r\n\r\n\r\n-----011000010111000001101001--")
//                .asString();
//        System.out.println(response.getBody());
        ///////////////////////////////////////////////////////////////////////////////////


    }
}
