package Controllers;

import Views.Inc.MenuBar;
import Views.Inc.MenuBarState;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuController {

    static JMenuBar menuBar;

    static JMenuItem loginBtn;
    static JMenuItem registerBtn;

    static JMenu homeBtn;

    static JMenu aboutBtn;

    static JMenu logoutBtn;

    public MenuController(MenuBar menuBar){

        MenuController.menuBar = menuBar;
        loginBtn = menuBar.getLoginBtn();
        registerBtn = menuBar.getRegisterBtn();
        homeBtn = menuBar.getHomeBtn();
        aboutBtn = menuBar.getAboutBtn();
        logoutBtn = menuBar.getLogoutBtn();

    }

    public void activateAllListeners(){
        registerListener();
        loginListener();
        aboutListener();
        logoutListener();
        homeListener();
    }

    void registerListener(){
        registerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(registerBtn.isEnabled()) {
                    PagesController.getCurrentView().dispose();
                    PagesController.registerView();
                    PagesController.centerUp();
                }
            }
        });
    }

    void loginListener(){
        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(loginBtn.isEnabled()) {
                    PagesController.getCurrentView().dispose();
                    PagesController.loginView();
                    PagesController.centerUp();
                }
            }
        });
    }

    void aboutListener(){
        aboutBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(aboutBtn.isEnabled()) {
                    PagesController.getCurrentView().dispose();
                    PagesController.aboutView();
                    PagesController.center();
                }
            }
        });
    }

    void homeListener(){
        homeBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (homeBtn.isEnabled()) {
                    PagesController.getCurrentView().dispose();
                    PagesController.homeView();
                    PagesController.centerUp();
                }
            }
        });
    }

    void logoutListener(){
        logoutBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (logoutBtn.isEnabled()) {
                    PagesController.getCurrentView().dispose();
                    PagesController.loginView();
                    PagesController.centerUp();
                }
            }
        });
    }

    public static void changeState(MenuBarState menuBarState){
        switch (menuBarState){
            case REGISTER -> registerState();
            case HOME -> homeState();
            case ABOUT -> aboutState();
            case LOGIN -> loginState();
        }
    }

    static void loginState(){
        loginBtn.setVisible(true);
        loginBtn.setEnabled(false);
        registerBtn.setVisible(true);
        registerBtn.setEnabled(true);
        logoutBtn.setVisible(false);
        homeBtn.setVisible(false);
        aboutBtn.setVisible(false);
    }

    static void registerState(){
        loginBtn.setVisible(true);
        loginBtn.setEnabled(true);
        registerBtn.setVisible(true);
        registerBtn.setEnabled(false);
        logoutBtn.setVisible(false);
        homeBtn.setVisible(false);
        aboutBtn.setVisible(false);
    }

    static void homeState(){
        loginBtn.setVisible(false);
        registerBtn.setVisible(false);
        logoutBtn.setVisible(true);
        homeBtn.setVisible(true);
        homeBtn.setEnabled(false);
        aboutBtn.setVisible(true);
        aboutBtn.setEnabled(true);
    }

    static void aboutState(){
        loginBtn.setVisible(false);
        registerBtn.setVisible(false);
        logoutBtn.setVisible(true);
        homeBtn.setVisible(true);
        homeBtn.setEnabled(true);
        aboutBtn.setVisible(true);
        aboutBtn.setEnabled(false);
    }

    

    public static JMenuBar getMenuBar() {
        return menuBar;
    }
}
