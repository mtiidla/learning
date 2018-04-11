package ee.mtiidla.headfirst.strategy.puzzle;

class King extends Character {

    public King() {
        mWeaponBehavior = new SwordBehavior();
    }
}
