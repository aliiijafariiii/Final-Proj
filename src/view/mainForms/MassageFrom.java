package view.mainForms;

import com.mashape.unirest.http.HttpResponse;
import controller.MessageController;
import model.bl.MessageManager;
import model.bl.MessageManagerImpl;
import model.to.UserTo;
import org.json.simple.JSONObject;
import view.util.ProssesBarForm;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

public class MassageFrom {
    private static JButton sendbtn,exit,clear;
    private static JTextArea textArea;
    private static DefaultListModel<String>  historyDTM,friendDTM;
    private static JList<String> friendList;
    private static JLabel massageLabel;
    private static JList<String> historyList;
    private static JFrame frame;

    public static JFrame getFrame() {
        return frame;
    }
    public static void setFrame(JFrame frame) {
        MassageFrom.frame = frame;
    }
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
        frame = new JFrame();
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
        historyList.setForeground(new Color(255, 22, 64));
        historyList.setBackground(Color.white);
        historyList.setSelectedIndex(0);

        friendList.setFont(new Font(null,0,20));
        friendList.setSelectedIndex(0);
        friendList.setBackground(new Color(255, 22, 64));
        friendList.setForeground(Color.white);

        historyList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ProssesBarForm prossesBarForm = new ProssesBarForm();
                    MessageManager messageManager = MessageManagerImpl.getMessageManager();
//                    int i = MassageFrom.getHistoryList().getSelectedValue().indexOf("-");
//                    String s = MassageFrom.getHistoryList().getSelectedValue().substring(0,i);
                    String s = String.valueOf(MassageFrom.getHistoryList().getSelectedValue().charAt(0));
                    HttpResponse<String> response = messageManager.getConversationForFill(Long.valueOf(s));

                    System.out.println(response.getBody());
                    MassageFrom.getMassageLabel().setText("");
                    if (response.getBody()!="[]"){
                        org.json.simple.parser.JSONParser jsonParser = new org.json.simple.parser.JSONParser();
                        org.json.simple.JSONArray jsonArray = (org.json.simple.JSONArray) jsonParser.parse(response.getBody());
                        Iterator<JSONObject> jsonObjectIterator = jsonArray.iterator();
                        while(jsonObjectIterator.hasNext()){
                            JSONObject jsonObject = jsonObjectIterator.next();
                            String sender = String.valueOf(jsonObject.get("sender"));
                            String content = String.valueOf(jsonObject.get("content"));
                            if (Long.valueOf(sender.substring(15,sender.length()-1))== UserTo.getId()){
                                if (MassageFrom.getMassageLabel().getText().length()!=0){
                                    int i = MassageFrom.getMassageLabel().getText().length();
                                    String n = MassageFrom.getMassageLabel().getText().substring(6,i-7);
                                    MassageFrom.getMassageLabel().setText("<html>"+n+"<br>"+ UserTo.getUsername()+":"+jsonObject.get("content")+"</html>");
                                }else{
                                    MassageFrom.getMassageLabel().setText("<html>"+ UserTo.getUsername()+":"+jsonObject.get("content")+"</html>");
                                }
                            }else{
                                if (MassageFrom.getMassageLabel().getText().length()!=0){
                                    int i = MassageFrom.getMassageLabel().getText().length();
                                    String n = MassageFrom.getMassageLabel().getText().substring(6,i-7);
                                    MassageFrom.getMassageLabel().setText("<html>"+n+"<br>"+ jsonObject.get("sender")+":"+jsonObject.get("content")+"</html>");
                                }else{
                                    MassageFrom.getMassageLabel().setText("<html>"+ jsonObject.get("sender")+":"+jsonObject.get("content")+"</html>");
                                }
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"no message yet","warning",JOptionPane.ERROR_MESSAGE);
                    }
                    prossesBarForm.getjFrame().dispose();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
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
        sendbtn.setBackground(new Color(255, 22, 64));
        sendbtn.setForeground(Color.white);

        exit = new JButton("exit");
        exit.setBackground(new Color(255, 22, 64));
        exit.setForeground(Color.white);

        clear = new JButton("clear");
        clear.setBackground(new Color(255, 22, 64));
        clear.setForeground(Color.white);

        JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayout(4,1));
        panel4.setBorder(new TitledBorder("new message"));

        massageLabel = new JLabel("MASSAGE DESK !");

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

        exit.addActionListener(MessageController.getMessageController());
        exit.setActionCommand("ExitMessageForm");

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
