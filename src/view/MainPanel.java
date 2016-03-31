package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ali on 3/30/16.
 */
public class MainPanel  {

    private static JButton profilebtn,feedbtn,friendbtn,massagingbtn,uploadbtn,searchbtn,settingbtn,exitbtn;
    private static JFrame frame;

    public MainPanel() {
        frame = new JFrame();
        frame.setLayout(new GridLayout(1, 8));

        profilebtn = new JButton();
        feedbtn= new JButton();
        friendbtn= new JButton();
        massagingbtn= new JButton();
        uploadbtn= new JButton();
        searchbtn= new JButton();
        settingbtn= new JButton();
        exitbtn= new JButton();

        ImageIcon profileicon = new ImageIcon("/home/ali/Desktop/iconss/profile.png");
        ImageIcon feedicon = new ImageIcon("/home/ali/Desktop/iconss/news.png");
        ImageIcon friendicon = new ImageIcon("/home/ali/Desktop/iconss/friend.png");
        ImageIcon massageicon = new ImageIcon("/home/ali/Desktop/iconss/message.png");
        ImageIcon uploadicon = new ImageIcon("/home/ali/Desktop/iconss/upload.png");
        ImageIcon searchicon = new ImageIcon("/home/ali/Desktop/iconss/search.png");
        ImageIcon settingicon = new ImageIcon("/home/ali/Desktop/iconss/setting.png");
        ImageIcon exiticon = new ImageIcon("/home/ali/Desktop/iconss/exit.png");

        profilebtn.setIcon(profileicon);
        profilebtn.setFocusPainted(false);
        profilebtn.setContentAreaFilled(false);
        profilebtn.setToolTipText("Show Your Profile");

        feedbtn.setIcon(feedicon);
        feedbtn.setFocusPainted(false);
        feedbtn.setContentAreaFilled(false);
        feedbtn.setToolTipText("See News Feed");

        friendbtn.setIcon(friendicon);
        friendbtn.setFocusPainted(false);
        friendbtn.setContentAreaFilled(false);
        friendbtn.setToolTipText("See your Friends And Relationship");

        massagingbtn.setIcon(massageicon);
        massagingbtn.setFocusPainted(false);
        massagingbtn.setContentAreaFilled(false);
        massagingbtn.setToolTipText("Send Massage To Your Friends");

        uploadbtn.setIcon(uploadicon);
        uploadbtn.setFocusPainted(false);
        uploadbtn.setContentAreaFilled(false);
        uploadbtn.setToolTipText("Post New Image");

        searchbtn.setIcon(searchicon);
        searchbtn.setFocusPainted(false);
        searchbtn.setContentAreaFilled(false);
        searchbtn.setToolTipText("Discover");

        settingbtn.setIcon(settingicon);
        settingbtn.setFocusPainted(false);
        settingbtn.setContentAreaFilled(false);
        settingbtn.setToolTipText("Manage Your Acount");

        exitbtn.setIcon(exiticon);
        exitbtn.setFocusPainted(false);
        exitbtn.setContentAreaFilled(false);
        exitbtn.setToolTipText("Exit");

        exitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        uploadbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UploadForm();
            }
        });

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double w = screenSize.getWidth();

        frame.add(profilebtn);
        frame.add(feedbtn);
        frame.add(friendbtn);
        frame.add(massagingbtn);
        frame.add(uploadbtn);
        frame.add(searchbtn);
        frame.add(settingbtn);
        frame.add(exitbtn);

        frame.setLocation((int) ((w-800)/2),0);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 100);
        frame.setVisible(true);
    }
}
