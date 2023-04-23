package wisniowa.tc;


import wisniowa.tc.classes.entities.GameEntity;
import wisniowa.tc.classes.entities.heroes.Archer;
import wisniowa.tc.classes.entities.heroes.Warrior;

public class Main {

    public static void main(String[] args) {

        GameEntity.printOccupiedCells();
        Team team = new Team(
                new Archer("Legolas", 0, 0),
                new Archer("Kononowicz", 1, 0),
                /*new Warrior("Aragorn1", 3, 0),
                new Warrior("Aragorn2", 4, 0),
                new Warrior("Aragorn3", 5, 0),
                new Warrior("Aragorn4", 6, 0),*/
                new Warrior("Aragorn5", 7, 0)
        );
        GameEntity.printOccupiedCells();
        new MyWindow(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, team);


    }
}
