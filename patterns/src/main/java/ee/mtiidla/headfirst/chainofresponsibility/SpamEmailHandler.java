package ee.mtiidla.headfirst.chainofresponsibility;

class SpamEmailHandler extends EmailHandler {

    protected SpamEmailHandler(EmailHandler successor) {
        super(successor);
    }

    @Override
    void handleRequest(Email email) {
        if (email.getClassification() == Email.Classification.SPAM) {
            System.out.println("Spam Email Handler is deleting email: " + email.toString());
        } else {
            successor.handleRequest(email);
        }
    }
}
