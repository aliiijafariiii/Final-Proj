package view.mainForms;

import controller.ProfileController;
import model.to.UserTo;
import model.util.Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ProfileForm {

    private static File image;
    private static JLabel imagelabel,fasele;
    private static JButton postsbtn,friendsbtn,aboutbtn,changeimagebtn,editprofilebtn,exitbtn;

    public static File getImage() {
        return image;
    }
    public static void setImage(File image) {
        ProfileForm.image = image;
    }
    public static JLabel getImagelabel() {
        return imagelabel;
    }
    public static void setImagelabel(JLabel imagelabel) {
        ProfileForm.imagelabel = imagelabel;
    }
    public static JLabel getFasele() {
        return fasele;
    }
    public static void setFasele(JLabel fasele) {
        ProfileForm.fasele = fasele;
    }
    public static JButton getPostsbtn() {
        return postsbtn;
    }
    public static void setPostsbtn(JButton postsbtn) {
        ProfileForm.postsbtn = postsbtn;
    }
    public static JButton getFriendsbtn() {
        return friendsbtn;
    }
    public static void setFriendsbtn(JButton friendsbtn) {
        ProfileForm.friendsbtn = friendsbtn;
    }
    public static JButton getAboutbtn() {
        return aboutbtn;
    }
    public static void setAboutbtn(JButton aboutbtn) {
        ProfileForm.aboutbtn = aboutbtn;
    }
    public static JButton getChangeimagebtn() {
        return changeimagebtn;
    }
    public static void setChangeimagebtn(JButton changeimagebtn) {
        ProfileForm.changeimagebtn = changeimagebtn;
    }
    public static JButton getEditprofilebtn() {
        return editprofilebtn;
    }
    public static void setEditprofilebtn(JButton editprofilebtn) {
        ProfileForm.editprofilebtn = editprofilebtn;
    }
    public static JButton getExitbtn() {
        return exitbtn;
    }
    public static void setExitbtn(JButton exitbtn) {
        ProfileForm.exitbtn = exitbtn;
    }

    public ProfileForm() {

        final JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,3));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,1));

        imagelabel = new JLabel(new ImageIcon(Utils.getAddressString()+"/imageDefult.png"),SwingConstants.CENTER);
        imagelabel.setSize(500,500);
        imagelabel.setBorder(new LineBorder(Color.black));

        postsbtn = new JButton("Posts");
        postsbtn.setForeground(new Color(29, 105, 0));
        postsbtn.setBackground(Color.white);
        postsbtn.setFont(new Font(null,Font.BOLD,35));

        friendsbtn = new JButton("Friends");
        friendsbtn.setForeground(new Color(29, 105, 0));
        friendsbtn.setBackground(Color.white);
        friendsbtn.setFont(new Font(null,Font.BOLD,35));

        aboutbtn = new JButton("About");
        aboutbtn.setForeground(new Color(29, 105, 0));
        aboutbtn.setBackground(Color.white);
        aboutbtn.setFont(new Font(null,Font.BOLD,35));

        panel1.add(postsbtn);
        panel1.add(friendsbtn);
        panel1.add(aboutbtn);

        changeimagebtn = new JButton("Click To Change Your Profile Image");
        changeimagebtn.setBackground(new Color(29, 105, 0));
        changeimagebtn.setForeground(Color.white);

        editprofilebtn = new JButton("Click To Change Your Profile Info");
        editprofilebtn.setBackground(new Color(29, 105, 0));
        editprofilebtn.setForeground(Color.white);

        exitbtn = new JButton("Save & Exit");
        exitbtn.setBackground(new Color(29, 105, 0));
        exitbtn.setForeground(Color.white);

        panel2.add(changeimagebtn);
        panel2.add(editprofilebtn);
        panel2.add(exitbtn);

        changeimagebtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    image = fc.getSelectedFile();

                    BufferedImage bimg = null;
                    try {
                        bimg = ImageIO.read(image);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    int width = bimg.getWidth();
                    int height = bimg.getHeight();

                    if (width<500 && height<500){
                        JOptionPane.showConfirmDialog(null,"Do You Want To Change Image?");

                        imagelabel.setIcon(new ImageIcon(image.getPath()));}
                    else{
                        JOptionPane.showMessageDialog(null,"image size should under 500X500");
                    }
                }
            }
        });

        aboutbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, UserTo.getDetails(),"read",JOptionPane.INFORMATION_MESSAGE);
            }
        });

//        editprofilebtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               String  s = JOptionPane.showInputDialog(null, "please write your text", "");
//
//            }
//        });

        exitbtn.addActionListener(ProfileController.getPostController());
        exitbtn.setActionCommand("");

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(3,1));

        fasele = new JLabel("This Is Your Profile!",SwingConstants.CENTER);

        panel3.add(fasele);
        panel3.add(panel1);
        panel3.add(panel2);

        frame.add(imagelabel);
        frame.add(panel3);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
