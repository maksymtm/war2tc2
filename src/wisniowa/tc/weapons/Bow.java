package wisniowa.tc.weapons;

public class Bow extends Weapon {
    public Bow() {
        this.setRange(2);
        this.setWeaponType(WeaponType.SHOOT);
    }

    public Bow(int range) {
        super(range);
        this.setWeaponType(WeaponType.SHOOT);
    }
}
