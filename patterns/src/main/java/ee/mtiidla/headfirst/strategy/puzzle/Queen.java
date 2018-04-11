package ee.mtiidla.headfirst.strategy.puzzle;

class Queen extends Character {

    public Queen() {
        mWeaponBehavior = new BowAndArrowBehavior();
    }
}
