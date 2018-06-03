package ee.mtiidla.headfirst.memento;

/**
 * Memento Pattern is used to be able to return an object to one of its previous states; for
 * instance, if you user requests an "undo".
 */
class GameClient {

    public static void main(String[] args) {

        Character character = new Character(100, "Bare Hands");
        Game game = new Game(character);

        game.fightWithMonster("Mace");
        game.fightWithMonster("Bow and arrow");
        game.fightWithMonster("Sword");

        Game.Memento memento = game.getCurrentState();
        System.out.println("\nSave state before last breath");

        game.fightWithMonster("Knife");

        System.out.println("\nRestored state, let's fight again");
        game.restoreState(memento);
        game.fightWithMonster("Sword");
    }

}
