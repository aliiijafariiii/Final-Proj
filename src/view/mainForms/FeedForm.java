package view.mainForms;

import controller.PostController;
import model.util.Utils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by ali on 4/1/16.
 */
public class FeedForm {

    private static JLabel imagelabel,contentlabel,timelabel,postIdlabel,writeridlabel,fasele;
    private static JButton nextPostbtn,prviousPostbtn,likeBtn,likersBtn,dislikeBtn,dislikersBtn,CommentBtn,CommentersBtn,tagsBtn,exitBtn;

    public static JLabel getWriteridlabel() {
        return writeridlabel;
    }
    public static void setWriteridlabel(JLabel writeridlabel) {
        FeedForm.writeridlabel = writeridlabel;
    }
    public static JLabel getImagelabel() {
        return imagelabel;
    }
    public static void setImagelabel(JLabel imagelabel) {
        FeedForm.imagelabel = imagelabel;
    }
    public static JLabel getContentlabel() {
        return contentlabel;
    }
    public static void setContentlabel(JLabel contentlabel) {
        FeedForm.contentlabel = contentlabel;
    }
    public static JLabel getTimelabel() {
        return timelabel;
    }
    public static void setTimelabel(JLabel timelabel) {
        FeedForm.timelabel = timelabel;
    }
    public static JLabel getPostIdlabel() {
        return postIdlabel;
    }
    public static void setPostIdlabel(JLabel postIdlabel) {
        FeedForm.postIdlabel = postIdlabel;
    }
    public static JLabel getFasele() {
        return fasele;
    }
    public static void setFasele(JLabel fasele) {
        FeedForm.fasele = fasele;
    }
    public static JButton getNextPostbtn() {
        return nextPostbtn;
    }
    public static void setNextPostbtn(JButton nextPostbtn) {
        FeedForm.nextPostbtn = nextPostbtn;
    }
    public static JButton getPrviousPostbtn() {
        return prviousPostbtn;
    }
    public static void setPrviousPostbtn(JButton prviousPostbtn) {
        FeedForm.prviousPostbtn = prviousPostbtn;
    }
    public static JButton getLikeBtn() {
        return likeBtn;
    }
    public static void setLikeBtn(JButton likeBtn) {
        FeedForm.likeBtn = likeBtn;
    }
    public static JButton getLikersBtn() {
        return likersBtn;
    }
    public static void setLikersBtn(JButton likersBtn) {
        FeedForm.likersBtn = likersBtn;
    }
    public static JButton getDislikeBtn() {
        return dislikeBtn;
    }
    public static void setDislikeBtn(JButton dislikeBtn) {
        FeedForm.dislikeBtn = dislikeBtn;
    }
    public static JButton getDislikersBtn() {
        return dislikersBtn;
    }
    public static void setDislikersBtn(JButton dislikersBtn) {
        FeedForm.dislikersBtn = dislikersBtn;
    }
    public static JButton getCommentBtn() {
        return CommentBtn;
    }
    public static void setCommentBtn(JButton commentBtn) {
        CommentBtn = commentBtn;
    }
    public static JButton getCommentersBtn() {
        return CommentersBtn;
    }
    public static void setCommentersBtn(JButton commentersBtn) {
        CommentersBtn = commentersBtn;
    }
    public static JButton getTagsBtn() {
        return tagsBtn;
    }
    public static void setTagsBtn(JButton tagsBtn) {
        FeedForm.tagsBtn = tagsBtn;
    }
    public static JButton getExitBtn() {
        return exitBtn;
    }
    public static void setExitBtn(JButton exitBtn) {
        FeedForm.exitBtn = exitBtn;
    }

