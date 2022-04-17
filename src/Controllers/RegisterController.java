package Controllers;

import Models.User;
import Views.RegisterView;

import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegisterController {

    RegisterView registerView;

    public RegisterController(RegisterView registerView){
        this.registerView = registerView;

        this.registerView.getRegisterButton().setVisible(false);

        this.registerView.getUsernameTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(checkFields())
                    registerView.getRegisterButton().setVisible(true);
                else
                    registerView.getRegisterButton().setVisible(false);
            }
        });

        this.registerView.getPasswordTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(checkFields())
                    registerView.getRegisterButton().setVisible(true);
                else
                    registerView.getRegisterButton().setVisible(false);
            }
        });

        this.registerView.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
    }

    boolean checkFields(){
        return registerView.getUsernameTextField().getText().length() > 0 && registerView.getPasswordTextField().getText().length() > 0;
    }

    // register
    public void register(){
        User user = new User();
        String user_name = registerView.getUsernameTextField().getText();
        String password = registerView.getPasswordTextField().getText();

        if (!User.check(user_name))
            if (user.create(user_name, password)) {
                System.out.println("created successfully");
                PagesController.getCurrentView().dispose();
                PagesController.loginView();
                PagesController.centerUp();
            }
            else
                System.out.println("not created");

            else
                registerView.getUsernameTextField().setBorder(new LineBorder(Color.red));
    }

}
