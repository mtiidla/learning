package ee.mtiidla.headfirst.chainofresponsibility;

class ComplaintEmailHandler extends EmailHandler {

    protected ComplaintEmailHandler(EmailHandler successor) {
        super(successor);
    }

    @Override
    void handleRequest(Email email) {
        if (email.getClassification() == Email.Classification.COMPLAINT) {
            System.out.println("Complaint Email Handler is forwarding email to legal department: " + email.toString());
        } else {
            successor.handleRequest(email);
        }
    }
}
