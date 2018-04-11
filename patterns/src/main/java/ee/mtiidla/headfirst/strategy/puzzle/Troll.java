package ee.mtiidla.headfirst.strategy.puzzle;

class Troll extends Character {

    public Troll() {
        mWeaponBehavior = new AxeBehavior();
    }
}
