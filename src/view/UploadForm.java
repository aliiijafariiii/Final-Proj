package view;

import net.miginfocom.swing.MigLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;




/**
 * Created by ali on 3/30/16.
 */
public class UploadForm {

    private static JTextArea contentText;
    private static File image;
    private static JTextField tagField;
    private static JButton addtag,addimage,uploadpost,exitbtn;
    private static JLabel taglabel,imageurl,imagelabel;

    public UploadForm(){
        final JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 1));

        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout());

        contentText = new JTextArea(5,40);
        tagField = new JTextField(15);
        exitbtn = new JButton("exit");
        addtag = new JButton("Add Tag");
        addimage = new JButton("Add Image");
        uploadpost = new JButton("Upload");
        uploadpost.setEnabled(false);
        taglabel = new JLabel();
        imageurl = new JLabel("url");

        imagelabel = new JLabel(new ImageIcon("/home/ali/Desktop/imageDefult.png"),SwingConstants.CENTER);
        imagelabel.setSize(500,500);
        imagelabel.setBorder(new LineBorder(Color.black));

        panel.add(addimage,"cell 0 0");
        panel.add(imageurl,"cell 1 0");
        panel.add(contentText,"cell 0 1 3 1");
        panel.add(tagField,"cell 0 2");
        panel.add(addtag,"cell 0 3");
        panel.add(taglabel,"cell 1 3");
        panel.add(uploadpost,"cell 0 4");
        panel.add(exitbtn,"cell 1 4");

        addimage.addActionListener(new ActionListener() {
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
                    int width          = bimg.getWidth();
                    int height         = bimg.getHeight();

                    if (width<500 && height<500){
                        addimage.setText("change");
                        imageurl.setText("");
                        imageurl.setText(image.getPath());
                        uploadpost.setEnabled(true);
                        imagelabel.setIcon(new ImageIcon(image.getPath()));}
                    else{
                        JOptionPane.showMessageDialog(null,"image should under 500X500");
                    }
                    }
            }
            });

        addtag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!tagField.getText().equals("")){
                    taglabel.setText(taglabel.getText()+"|"+tagField.getText());
                    tagField.setText("");
                }
            }
        });

        exitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.add(imagelabel);
        frame.add(panel);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}
