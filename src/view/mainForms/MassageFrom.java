package view.mainForms;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MassageFrom {
    private static JButton sendbtn,exit,clear;
    private static JTextArea textArea;
    private static DefaultListModel<String>  historyDTM,friendDTM;

    public static JButton getSendbtn() {
        return sendbtn;
    }

    public static void setSendbtn(JButton sendbtn) {
        MassageFrom.sendbtn = sendbtn;
    }

    public static JButton getExit() {
        return exit;
    }

    public static void setExit(JButton exit) {
        MassageFrom.exit = exit;
    }

    public static JButton getClear() {
        return clear;
    }

    public static void setClear(JButton clear) {
        MassageFrom.clear = clear;
    }

    public static JTextArea getTextArea() {
        return textArea;
    }

    public static void setTextArea(JTextArea textArea) {
        MassageFrom.textArea = textArea;
    }

    public static DefaultListModel<String> getHistoryDTM() {
        return historyDTM;
    }

    public static void setHistoryDTM(DefaultListModel<String> historyDTM) {
        MassageFrom.historyDTM = historyDTM;
    }

    public static DefaultListModel<String> getFriendDTM() {
        return friendDTM;
    }

    public static void setFriendDTM(DefaultListModel<String> friendDTM) {
        MassageFrom.friendDTM = friendDTM;
    }

    public MassageFrom() {
        final JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1, 2));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1,1));
        panel1.setBorder(new TitledBorder("Chat History"));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,1));
        panel2.setBorder(new TitledBorder("your Friends"));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2,1));



        historyDTM = new DefaultListModel<String>();
        friendDTM = new DefaultListModel<String>();
        JList<String> historyList = new JList<>(historyDTM);
        JList<String> friendList = new JList<>(friendDTM);


        for (int i = 0 ; i<20;i++){
            historyDTM.addElement(String.valueOf(i));
            friendDTM.addElement(String.valueOf(i*10));
        }


        historyList.setFont(new Font(null,Font.BOLD,25));
        historyList.setForeground(Color.red);
        historyList.setSelectedIndex(0);

        friendList.setFont(new Font(null,Font.BOLD,25));
        friendList.setForeground(Color.YELLOW);
        friendList.setSelectedIndex(0);

        historyList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(historyList.getSelectedValue());
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

        textArea = new JTextArea();
        sendbtn = new JButton("send");
        exit = new JButton("exit");
        clear = new JButton("clear");

        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(4,1));
        panel4.setBorder(new TitledBorder("new message"));

        JLabel jLabel = new JLabel("aaaa");

        panel4.add(textArea);
        panel4.add(sendbtn);
        panel4.add(clear);
        panel4.add(exit);


        panel3.add(jLabel);
        panel3.add(panel4);


        panel1.add(new JScrollPane(historyList));
        panel2.add(new JScrollPane(friendList));

        panel.add(panel2);
        panel.add(panel1);


        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        frame.add(panel);
        frame.add(panel3);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
