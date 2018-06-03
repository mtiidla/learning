package ee.mtiidla.headfirst.prototype;

class CookieMonster implements Monster {

    private final String name;

    public CookieMonster(String race, String klass) {
        this.name = generateNameFromRaceAndClass(race, klass);
    }

    private CookieMonster(String name) {
        this.name = name;
    }

    private final String generateNameFromRaceAndClass(String race, String klass) {
        try {
            // its expensive to generate new name
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return race + ": Magical Cookie Monster";
    }

    @Override
    public Monster clone() {
        return new CookieMonster(name);
    }
}
