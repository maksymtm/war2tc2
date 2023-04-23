package wisniowa.tc.classes.entities.heroes;

import javax.swing.*;

public class Warrior extends Hero {
    //weapon, weapon, name

    public Warrior(String name, int x, int y) {
        super(name, x ,y);
        this.maxHP = 1000;
        setHp(1000);
        setBaseImage(
                new ImageIcon(
                        "static/img/warrior/base.png")
                        .getImage()
        );
    }


}
