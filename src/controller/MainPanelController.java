package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

public class MainPanelController implements ActionListener {

    private static MainPanelController mainPanelController = new MainPanelController();
    public static MainPanelController getMainPanelController() {
        return mainPanelController;
    }
    public MainPanelController() {}

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
