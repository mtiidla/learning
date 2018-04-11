package ee.mtiidla.headfirst.strategy.puzzle;

abstract class Character {

    WeaponBehavior mWeaponBehavior;

    void fight() {
        System.out.print(getClass().getSimpleName() + ": ");
        mWeaponBehavior.useWeapon();
    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        mWeaponBehavior = weaponBehavior;
    }
}
