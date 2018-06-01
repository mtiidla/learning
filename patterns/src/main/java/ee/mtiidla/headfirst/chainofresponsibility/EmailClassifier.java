package ee.mtiidla.headfirst.chainofresponsibility;

class EmailClassifier {

    public void classifyEmail(Email email) {
        if (email.getMessage().contains("offer")) {
            email.setClassification(Email.Classification.SPAM);
        } else if (email.getMessage().contains("love")) {
            email.setClassification(Email.Classification.FAN);
        } else if (email.getMessage().contains("addicted")) {
            email.setClassification(Email.Classification.COMPLAINT);
        } else if (email.getMessage().contains("location")) {
            email.setClassification(Email.Classification.NEW_LOCATION);
        }
    }

}
