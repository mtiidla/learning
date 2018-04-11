package ee.mtiidla.headfirst.strategy.puzzle;

import java.util.ArrayList;
import java.util.List;

class StrategyPuzzleMain {

    public static void main(String[] args) {

        List<Character> characters = new ArrayList<>();
        characters.add(new Knight());
        characters.add(new Queen());
        characters.add(new King());
        characters.add(new Troll());

        for (Character character : characters) {
            character.fight();
        }

        characters.get(0).setWeaponBehavior(new SwordBehavior());

        System.out.println("\nKnight equipped sword, but the fight goes on!\n");
        for (Character character : characters) {
            character.fight();
        }
    }

}
