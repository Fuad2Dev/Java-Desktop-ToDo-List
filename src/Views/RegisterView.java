package Views;

import Views.Inc.DesktopPane;

import javax.swing.*;

public class RegisterView extends JInternalFrame{
    private JTextField usernameTextField;
    private JPanel mainPanel;
    private JButton registerButton;
    private JPasswordField passwordTextField;

    public RegisterView(){
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);

//        DesktopPane.getDesktopPane().add(this);
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }
}
