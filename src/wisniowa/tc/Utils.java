package wisniowa.tc;

import wisniowa.tc.classes.entities.GameEntity;
import wisniowa.tc.classes.entities.heroes.Hero;
import wisniowa.tc.classes.entities.monsters.Monster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Utils {
    public static HashMap<String, GameEntity> getAttackedEntities(Hero activeHero, ArrayList<Monster> monsters, Hero[] heroes) {
        HashMap<String, GameEntity> result = new HashMap<>();

        ArrayList<GameEntity> gameEntities = new ArrayList<>();
        gameEntities.addAll(monsters);
        gameEntities.addAll(Arrays.asList(heroes));

        int leftEntityId = GameEntity.getOccupiedCells()[activeHero.getY()][activeHero.getX()-1];
        int rightEntityId = GameEntity.getOccupiedCells()[activeHero.getY()][activeHero.getX()+1];
        for (GameEntity entity : gameEntities) {
            if (entity.getId() == leftEntityId) {
                result.put("l", entity);
            }
            if (entity.getId() == rightEntityId) {
                result.put("r", entity);
            }
        }
        return result;
    }
}
