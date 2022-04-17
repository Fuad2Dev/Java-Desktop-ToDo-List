package Views;

import Views.Inc.DesktopPane;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JInternalFrame{
    private JTextField noteField;
    private JButton addButton;
    private JPanel mainPanel;
    private JPanel listPanel;
    private JLabel countErrMsg;
    private JLabel dbErrMsg;

    public HomeView(){
        //setting list panel layout
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        this.setContentPane(mainPanel);
        this.pack();
        centerUp();
        this.setVisible(true);
    }

    public JPanel getListPanel() {
        return listPanel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JTextField getNoteField() {
        return noteField;
    }

    public JLabel getCountErrMsg() {
        return countErrMsg;
    }

    public JLabel getDbErrMsg() {
        return dbErrMsg;
    }

    public void centerUp(){
        Dimension desktopSize = DesktopPane.getDesktopPane().getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                30);
    }
}
