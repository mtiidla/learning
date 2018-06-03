package ee.mtiidla.headfirst.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * The Prototype Pattern can be used when creating an instance of a given class is either expensive
 * or complicated.
 */
class MonsterClient {

    public static void main(String[] args) {

        MonsterFactory factory = new MonsterFactory();

        List<Monster> armyOfCookies = new ArrayList<>();
        List<Monster> armyOfWizard = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            armyOfCookies.add(factory.getMonster(CookieMonster.class));
            armyOfWizard.add(factory.getMonster(Wizard.class));
        }

    }

}
