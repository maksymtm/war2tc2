package wisniowa.tc;

import wisniowa.tc.classes.entities.GameEntity;
import wisniowa.tc.classes.entities.heroes.Hero;
import wisniowa.tc.classes.entities.monsters.Gollum;
import wisniowa.tc.classes.entities.monsters.Monster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel {
    private Hero[] heroes;
    private ArrayList<Monster> monsters = new ArrayList<>();
    private int activeHeroId = 1;
    private int monstersCounter = 0;
    public GamePanel(Team team) {
        /*for (int i = 0; i < 3; i++) {
            monsters.add(new Gollum());
        }*/

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (monstersCounter < 6) {
                    monsters.add(new Gollum());
                    monstersCounter++;
                    repaint();
                }
            }
        };
        Timer t1 = new Timer();
        t1.schedule(task, 0, 2000);

        JButton button = new JButton();
        try {
            button.setIcon(new ImageIcon("static/img/warrior/sq.png"));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        //add(button);
        setFocusable(true);
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int mouseX = e.getX() / Constants.HERO_IMG_WIDTH;
                int mouseY = e.getY() / Constants.HERO_IMG_HEIGHT;
                for (Hero hero : heroes) {
                    int heroX = hero.getX();
                    int heroY = hero.getY();
                    if (heroX == mouseX && heroY == mouseY) {
                        activeHeroId = GameEntity.getEntityByIdByYX(mouseY, mouseX);
                        System.out.println(activeHeroId);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_RIGHT) {
                    heroes[activeHeroId - 1].tryGoRight();
                    //heroes[activeHeroId - 1].setX(heroes[activeHeroId - 1].getX() + 1);
                }
                if (key == KeyEvent.VK_LEFT) {
                    heroes[activeHeroId - 1].tryGoLeft();
                    //heroes[activeHeroId - 1].setX(heroes[activeHeroId - 1].getX() - 1);
                }
                if (key == KeyEvent.VK_UP) {
                    heroes[activeHeroId - 1].tryGoUp();
                    //heroes[activeHeroId - 1].setY(heroes[activeHeroId - 1].getY() - 1);
                }
                if (key == KeyEvent.VK_DOWN) {
                    heroes[activeHeroId - 1].tryGoDown();
                    //heroes[activeHeroId - 1].setY(heroes[activeHeroId - 1].getY() + 1);
                }
                GameEntity.printOccupiedCells();
                repaint();

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        heroes = team.getHeroes();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Hero hero : heroes) {
            if (hero.isGoingRight()) {
                g.drawImage(
                        hero.getBaseImage(),
                        hero.getX() * Constants.HERO_IMG_WIDTH,
                        hero.getY() * Constants.HERO_IMG_HEIGHT,
                        Constants.HERO_IMG_WIDTH,
                        Constants.HERO_IMG_HEIGHT,
                        this);
            } else {
                g.drawImage(
                        hero.getBaseImage(),
                        hero.getX() * Constants.HERO_IMG_WIDTH + Constants.HERO_IMG_WIDTH,
                        hero.getY() * Constants.HERO_IMG_HEIGHT,
                        -Constants.HERO_IMG_WIDTH,
                        Constants.HERO_IMG_HEIGHT,
                        this);
            }

        }
        for (Monster monster : monsters) {
            g.drawImage(
                    monster.getBaseImage(),
                    monster.getX() * Constants.HERO_IMG_WIDTH,
                    monster.getY() * Constants.HERO_IMG_HEIGHT,
                    Constants.HERO_IMG_WIDTH,
                    Constants.HERO_IMG_HEIGHT,
                    this);
        }

    }
}