package ee.mtiidla.headfirst.chainofresponsibility;

class EndOfChainHandler extends EmailHandler {

    protected EndOfChainHandler() {
        super(null);
    }

    @Override
    void handleRequest(Email email) {
        System.out.println("Email forgotten in the void: " + email);
    }
}
