package view.util;

import javax.swing.*;
import java.awt.*;

public class ProssesBarForm {

    private static JFrame jFrame;

    public static JFrame getjFrame() {
        return jFrame;
    }

    public ProssesBarForm() {

        jFrame = new JFrame();
        jFrame.setLayout(new GridLayout(2,1));

        JLabel titlelabel = new JLabel("Please Wait!",SwingConstants.CENTER);

        int min = 0;
        int max = 1;
        JProgressBar progress = new JProgressBar(min, max);
        progress.setIndeterminate(true);


        jFrame.setUndecorated(true);
        jFrame.add(titlelabel);
        jFrame.add(progress);
        jFrame.setSize(300,50);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }
}
