package wisniowa.tc.classes.entities.heroes;

import wisniowa.tc.Interfaces.IDrawableObject;
import wisniowa.tc.classes.entities.GameEntity;
import wisniowa.tc.weapons.Weapon;

public abstract class Hero extends GameEntity {
    //x,y,baseImage _> po Entity!!!
    private Weapon rightHandWeapon;
    private Weapon leftHandWeapon;
    private String name;


    public Hero(String name, int x, int y) {
        super(x, y);
        this.name = name;
    }
    public Hero(int x, int y, String name) {
        super(x, y);
        this.name = name;
    }

    public void tryGoRight() {
        setGoingRight(true);
        tryChangePosition(getX() + 1, getY());
    }
    public void tryGoLeft() {

        setGoingRight(false);
        tryChangePosition(getX() - 1, getY());
    }
    public void tryGoUp() {
        tryChangePosition(getX(), getY() - 1);
    }
    public void tryGoDown() {
        tryChangePosition(getX(), getY() + 1);
    }
    public void tryChangePosition(int newX, int newY) {
        try {
            if (getOccupiedCells()[newY][newX] == 0) {
                setOccupiedCells(0, getY(), getX());
                setY(newY);
                setX(newX);
                setOccupiedCells(getId(), newY, newX);
            }
        } catch (ArrayIndexOutOfBoundsException e) {}
    }
}
