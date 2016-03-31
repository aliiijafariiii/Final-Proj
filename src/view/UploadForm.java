package view;



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

    private static JTextField contentText;
    private static File image;
    private static JTextField tagField;
    private static JButton addtag,addimage,uploadpost,exitbtn;
    private static JLabel taglabel,contentNamelbl,imagelabel,imageTextlbl,taglbl;

    public UploadForm(){
        final JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 1));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10,1));

        contentText = new JTextField();
        contentText.setHorizontalAlignment(JTextField.CENTER);
        tagField = new JTextField();
        tagField.setHorizontalAlignment(JTextField.CENTER);
        exitbtn = new JButton("Exit");
        exitbtn.setBackground(Color.orange);
        exitbtn.setForeground(Color.white);
        addtag = new JButton("Add Tag");
        addtag.setBackground(Color.orange);
        addtag.setForeground(Color.white);
        addimage = new JButton("Add Image");
        addimage.setBackground(Color.orange);
        addimage.setForeground(Color.white);
        uploadpost = new JButton("Upload");
        uploadpost.setEnabled(false);
        uploadpost.setBackground(Color.orange);
        uploadpost.setForeground(Color.white);
        imageTextlbl = new JLabel("please choose an image",SwingConstants.CENTER);
        taglbl = new JLabel("please type tags and click Add Tag button",SwingConstants.CENTER);
        taglabel = new JLabel();
        contentNamelbl = new JLabel("please add content text for this image",SwingConstants.CENTER);

        imagelabel = new JLabel(new ImageIcon("/home/ali/Desktop/imageDefult.png"),SwingConstants.CENTER);
        imagelabel.setSize(500,500);
        imagelabel.setBorder(new LineBorder(Color.black));

        panel.add(imageTextlbl);
        panel.add(addimage);
        panel.add(contentNamelbl);
        panel.add(contentText);
        panel.add(taglbl);
        panel.add(tagField);
        panel.add(taglabel);
        panel.add(addtag);
        panel.add(uploadpost);
        panel.add(exitbtn);

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
                    int width = bimg.getWidth();
                    int height = bimg.getHeight();

                    if (width<500 && height<500){
                        addimage.setText("change");
                        uploadpost.setEnabled(true);
                        imagelabel.setIcon(new ImageIcon(image.getPath()));}
                    else{
                        JOptionPane.showMessageDialog(null,"image size should under 500X500");
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
