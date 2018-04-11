package ee.mtiidla.headfirst.strategy.puzzle;

class SwordBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("Swinging with sword");
    }
}
