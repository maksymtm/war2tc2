package wisniowa.tc.classes.entities.monsters;

import wisniowa.tc.Constants;
import wisniowa.tc.classes.entities.GameEntity;

import java.io.Console;
import java.util.Random;

public abstract class Monster extends GameEntity {
    //x,y,baseImage _> po Entity!!!
    private byte angryLevel;

    public Monster(int x, int y, byte angryLevel) {
        super(x, y);
        this.angryLevel = angryLevel;

    }

    public Monster() {
        super();
        Random rnd = new Random();
        this.angryLevel = (byte)rnd.nextInt(10);

        int newY;
        int newX;
        do {
            newY = rnd.nextInt(Constants.MAX_ENTITY_Y);
            newX = rnd.nextInt(Constants.MAX_ENTITY_X);
        } while (getOccupiedCells()[newY][newX] > 0);
        setX(newX);
        setY(newY);
        setOccupiedCells(this.getId(), this.getY(), this.getX());
        //setOccupiedCells(this.getId(), newY, newX);
    }
}
