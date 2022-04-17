package Controllers;

import Views.AboutView;
import Views.Inc.DesktopPane;
import Views.Inc.MenuBarState;
import Views.LoginView;
import Views.RegisterView;
import Views.HomeView;
import com.mysql.jdbc.log.Log;

import javax.swing.*;
import java.awt.*;

public class PagesController {
    static LoginView loginView;
    static RegisterView registerView;
    static AboutView aboutView;
    static HomeView homeView;

    static JInternalFrame currentView;

    public PagesController(){}

    public static void loginView(){
        // create login view

        loginView = new LoginView();
        new LogInController(loginView);

        // change menu bar state
        MenuController.changeState(MenuBarState.LOGIN);

        // rendering login view
        DesktopPane.getDesktopPane().add(loginView);

        //set current view
        currentView = loginView;
    }

    public static void registerView(){
        //create register view

        registerView = new RegisterView();

        new RegisterController(registerView);

        //change menu bar state
        MenuController.changeState(MenuBarState.REGISTER);

        //render register view
        DesktopPane.getDesktopPane().add(registerView);

        //set current view
        currentView = registerView;
    }

    public static void aboutView(){
        //create about view

        aboutView = new AboutView();

        //change menu bar state
        MenuController.changeState(MenuBarState.ABOUT);

        //render register view
        DesktopPane.getDesktopPane().add(aboutView);

        //set current view
        currentView = aboutView;
    }

    public static void homeView(){
        //create home view
        homeView = new HomeView();

        // attach controller
        new HomeController(homeView);

        //change menu bar state
        MenuController.changeState(MenuBarState.HOME);

        //render register view
        DesktopPane.getDesktopPane().add(homeView);

        //set current view
        currentView = homeView;
    }

    public static void centerUp(){
        Dimension desktopSize = DesktopPane.getDesktopPane().getSize();
        Dimension jInternalFrameSize = currentView.getSize();
        currentView.setLocation((desktopSize.width - jInternalFrameSize.width)/2, 30);
    }

    public static void center(){
        Dimension desktopSize = DesktopPane.getDesktopPane().getSize();
        Dimension jInternalFrameSize = currentView.getSize();
        currentView.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                (desktopSize.height- jInternalFrameSize.height)/2);
    }


    public static JInternalFrame getCurrentView() {
        return currentView;
    }
}
