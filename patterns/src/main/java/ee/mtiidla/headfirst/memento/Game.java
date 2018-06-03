package ee.mtiidla.headfirst.memento;

class Game {

    private Character character;

    public Game(Character character) {
        this.character = character;
    }

    public void fightWithMonster(String weapon) {
        character.setSelectedWeapon(weapon);
        System.out.println("Fighting monster with " + weapon);
        character.setHealth(character.getHealth() - 30);
        System.out.println("Monster fights back, health left " + character.getHealth());
        if (character.getHealth() <= 0) {
            System.out.println("The Hero has fallen :(");
        }
    }

    public Memento getCurrentState() {
        return new Memento(character.getHealth());
    }

    public void restoreState(Memento state) {
        System.out.println("Restored health to "+ state.health);
        character.setHealth(state.health);
    }

    /**
     * Make sure that the client does not have access to the Memento's data to avoid it being
     * modified.
     */
    static class Memento {

        private int health;

        public Memento(int health) {
            this.health = health;
        }
    }

}
