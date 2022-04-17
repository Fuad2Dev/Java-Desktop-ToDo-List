package Views.Inc;

import javax.swing.*;

public class DesktopPane extends JDesktopPane {

    static JDesktopPane desktopPane = null;

    public DesktopPane(){
        desktopPane = this;
    }

    public static JDesktopPane getDesktopPane() {
        return desktopPane;
    }
}
