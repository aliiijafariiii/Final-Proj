package view.util;

import controller.SearchController;
import view.mainForms.ReviewForm;
import view.mainForms.UserForm;

import javax.naming.directory.SearchControls;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ali on 9/1/16.
 */
public class SearchForm {
    private static JTextField searchText;
    private static JButton searchBtn,exitBtn,showProfileBtn,showPostsBtn;
    private static DefaultListModel<String> UsersDTM;
    private static JList<String> userList;
    private static JFrame frame;

    public static JTextField getSearchText() {
        return searchText;
    }

    public static void setSearchText(JTextField searchText) {
        SearchForm.searchText = searchText;
    }

    public static JButton getSearchBtn() {
        return searchBtn;
    }

    public static void setSearchBtn(JButton searchBtn) {
        SearchForm.searchBtn = searchBtn;
    }

    public static JButton getExitBtn() {
        return exitBtn;
    }

    public static void setExitBtn(JButton exitBtn) {
        SearchForm.exitBtn = exitBtn;
    }

    public static JButton getShowProfileBtn() {
        return showProfileBtn;
    }

    public static void setShowProfileBtn(JButton showProfileBtn) {
        SearchForm.showProfileBtn = showProfileBtn;
    }

    public static JButton getShowPostsBtn() {
        return showPostsBtn;
    }

    public static void setShowPostsBtn(JButton showPostsBtn) {
        SearchForm.showPostsBtn = showPostsBtn;
    }

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
        SearchForm.userList = userList;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame frame) {
        SearchForm.frame = frame;
    }

    public SearchForm() {
        frame = new JFrame();
        searchText = new JTextField();
        searchText.setHorizontalAlignment(SwingConstants.CENTER);

        searchBtn = new JButton("Search");
        searchBtn.setBackground(new Color(27, 202, 0));
        searchBtn.setForeground(Color.white);

        exitBtn = new JButton("Exit");
        exitBtn.setBackground(new Color(27, 202, 0));
        exitBtn.setForeground(Color.white);

        showProfileBtn = new JButton("Profile");
        showProfileBtn.setBackground(new Color(27, 202, 0));
        showProfileBtn.setForeground(Color.white);
        showProfileBtn.setEnabled(false);

        showPostsBtn = new JButton("Posts");
        showPostsBtn.setBackground(new Color(27, 202, 0));
        showPostsBtn.setForeground(Color.white);
        showPostsBtn.setEnabled(false);

        UsersDTM= new DefaultListModel<String>();
        userList= new JList<>(UsersDTM);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,2));

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(3,1));
        JLabel label = new JLabel("Please type word to search:");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel label1 = new JLabel("Search result:");
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        showProfileBtn.addActionListener(SearchController.getProfileController());
        showProfileBtn.setActionCommand("ShowProfileOfUser");

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        showPostsBtn.addActionListener(SearchController.getProfileController());
        showPostsBtn.setActionCommand("ShowPostsOfUser");

        searchBtn.addActionListener(SearchController.getProfileController());
        searchBtn.setActionCommand("SearchForUsers");

        top.add(label);
        top.add(searchText);
        top.add(label1);

        panel.add(top);
        panel.add(new JScrollPane(userList));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,1));

        panel2.add(searchBtn);

        panel1.add(showPostsBtn);
        panel1.add(showProfileBtn);

        panel2.add(panel1);
        panel2.add(exitBtn);

        panel.add(panel2);

        frame.add(panel);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
