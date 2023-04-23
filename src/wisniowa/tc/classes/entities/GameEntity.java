package wisniowa.tc.classes.entities;

import wisniowa.tc.Constants;

import java.awt.*;

public abstract class GameEntity {
    private static int[][] occupiedCells =
            new int
                    [Constants.WINDOW_HEIGHT / Constants.HERO_IMG_HEIGHT]
                    [Constants.WINDOW_WIDTH / Constants.HERO_IMG_WIDTH];
    private int x, y, hp;
    protected int maxHP, damage = 100, armor = 10;
    private Image baseImage, goLeftImage, goRightImage;
    private static int entitiesCounter = 0;
    private int id;
    private boolean goingRight = true;

    public int getDamage() {
        return damage;
    }

    public int getArmor() {
        return armor;
    }

    public boolean isGoingRight() {
        return goingRight;
    }

    public void setGoingRight(boolean goingRight) {
        this.goingRight = goingRight;
    }


    public static int[][] getOccupiedCells() {
        return occupiedCells;
    }

    public int getId() {
        return id;
    }

    public static void setOccupiedCells(int newValue, int y, int x) {
        GameEntity.occupiedCells[y][x] = newValue;
    }

    public GameEntity() {
        id = (++entitiesCounter);
    }
    public GameEntity(int x, int y, int hp, Image baseImage) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.baseImage = baseImage;
    }

    public static int getEntityByIdByYX(int y, int x) {
        return occupiedCells[y][x];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0) {
            this.hp = 0;
        } else if (hp > this.maxHP) {
            this.hp = this.maxHP;
        } else {
            this.hp = hp;
        }
    }

    public String getStringHp() {
        return Integer.toString(hp);
    }

    public Image getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(Image baseImage) {
        this.baseImage = baseImage;
    }

    public void setX(int x) {
        if (x > 0) {
            this.x = x;
        } else {
            this.x = 0;
        }
    }

    public void setY(int y) {
        if (y > 0) {
            this.y = y;
        } else {
            this.y = 0;
        }
    }



    public GameEntity(int x, int y) {
        setX(x);
        setY(y);
        id = (++entitiesCounter);
        occupiedCells[y][x] = id;
    }


    public static void printOccupiedCells() {
        for (int[] row: occupiedCells) {
            for (int entityId : row) {
                System.out.print(entityId + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    
}
