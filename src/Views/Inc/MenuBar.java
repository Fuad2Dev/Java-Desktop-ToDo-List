package Views.Inc;

import javax.swing.*;

public class MenuBar extends JMenuBar {

//    JMenu authMenu;
    JMenu loginBtn;
    JMenu registerBtn;

    JMenu homeBtn;

    JMenu aboutBtn;

    JMenu logoutBtn;

    public MenuBar(){
        initializeParameters();

        organizeMenuBar();

    }

    void initializeParameters(){

        loginBtn = new JMenu("login");
        registerBtn = new JMenu("register");

        homeBtn = new JMenu("home");

        aboutBtn = new JMenu("about");

        logoutBtn = new JMenu("logout");
    }

    void organizeMenuBar(){
        this.add(Box.createHorizontalGlue());
        this.add(loginBtn);
        this.add(registerBtn);
        this.add(homeBtn);
        this.add(aboutBtn);
        this.add(logoutBtn);
        this.add(Box.createHorizontalGlue());
    }


    public JMenuItem getLoginBtn() {
        return loginBtn;
    }

    public JMenuItem getRegisterBtn() {
        return registerBtn;
    }

    public JMenu getAboutBtn() {
        return aboutBtn;
    }

    public JMenu getLogoutBtn() {
        return logoutBtn;
    }

    public JMenu getHomeBtn() {
        return homeBtn;
    }
}
