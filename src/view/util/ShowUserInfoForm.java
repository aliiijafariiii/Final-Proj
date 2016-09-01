package view.util;

import controller.SignIn_SignUpController;
import model.util.Utils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by ali on 9/1/16.
 */
public class ShowUserInfoForm {


    private static JLabel piclabel, titlelabel, idlabel, namelabel, lastseenlabel;
    private static JFrame frame;
    private static JButton exit;


    public static JLabel getIdlabel() {
        return idlabel;
    }

    public static void setIdlabel(JLabel idlabel) {
        ShowUserInfoForm.idlabel = idlabel;
    }

    public static JLabel getNamelabel() {
        return namelabel;
    }

    public static void setNamelabel(JLabel namelabel) {
        ShowUserInfoForm.namelabel = namelabel;
    }

    public static JLabel getLastseenlabel() {
        return lastseenlabel;
    }

    public static void setLastseenlabel(JLabel lastseenlabel) {
        ShowUserInfoForm.lastseenlabel = lastseenlabel;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame frame) {
        ShowUserInfoForm.frame = frame;
    }

    public ShowUserInfoForm() {
        frame = new JFrame();
        frame.setLayout(new GridLayout(2, 1));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        piclabel = new JLabel(new ImageIcon(Utils.getAddressString() + "/imageDefult.png"), SwingConstants.CENTER);
        piclabel.setBorder(new LineBorder(Color.black));
        titlelabel = new JLabel("User Info", SwingConstants.CENTER);
        idlabel = new JLabel("216489", SwingConstants.CENTER);
        namelabel = new JLabel("Ali Jafari", SwingConstants.CENTER);
        lastseenlabel = new JLabel(String.valueOf(new Date().getTime()), SwingConstants.CENTER);
        exit = new JButton("Close");
        exit.setBackground(new Color(27, 202, 0));
        exit.setForeground(Color.white);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });



        panel.add(titlelabel);
        panel.add(idlabel);
        panel.add(namelabel);
        panel.add(lastseenlabel);
        panel.add(exit);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double w = screenSize.getWidth();
        double h = screenSize.getHeight();


        frame.add(piclabel);
        frame.add(panel);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 400);
//        frame.setLocation((int) (w - 200), 0);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
