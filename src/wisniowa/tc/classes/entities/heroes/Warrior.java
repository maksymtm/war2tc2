package wisniowa.tc.classes.entities.heroes;

import wisniowa.tc.classes.entities.GameEntity;

import javax.swing.*;
import java.util.HashMap;

public class Warrior extends Hero {
    //weapon, weapon, name

    public Warrior(String name, int x, int y) {
        super(name, x ,y);
        this.maxHP = 1000;
        setHp(1000);
        damage = 150;
        setDefaultImage();

    }
    @Override
    public int attack(HashMap<String, GameEntity> attackedEntities) {
        if(attackedEntities.containsKey("r") && attackedEntities.containsKey("l")) {
            GameEntity entity1 = attackedEntities.get("l");
            entity1.setHp(entity1.getHp() - this.damage * (1 - entity1.getArmor() / 100));
            GameEntity entity2 = attackedEntities.get("r");
            entity2.setHp(entity2.getHp() - this.damage * (1 - entity2.getArmor() / 100));
            return 3;
        } else if (attackedEntities.containsKey("l")) {
            GameEntity entity1 = attackedEntities.get("l");
            entity1.setHp(entity1.getHp() - this.damage * (1 - entity1.getArmor() / 100));
            return 1;
        }
        else if (attackedEntities.containsKey("r")) {
            GameEntity entity2 = attackedEntities.get("r");
            entity2.setHp(entity2.getHp() - this.damage * (1 - entity2.getArmor() / 100));
            return 2;
        }
        return 0;
    }

    @Override
    public void setDefaultImage() {
        setBaseImage(
                new ImageIcon(
                        "static/img/warrior/base.png")
                        .getImage()
        );
    }


}
