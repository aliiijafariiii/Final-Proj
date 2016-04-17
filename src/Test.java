import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import model.to.UserTo;
import model.util.UrlUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ali on 4/8/16.
 */
public class Test {
    public static void main(String[] args) throws Exception{
////        System.out.println(new Date().getTime());
////        Long l = 1460104224088L;
////
//        DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
//        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
////        Date date = new Date(l);
////        System.out.println(dateFormat1.format(date));
////        System.out.println(dateFormat2.format(date));
////        while (true){
////            Thread.sleep(3600000);
////            System.out.println(new Date().getTime());
////
////        }
//        Date date = new Date();
//        System.out.println(dateFormat1.format(date)+" "+dateFormat2.format(date));
////        System.out.println(dateFormat2.format(new Date()));
////        System.out.println(new Date());

//        long s = new Date().getTime();
////        Date d = new Date(s);
////        System.out.println(d);

//        JFrame f = new JFrame();
//       // ImageIcon i  = (ImageIcon) Unirest.get("http://localhost:9000/assets/images/favicon.png").getBody();
//        //ImageIcon i = new ImageIcon("http://localhost:9000/assets/images/favicon.png");
//        URL url = new URL("http://localhost:9000/assets/images/favicon.png");
//        Image image = ImageIO.read(url);
//        ImageIcon icon = new ImageIcon(image);
//        JLabel l = new JLabel(icon);
//
//
//        f.add(l);
//        f.setVisible(true);
//        f.setSize(500,500);

        System.out.println(new Date().getTime());



    }
}
