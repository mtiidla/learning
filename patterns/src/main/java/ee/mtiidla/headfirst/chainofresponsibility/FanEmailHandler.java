package ee.mtiidla.headfirst.chainofresponsibility;

class FanEmailHandler extends EmailHandler {

    protected FanEmailHandler(EmailHandler successor) {
        super(successor);
    }

    @Override
    void handleRequest(Email email) {
        if (email.getClassification() == Email.Classification.FAN) {
            System.out.println("Fan Email Handler is forwarding email to CEO: " + email.toString());
        } else {
            successor.handleRequest(email);
        }
    }
}
