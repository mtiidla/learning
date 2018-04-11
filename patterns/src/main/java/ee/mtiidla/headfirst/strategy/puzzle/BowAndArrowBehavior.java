package ee.mtiidla.headfirst.strategy.puzzle;

class BowAndArrowBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("Shooting with bow and arrows");
    }
}
