package Views.Inc;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    public MainFrame(){
        this.setMinimumSize(new Dimension(600, 800));
    }

    public void render(){
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLocation(this.getX(), 30);
        this.setResizable(false);
        this.setVisible(true);
//        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    public void centerUp(){
        Dimension desktopSize = DesktopPane.getDesktopPane().getSize();
        Dimension frameSize = this.getSize();
        this.setLocation((desktopSize.width - frameSize.width)/2, 30);
    }

}
