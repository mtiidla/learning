package ee.mtiidla.headfirst.strategy.puzzle;

class KnifeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("Cutting with knife");
    }
}
