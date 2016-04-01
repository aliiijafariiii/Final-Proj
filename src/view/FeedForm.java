package view;

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

    private static JLabel imagelabel,contentlabel,timelabel,postIdlabel;
    private static JButton nextPostbtn,prviousPostbtn,likeBtn,likersBtn,CommentBtn,CommentersBtn,tagsBtn,exitBtn;

    public FeedForm() {
        final JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3,1));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,2));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2,1));

        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(3,1));

        imagelabel = new JLabel(new ImageIcon("/home/ali/Desktop/imageDefult.png"),SwingConstants.CENTER);
        imagelabel.setSize(500,500);
        imagelabel.setBorder(new LineBorder(Color.black));

        postIdlabel = new JLabel("dslhfigg9gv5audh",SwingConstants.CENTER);
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

        panel1.add(postIdlabel);
        panel1.add(contentlabel);
        panel1.add(timelabel);

        panel2.add(prviousPostbtn);
        panel2.add(nextPostbtn);
        panel2.add(likeBtn);
        panel2.add(likersBtn);
        panel2.add(CommentBtn);
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


        frame.add(imagelabel);
        frame.add(panel4);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
