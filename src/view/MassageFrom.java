package view;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MassageFrom {

    private static JLabel l1 ;

    public MassageFrom() {
        final JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1, 2));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,3));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,1));

        String[] selections = {"ali", "red", "orange", "dark blue" };






        final JList jList = new JList(selections);
        jList.setFont(new Font(null,Font.BOLD,25));
        jList.setForeground(Color.red);
        jList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(jList.getSelectedValue());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });





        panel1.add(jList);

        frame.add(panel1);
        frame.add(panel2);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
