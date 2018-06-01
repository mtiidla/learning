package ee.mtiidla.headfirst.chainofresponsibility;

abstract class EmailHandler {

    protected final EmailHandler successor;

    protected EmailHandler(EmailHandler successor) {
        this.successor = successor;
    }

    abstract void handleRequest(Email email);



}
