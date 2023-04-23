package wisniowa.tc;

import javax.swing.*;

public class MyWindow extends JFrame {
    public MyWindow(int width, int height, Team team) {
        setSize(width + 16, height + 40);
        setResizable(false);
        setLocationRelativeTo(null);
        add(new GamePanel(team));

        setVisible(true);
    }
}
