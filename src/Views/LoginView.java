package Views;

import Views.Inc.DesktopPane;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JInternalFrame{
    private JPanel mainPanel;
    private JTextField userNameTextField;
    private JButton logInButton;
    private JPasswordField passwordTextField;

    static JInternalFrame frame = null;

    public LoginView(){
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);

    }

    public JTextField getUserNameTextField() {
        return userNameTextField;
    }

    public JButton getLogInButton() {
        return logInButton;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

}
