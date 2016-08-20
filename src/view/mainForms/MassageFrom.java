package view.mainForms;

import controller.MessageController;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MassageFrom {
    private static JButton sendbtn,exit,clear;
    private static JTextArea textArea;
    private static DefaultListModel<String>  historyDTM,friendDTM;
    private static JList<String> friendList;
    private static JLabel massageLabel;



    public static JLabel getMassageLabel() {
        return massageLabel;
    }

    public static void setMassageLabel(JLabel massageLabel) {
        MassageFrom.massageLabel = massageLabel;
    }

    public static JList<String> getHistoryList() {
        return historyList;
    }

    public static void setHistoryList(JList<String> historyList) {
        MassageFrom.historyList = historyList;
    }

    private static JList<String> historyList;


    public static JButton getSendbtn() {
        return sendbtn;
    }

    public static JList<String> getFriendList() {
        return friendList;
    }

    public static void setFriendList(JList<String> friendList) {
        MassageFrom.friendList = friendList;
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
        historyList = new JList<>(historyDTM);
        friendList = new JList<>(friendDTM);

        historyList.setFont(new Font(null,0,20));
        historyList.setForeground(Color.red);
        historyList.setSelectedIndex(0);

        friendList.setFont(new Font(null,0,20));
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

        massageLabel = new JLabel();

        JScrollPane scroller = new JScrollPane(massageLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        panel4.add(textArea);
        panel4.add(sendbtn);
        panel4.add(clear);
        panel4.add(exit);


        panel3.add(scroller);
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

        sendbtn.addActionListener(MessageController.getMessageController());
        sendbtn.setActionCommand("SendNewMessage");


        frame.add(panel);
        frame.add(panel3);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
