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
import java.util.*;
import java.util.Timer;

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
                if (key == KeyEvent.VK_SPACE) {
                    Hero activeHero = heroes[activeHeroId - 1];
                    HashMap<String, GameEntity> attackedEntities = Utils.getAttackedEntities(activeHero, monsters, heroes);
                    int attackType = activeHero.attack(attackedEntities);
                    if (attackType > 0) {
                        Image img = new ImageIcon(
                                String.format("static/img/warrior/%d.png", attackType))
                                .getImage();
                        activeHero.setGoingRight(false);
                        activeHero.setBaseImage(img);

                        TimerTask attackTask = new TimerTask() {
                            @Override
                            public void run() {
                                activeHero.setDefaultImage();
                                repaint();
                            }
                        };
                        Timer attackTimer = new Timer();
                        attackTimer.schedule(attackTask, 200);

                    }

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
        ArrayList<GameEntity> gameEntities = new ArrayList<>();
        gameEntities.addAll(monsters);
        gameEntities.addAll(Arrays.asList(heroes));
        for (GameEntity hero : gameEntities) {
            g.drawImage(
                    hero.getBaseImage(),
                    (hero.getX() * Constants.HERO_IMG_WIDTH) + (hero.isGoingRight() ? 0 : Constants.HERO_IMG_WIDTH ),
                    hero.getY() * Constants.HERO_IMG_HEIGHT,
                    Constants.HERO_IMG_WIDTH * (hero.isGoingRight() ? 1 : -1),
                    Constants.HERO_IMG_HEIGHT,
                    this);
            g.drawString(hero.getStringHp(),hero.getX() * Constants.HERO_IMG_WIDTH, hero.getY() * Constants.HERO_IMG_HEIGHT + 15);
        }

    }
}
