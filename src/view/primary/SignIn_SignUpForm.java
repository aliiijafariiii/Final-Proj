package view.primary;

import controller.SignIn_SignUpController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.AttributedCharacterIterator;
import java.util.Map;

/**
 * Created by ali on 1/24/2016.
 */
public class SignIn_SignUpForm {

    private static JFrame frame;

    private static JTabbedPane tp;

    private static JTextField newUsername, newEmail,username;

    private static JPasswordField newPassword, reNewPassword, password;

    public static JFrame getFrame() {
        return frame;
    }

    public static JTextField getUsername() {
        return username;
    }

    public static JPasswordField getPassword() {
        return password;
    }

    public static JTextField getNewUsername() {
        return newUsername;
    }

    public static JTextField getNewEmail() {
        return newEmail;
    }

    public static JPasswordField getNewPassword() {
        return newPassword;
    }

    public static JPasswordField getReNewPassword() {
        return reNewPassword;
    }

    public SignIn_SignUpForm() {
        frame = new JFrame();
        tp = new JTabbedPane();
//        tp.setBackground(new Color(255, 184, 146));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(6,1));

        username = new JTextField(20);
        username.setText("Username");
        username.setForeground(Color.LIGHT_GRAY);
        username.setHorizontalAlignment(SwingConstants.CENTER);
        password = new JPasswordField(20);
        password.setText("Password");
        password.setEchoChar((char) 0);
        password.setForeground(Color.LIGHT_GRAY);
        password.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel OpenLabel1 = new JLabel("<html>Connect With Friends And <br> The World Around You On </html>");
        OpenLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel OpenLabel2 = new JLabel("<html><h1>PICBOOOOOK<h1></html>");
        OpenLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (username.getText().equals("Username")) {
                    username.setText("");
                    username.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (username.getText().equals("")) {
                    username.setText("Username");
                    username.setForeground(Color.LIGHT_GRAY);
                }
            }
        });
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (password.getText().equals("Password")) {
                    password.setText("");
                    password.setEchoChar('*');
                    password.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (password.getText().equals("")) {
                    password.setForeground(Color.LIGHT_GRAY);
                    password.setText("Password");
                    password.setEchoChar((char) 0);

                }
            }
        });

        JButton UsersignIN = new JButton("sign in");
        UsersignIN.addActionListener(SignIn_SignUpController.getUserSignUpController());
        UsersignIN.setActionCommand("signin");
        UsersignIN.setBackground(new Color(255, 184, 146));

        JButton exitSignin = new JButton("Exit");
        exitSignin.setBackground(new Color(255, 184, 146));
        exitSignin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });


        panel1.add(OpenLabel1);
        panel1.add(OpenLabel2);
        panel1.add(username);
        panel1.add(password);
        panel1.add(UsersignIN);
        panel1.add(exitSignin);
        ////////////////////////////

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(6,1));

        newUsername = new JTextField(20);
        newPassword = new JPasswordField(20);
        reNewPassword = new JPasswordField(20);
        newEmail = new JTextField(20);

        newUsername.setToolTipText("Please Enter Username");
        newPassword.setToolTipText("Please Enter Password");
        reNewPassword.setToolTipText("Please Re Enter Password");
        newEmail.setToolTipText("Please Enter Email");

        newUsername.setText("Please Enter Username");
        newUsername.setForeground(Color.LIGHT_GRAY);
        newUsername.setHorizontalAlignment(SwingConstants.CENTER);
        newPassword.setEchoChar((char) 0);
        newPassword.setText("Please Enter Password");
        newPassword.setForeground(Color.LIGHT_GRAY);
        newPassword.setHorizontalAlignment(SwingConstants.CENTER);
        reNewPassword.setEchoChar((char) 0);
        reNewPassword.setText("Please Re Enter Password");
        reNewPassword.setForeground(Color.LIGHT_GRAY);
        reNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
        newEmail.setText("Please Enter Email");
        newEmail.setForeground(Color.LIGHT_GRAY);
        newEmail.setHorizontalAlignment(SwingConstants.CENTER);

        newUsername.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (newUsername.getText().equals("Please Enter Username")) {
                    newUsername.setText("");
                    newUsername.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (newUsername.getText().equals("")) {
                    newUsername.setForeground(Color.LIGHT_GRAY);
                    newUsername.setText("Please Enter Username");

                }
            }
        });
        newPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (newPassword.getText().equals("Please Enter Password")) {
                    newPassword.setText("");
                    newPassword.setForeground(Color.black);
                    newPassword.setEchoChar('*');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (newPassword.getText().equals("")) {
                    newPassword.setForeground(Color.LIGHT_GRAY);
                    newPassword.setText("Please Enter Password");
                    newPassword.setEchoChar((char) 0);
                }

            }
        });
        reNewPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (reNewPassword.getText().equals("Please Re Enter Password")) {
                    reNewPassword.setText("");
                    reNewPassword.setForeground(Color.black);
                    reNewPassword.setEchoChar('*');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (reNewPassword.getText().equals("")) {
                    reNewPassword.setForeground(Color.LIGHT_GRAY);
                    reNewPassword.setText("Please Re Enter Password");
                    reNewPassword.setEchoChar((char) 0);
                }
            }
        });
        newEmail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (newEmail.getText().equals("Please Enter Email")) {
                    newEmail.setForeground(Color.black);
                    newEmail.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (newEmail.getText().equals("")) {
                    newEmail.setForeground(Color.LIGHT_GRAY);
                    newEmail.setText("Please Enter Email");
                }
            }
        });

        JButton UsersignUP = new JButton("sign up");
        UsersignUP.addActionListener(SignIn_SignUpController.getUserSignUpController());
        UsersignUP.setActionCommand("signup");
        UsersignUP.setBackground(new Color(255, 184, 146));

        JButton exitSignup = new JButton("Exit");
        exitSignup.setBackground(new Color(255, 184, 146));

        exitSignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        panel2.add(newUsername);
        panel2.add(newPassword);
        panel2.add(reNewPassword);
        panel2.add(newEmail);
        panel2.add(UsersignUP);
        panel2.add(exitSignup);
///////////////////////////////////////////////////////
        tp.add(panel1);
        tp.setTitleAt(0, "Sign In");

        tp.add(panel2);
        tp.setTitleAt(1, "Sign Up");

        frame.add(tp);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

    }


}
