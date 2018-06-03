package ee.mtiidla.headfirst.prototype;

import java.util.HashMap;
import java.util.LinkedHashMap;

class MonsterFactory {

    private final HashMap<Class<? extends Monster>, Monster> cache;

    MonsterFactory() {
        cache = new LinkedHashMap<>();
    }

    public Monster getMonster(Class<? extends Monster> klass) {
        if (cache.containsKey(klass)) {
            System.out.println("Using prototype to clone a new monster of type: " + klass);
            return cache.get(klass).clone();
        } else {
            System.out.println("No prototype found, creating brand new monster of type: " + klass);
            Monster monster;
            if (klass.equals(CookieMonster.class)) {
                monster = new CookieMonster("Cookies", "Monster");
            } else if (klass.equals(Wizard.class)) {
                monster = new Wizard();
            } else {
                throw new IllegalArgumentException("No monster for class:" + klass);
            }
            cache.put(klass, monster);
            return monster;
        }
    }
}
