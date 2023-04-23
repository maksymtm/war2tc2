package wisniowa.tc;

import wisniowa.tc.classes.entities.heroes.Hero;

public class Team {
    private Hero[] heroes;
    public Team(Hero... heroes) {
        this.heroes = heroes;
     }

    public Hero[] getHeroes() {
        return heroes;
    }
}
