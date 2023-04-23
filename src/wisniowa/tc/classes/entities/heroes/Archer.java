package wisniowa.tc.classes.entities.heroes;

import javax.swing.*;

public class Archer extends Hero {
    //weapon, weapon, name

    public Archer(String name, int x, int y) {
        super(name, x ,y);
        setBaseImage(
                new ImageIcon(
                        "static/img/archer/base.png")
                        .getImage()
        );
    }


}
