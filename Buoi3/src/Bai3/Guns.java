package Bai3;

public class Guns {
    private String weaponName;
    private int ammoNumber;

    public Guns(String weaponName, int ammoNumber) {
        this.weaponName = weaponName;
        this.ammoNumber = ammoNumber;
    }

    public Guns() {}

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getAmmoNumber() {
        return ammoNumber;
    }

    public void setAmmoNumber(int ammoNumber) {
        this.ammoNumber = ammoNumber;
    }

    public void load(int x) {
        this.ammoNumber += x;
    }

    public int shoot(int x) {
        if (this.ammoNumber - x >= 0)
            this.ammoNumber -= x;
        return this.ammoNumber;
    }
}
