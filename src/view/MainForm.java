package view;

import controller.MainFormController;
import controller.SignIn_SignUpController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;


/**
 * Created by ali on 1/25/2016.
 */
public class MainForm {

    private static JTabbedPane tp;
    private static JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8;
    private static JTextArea postcontent;
    private static JButton refreshFeeds,sendnewpost,selectImage;
    private static File selectedFile;


    public static JTextArea getPostcontent() {
        return postcontent;
    }

    public static void setPostcontent(JTextArea postcontent) {
        MainForm.postcontent = postcontent;
    }

    public static JButton getRefreshFeeds() {
        return refreshFeeds;
    }

    public static void setRefreshFeeds(JButton refreshFeeds) {
        MainForm.refreshFeeds = refreshFeeds;
    }

    public static JButton getSendnewpost() {
        return sendnewpost;
    }

    public static void setSendnewpost(JButton sendnewpost) {
        MainForm.sendnewpost = sendnewpost;
    }

    public static JButton getSelectImage() {
        return selectImage;
    }

    public static void setSelectImage(JButton selectImage) {
        MainForm.selectImage = selectImage;
    }

    public static File getSelectedFile() {
        return selectedFile;
    }

    public static void setSelectedFile(File selectedFile) {
        MainForm.selectedFile = selectedFile;
    }

    public static JTabbedPane getTp() {
        return tp;
    }

    public static void setTp(JTabbedPane tp) {
        MainForm.tp = tp;
    }

    public static JPanel getPanel1() {
        return panel1;
    }

    public static void setPanel1(JPanel panel1) {
        MainForm.panel1 = panel1;
    }

    public static JPanel getPanel2() {
        return panel2;
    }

    public static void setPanel2(JPanel panel2) {
        MainForm.panel2 = panel2;
    }

    public static JPanel getPanel3() {
        return panel3;
    }

    public static void setPanel3(JPanel panel3) {
        MainForm.panel3 = panel3;
    }

    public static JPanel getPanel4() {
        return panel4;
    }

    public static void setPanel4(JPanel panel4) {
        MainForm.panel4 = panel4;
    }

    public static JPanel getPanel5() {
        return panel5;
    }

    public static void setPanel5(JPanel panel5) {
        MainForm.panel5 = panel5;
    }

    public static JPanel getPanel6() {
        return panel6;
    }

    public static void setPanel6(JPanel panel6) {
        MainForm.panel6 = panel6;
    }

    public static JPanel getPanel7() {
        return panel7;
    }

    public static void setPanel7(JPanel panel7) {
        MainForm.panel7 = panel7;
    }

    public static JPanel getPanel8() {
        return panel8;
    }

    public static void setPanel8(JPanel panel8) {
        MainForm.panel8 = panel8;
    }

    public MainForm() {
        tp = new JTabbedPane();
        panel1 = new JPanel();
        panel1.setBackground(Color.BLUE);
        panel2 = new JPanel();
        panel2.setBackground(Color.RED);
        panel3 = new JPanel();
        panel3.setBackground(Color.YELLOW);
        panel4 = new JPanel();
        panel4.setBackground(Color.ORANGE);
        panel5 = new JPanel();
        panel5.setBackground(Color.YELLOW);
        panel6 = new JPanel();
        panel6.setBackground(Color.ORANGE);
        panel7 = new JPanel();
        panel7.setBackground(Color.CYAN);
        panel8 = new JPanel();
        panel8.setBackground(Color.DARK_GRAY);

        refreshFeeds = new JButton("update");
        panel2.add(refreshFeeds);
        refreshFeeds.addActionListener(MainFormController.getMainFormController());
        refreshFeeds.setActionCommand("UpdateAndManageNewsFeed");

        postcontent = new JTextArea(10,100);
        selectImage = new JButton("add image");
        selectImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                int returnValue = jFileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    selectedFile = jFileChooser.getSelectedFile();
            }}
        });
        sendnewpost = new JButton("upload");

        sendnewpost.addActionListener(MainFormController.getMainFormController());
        sendnewpost.setActionCommand("SendNewPost");
        panel5.setLayout(new MigLayout());
        panel5.add(postcontent,"cell 0 0");
        panel5.add(selectImage,"cell 0 1");
        panel5.add(sendnewpost,"cell 0 2");

        tp.addTab("", panel1);
        tp.addTab("", panel2);
        tp.addTab("", panel3);
        tp.addTab("", panel4);
        tp.addTab("", panel5);
        tp.addTab("", panel6);
        tp.addTab("", panel7);
        tp.addTab("", panel8);


        ImageIcon imageIcon1 = new ImageIcon("/home/ali/Desktop/iconss/profile.png");
        ImageIcon imageIcon2 = new ImageIcon("/home/ali/Desktop/iconss/news.png");
        ImageIcon imageIcon3 = new ImageIcon("/home/ali/Desktop/iconss/friend.png");
        ImageIcon imageIcon4 = new ImageIcon("/home/ali/Desktop/iconss/search.png");
        ImageIcon imageIcon5 = new ImageIcon("/home/ali/Desktop/iconss/upload.png");
        ImageIcon imageIcon6 = new ImageIcon("/home/ali/Desktop/iconss/message.png");
        ImageIcon imageIcon7 = new ImageIcon("/home/ali/Desktop/iconss/setting.png");
        ImageIcon imageIcon8 = new ImageIcon("/home/ali/Desktop/iconss/exit.png");

        tp.setIconAt(0, imageIcon1);
        tp.setIconAt(1, imageIcon2);
        tp.setIconAt(2, imageIcon3);
        tp.setIconAt(3, imageIcon4);
        tp.setIconAt(4, imageIcon5);
        tp.setIconAt(5, imageIcon6);
        tp.setIconAt(6, imageIcon7);
        tp.setIconAt(7, imageIcon8);

        tp.setToolTipTextAt(0, "Profile");
        tp.setToolTipTextAt(1, "News Feed");
        tp.setToolTipTextAt(2, "Friends");
        tp.setToolTipTextAt(3, "Search");
        tp.setToolTipTextAt(4, "Upload");
        tp.setToolTipTextAt(5, "Massaging");
        tp.setToolTipTextAt(6, "Setting");
        tp.setToolTipTextAt(7, "Exit");

        tp.setTabPlacement(SwingConstants.LEFT);

        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(tp);
        frame.pack();
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

