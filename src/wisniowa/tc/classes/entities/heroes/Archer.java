package wisniowa.tc.classes.entities.heroes;

import wisniowa.tc.classes.entities.GameEntity;

import javax.swing.*;
import java.util.HashMap;

public class Archer extends Hero {
    //weapon, weapon, name

    public Archer(String name, int x, int y) {
        super(name, x ,y);
        this.maxHP = 800;
        setHp(700);
        damage = 75;
        setDefaultImage();
    }

    @Override
    public int attack(HashMap<String, GameEntity> attackedEntities) {
        return 0;
    }

    @Override
    public void setDefaultImage() {
        setBaseImage(
                new ImageIcon(
                        "static/img/archer/base.png")
                        .getImage()
        );
    }


}
