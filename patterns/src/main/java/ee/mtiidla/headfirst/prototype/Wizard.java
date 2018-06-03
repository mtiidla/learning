package ee.mtiidla.headfirst.prototype;

class Wizard implements Monster {

    private final String magicBook;

    public Wizard() {
        magicBook = generateMagicBook();
    }

    private Wizard(String magicBook) {
        this.magicBook = magicBook;
    }

    private String generateMagicBook() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Eternal Book of Magic";
    }

    @Override
    public Monster clone() {
        return new Wizard(magicBook);
    }
}
