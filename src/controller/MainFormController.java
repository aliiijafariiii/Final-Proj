package controller;

import model.bl.PostManager;
import model.bl.PostManagerImpl;
import model.to.PostTo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import view.MainForm;
import view.SignIn_SignUpForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Ali on 2/11/2016.
 */
public class MainFormController implements ActionListener {
    private static MainFormController mainFormController = new MainFormController();

    public static MainFormController getMainFormController() {
        return mainFormController;
    }

    public MainFormController() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Method method = this.getClass().getDeclaredMethod(e.getActionCommand());
            method.invoke(this);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }



}
