package ee.mtiidla.headfirst.memento;

class Character {

    private int health;
    private String selectedWeapon;

    public Character(int health, String selectedWeapon) {
        this.health = health;
        this.selectedWeapon = selectedWeapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getSelectedWeapon() {
        return selectedWeapon;
    }

    public void setSelectedWeapon(String selectedWeapon) {
        this.selectedWeapon = selectedWeapon;
    }
}
