package ee.mtiidla.headfirst.strategy.puzzle;

class Knight extends Character {

    public Knight() {
        mWeaponBehavior = new KnifeBehavior();
    }
}
