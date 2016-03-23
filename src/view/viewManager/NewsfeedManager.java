package view.viewManager;

import net.miginfocom.swing.MigLayout;
import view.MainForm;

import javax.swing.*;

/**
 * Created by Ali on 2/21/2016.
 */
public class NewsfeedManager {
    private static JLabel namelbl,piclbl,timelbl,postimagelbl;
    private static JButton likebtn,dislikebtn,commentbtn;
    private static JPanel basePanel;


    public static JLabel getNamelbl() {
        return namelbl;
    }

    public static void setNamelbl(JLabel namelbl) {
        NewsfeedManager.namelbl = namelbl;
    }

    public static JLabel getPiclbl() {
        return piclbl;
    }

    public static void setPiclbl(JLabel piclbl) {
        NewsfeedManager.piclbl = piclbl;
    }

    public static JLabel getTimelbl() {
        return timelbl;
    }

    public static void setTimelbl(JLabel timelbl) {
        NewsfeedManager.timelbl = timelbl;
    }

    public static JLabel getPostimagelbl() {
        return postimagelbl;
    }

    public static void setPostimagelbl(JLabel postimagelbl) {
        NewsfeedManager.postimagelbl = postimagelbl;
    }

    public static JButton getLikebtn() {
        return likebtn;
    }

    public static void setLikebtn(JButton likebtn) {
        NewsfeedManager.likebtn = likebtn;
    }

    public static JButton getDislikebtn() {
        return dislikebtn;
    }

    public static void setDislikebtn(JButton dislikebtn) {
        NewsfeedManager.dislikebtn = dislikebtn;
    }

    public static JButton getCommentbtn() {
        return commentbtn;
    }

    public static void setCommentbtn(JButton commentbtn) {
        NewsfeedManager.commentbtn = commentbtn;
    }

    public static JPanel getBasePanel() {
        return basePanel;
    }

    public static void setBasePanel(JPanel basePanel) {
        NewsfeedManager.basePanel = basePanel;
    }

    public NewsfeedManager() {
        namelbl = new JLabel("");
        piclbl = new JLabel();
        timelbl = new JLabel("");
        postimagelbl = new JLabel();

        likebtn = new JButton("like");
        dislikebtn = new JButton("dislike");
        commentbtn = new JButton("comment");

        basePanel = new JPanel();
        basePanel.setLayout(new MigLayout());

        basePanel.add(piclbl,"cell 0 0");
        basePanel.add(namelbl,"cell 0 0");
        basePanel.add(timelbl,"cell 1 0");
        basePanel.add(postimagelbl,"cell 0 1 2 1");
        basePanel.add(likebtn,"cell 0 2");
        basePanel.add(dislikebtn,"cell 0 2");
        basePanel.add(commentbtn,"cell 0 2");
    }
}
