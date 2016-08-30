package view.util;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ali on 8/28/16.
 */
public class ListForm {
    private static DefaultListModel<String> UsersDTM;
    private static JList<String> userList;
    private static JFrame jFrame;

    public static DefaultListModel<String> getUsersDTM() {
        return UsersDTM;
    }

    public static void setUsersDTM(DefaultListModel<String> usersDTM) {
        UsersDTM = usersDTM;
    }

    public static JList<String> getUserList() {
        return userList;
    }

    public static void setUserList(JList<String> userList) {
        ListForm.userList = userList;
    }

    public static JFrame getjFrame() {
        return jFrame;
    }

    public static void setjFrame(JFrame jFrame) {
        ListForm.jFrame = jFrame;
    }

    public ListForm() {
        jFrame = new JFrame();

        UsersDTM= new DefaultListModel<String>();
        userList= new JList<>(UsersDTM);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));

        panel.add(new JScrollPane(userList));

        jFrame.add(panel);
        jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jFrame.setSize(150, 250);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
    }
}
