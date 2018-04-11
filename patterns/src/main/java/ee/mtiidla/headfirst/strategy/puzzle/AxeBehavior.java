package ee.mtiidla.headfirst.strategy.puzzle;

class AxeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("Chopping with axe");
    }
}
