package wisniowa.tc.classes.entities.monsters;

import javax.swing.*;

public class Gollum extends Monster{

    public Gollum() {
        super();
        setBaseImage(
                new ImageIcon(
                        "static/img/monsters/gollum.png")
                        .getImage()
        );
    }

    public Gollum(int x, int y, byte angryLevel) {
        super(x, y, angryLevel);
        setBaseImage(
                new ImageIcon(
                        "static/img/monsters/gollum.png")
                        .getImage()
        );
    }
}
