package ee.mtiidla.headfirst.chainofresponsibility;

class NewLocationEmailHandler extends EmailHandler {

    protected NewLocationEmailHandler(EmailHandler successor) {
        super(successor);
    }

    @Override
    void handleRequest(Email email) {
        if (email.getClassification() == Email.Classification.NEW_LOCATION) {
            System.out.println("New Location Email Handler is forwarding email to the business department: " + email.toString());
        } else {
            successor.handleRequest(email);
        }
    }
}
