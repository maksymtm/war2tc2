package wisniowa.tc.classes.entities.heroes;

import wisniowa.tc.Interfaces.IDrawableObject;

import javax.swing.*;

public class Archer extends Hero  implements IDrawableObject {
    //weapon, weapon, name

    public Archer(String name, int x, int y) {
        super(name, x ,y);
        this.maxHP = 800;
        setHp(700);
        setBaseImage(
                new ImageIcon(
                        "static/img/archer/base.png")
                        .getImage()
        );
    }


}