    public FeedForm() {
        final JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3,1));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,3));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2,1));

        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(3,1));

        imagelabel = new JLabel(new ImageIcon(Utils.getAddressString()+"/imageDefult.png"),SwingConstants.CENTER);
        imagelabel.setSize(500,500);
        imagelabel.setBorder(new LineBorder(Color.black));

        fasele = new JLabel();

        postIdlabel = new JLabel("dslhfigg9gv5audh",SwingConstants.CENTER);
        writeridlabel = new JLabel("dslhfigg9gv5audh",SwingConstants.CENTER);
        contentlabel = new JLabel("content",SwingConstants.CENTER);
        contentlabel.setBorder(new LineBorder(Color.black));
        timelabel = new JLabel(String.valueOf(new Date()),SwingConstants.CENTER);

        nextPostbtn = new JButton("Next");
        nextPostbtn.setBackground(Color.white);
        nextPostbtn.setForeground(new Color(235, 215, 55));
        prviousPostbtn = new JButton("Pervious");
        prviousPostbtn.setBackground(Color.white);
        prviousPostbtn.setForeground(new Color(235, 215, 55));
        likeBtn = new JButton("Like");
        likeBtn.setBackground(new Color(235, 215, 55));
        likeBtn.setForeground(Color.white);
        likersBtn = new JButton("Likers");
        likersBtn.setBackground(new Color(235, 215, 55));
        likersBtn.setForeground(Color.white);
        dislikeBtn = new JButton("Dislike");
        dislikeBtn.setBackground(new Color(235, 215, 55));
        dislikeBtn.setForeground(Color.white);
        dislikersBtn = new JButton("Dislikers");
        dislikersBtn.setBackground(new Color(235, 215, 55));
        dislikersBtn.setForeground(Color.white);
        CommentBtn = new JButton("Comment");
        CommentBtn.setBackground(new Color(235, 215, 55));
        CommentBtn.setForeground(Color.white);
        CommentersBtn = new JButton("Commenters");
        CommentersBtn.setBackground(new Color(235, 215, 55));
        CommentersBtn.setForeground(Color.white);
        tagsBtn = new JButton("Tags");
        tagsBtn.setBackground(new Color(235, 215, 55));
        tagsBtn.setForeground(Color.white);
        exitBtn = new JButton("Exit");
        exitBtn.setBackground(new Color(235, 215, 55));
        exitBtn.setForeground(Color.white);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1 ,2));
        p.add(writeridlabel);
        p.add(postIdlabel);
        panel1.add(p);
        panel1.add(contentlabel);
        panel1.add(timelabel);

        panel2.add(prviousPostbtn);
        panel2.add(fasele);
        panel2.add(nextPostbtn);
        panel2.add(likeBtn);
        panel2.add(dislikeBtn);
        panel2.add(CommentBtn);
        panel2.add(likersBtn);
        panel2.add(dislikersBtn);
        panel2.add(CommentersBtn);

        panel3.add(tagsBtn);
        panel3.add(exitBtn);

        panel4.add(panel1);
        panel4.add(panel2);
        panel4.add(panel3);

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        nextPostbtn.addActionListener(PostController.getPostController());
        nextPostbtn.setActionCommand("NextButton_FillNewsFeed");

        prviousPostbtn.addActionListener(PostController.getPostController());
        prviousPostbtn.setActionCommand("PrivousButton_FillNewsFeed");


        likeBtn.addActionListener(PostController.getPostController());
        likeBtn.setActionCommand("SendNewLike");

        dislikeBtn.addActionListener(PostController.getPostController());
        dislikeBtn.setActionCommand("SendNewDislike");

        CommentBtn.addActionListener(PostController.getPostController());
        CommentBtn.setActionCommand("SendNewComment");

        likersBtn.addActionListener(PostController.getPostController());
        likersBtn.setActionCommand("ShowLikes");

        dislikersBtn.addActionListener(PostController.getPostController());
        dislikersBtn.setActionCommand("ShowDislikes");

        CommentersBtn.addActionListener(PostController.getPostController());
        CommentersBtn.setActionCommand("ShowComments");


        frame.add(imagelabel);
        frame.add(panel4);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
