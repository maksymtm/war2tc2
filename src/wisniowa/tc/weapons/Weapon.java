package wisniowa.tc.weapons;

public abstract class Weapon {

    private int range;
    private WeaponType weaponType;

    public Weapon() {
        this.range = 1;
        this.weaponType = WeaponType.MELEE;
    }

    public Weapon(int range) {
        this.range = range;
    }

    public Weapon(int range, WeaponType weaponType) {
        this.range = range;
        this.weaponType = weaponType;
    }

    public void setRange(int range) {
        if (range >= 0 && range < 12) {
            this.range = range;
        }
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }
}
