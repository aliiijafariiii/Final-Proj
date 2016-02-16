package view;

import controller.SignIn_SignUpController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
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

        JPanel panel1 = new JPanel();
        panel1.setLayout(new MigLayout());

        username = new JTextField(20);
        username.setText("Username");
        username.setForeground(Color.LIGHT_GRAY);
        password = new JPasswordField(20);
        password.setText("Password");
        password.setEchoChar((char) 0);
        password.setForeground(Color.LIGHT_GRAY);

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

        JButton POSTsignIN = new JButton("sign in");
        POSTsignIN.addActionListener(SignIn_SignUpController.getUserSignUpController());
        POSTsignIN.setActionCommand("enter");

        panel1.add(username, "cell 0 0");
        panel1.add(password, "cell 0 1");
        panel1.add(POSTsignIN, "cell 0 2");
        ////////////////////////////

        JPanel panel2 = new JPanel();
        panel2.setLayout(new MigLayout());

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
        newPassword.setEchoChar((char) 0);
        newPassword.setText("Please Enter Password");
        newPassword.setForeground(Color.LIGHT_GRAY);
        reNewPassword.setEchoChar((char) 0);
        reNewPassword.setText("Please Re Enter Password");
        reNewPassword.setForeground(Color.LIGHT_GRAY);
        newEmail.setText("Please Enter Email");
        newEmail.setForeground(Color.LIGHT_GRAY);

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

        JButton POSTsignUP = new JButton("sign up");
        POSTsignUP.addActionListener(SignIn_SignUpController.getUserSignUpController());
        POSTsignUP.setActionCommand("register");

        panel2.add(newUsername, "cell 0 0");
        panel2.add(newPassword, "cell 0 1");
        panel2.add(reNewPassword, "cell 0 2");
        panel2.add(newEmail, "cell 0 3");
        panel2.add(POSTsignUP, "cell 0 4");
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
