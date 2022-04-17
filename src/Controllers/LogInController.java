package Controllers;

import Models.User;
import Views.LoginView;

import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LogInController {

    LoginView loginView;

    public LogInController(LoginView loginView){
        this.loginView = loginView;

        this.loginView.getLogInButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logIn();
            }
        });

        this.loginView.getLogInButton().setVisible(false);

        this.loginView.getUserNameTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(checkFields())
                    loginView.getLogInButton().setVisible(true);
                else
                    loginView.getLogInButton().setVisible(false);
            }
        });

        this.loginView.getPasswordTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(checkFields())
                    loginView.getLogInButton().setVisible(true);
                else
                    loginView.getLogInButton().setVisible(false);
            }
        });
    }

    boolean checkFields(){
        return loginView.getUserNameTextField().getText().length() > 0 && loginView.getPasswordTextField().getText().length() > 0;
    }

    // register
    public void logIn(){
        User user = new User();
        String user_name = loginView.getUserNameTextField().getText();
        String password = loginView.getPasswordTextField().getText();

        if (user.find(user_name, password)) {
            PagesController.getCurrentView().dispose();
            PagesController.homeView();
        } else {
            loginView.getUserNameTextField().setBorder(new LineBorder(Color.red));
            loginView.getPasswordTextField().setBorder(new LineBorder(Color.red));
            System.out.println("not logged in");
        }
    }

}
