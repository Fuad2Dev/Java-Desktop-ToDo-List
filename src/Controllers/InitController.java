package Controllers;

import Views.Inc.MainFrame;
import Views.Inc.MenuBar;
import Views.Inc.DesktopPane;

import javax.swing.*;
import java.awt.*;

public class InitController {
    public static void main(String[] args) {

        //connect to database
        new Connector();

        // set UI
        setUI();

        // create main frame instance
        MainFrame mainFrame = new MainFrame();

        //set desktop pane
        DesktopPane desktopPane = new DesktopPane();
        mainFrame.add(desktopPane, BorderLayout.CENTER);

        // create menu bar
        MenuBar menuBar = new MenuBar();

        // create menu controller
        MenuController menuController = new MenuController(menuBar);
        menuController.activateAllListeners();

        // set menu bar
        mainFrame.setJMenuBar(MenuController.getMenuBar());


        // render main Frame
        SwingUtilities.invokeLater(() -> {
            mainFrame.render();
        });

        // login view set up
        PagesController.loginView();
        PagesController.centerUp();

    }

    static void setUI(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
