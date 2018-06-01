package ee.mtiidla.headfirst.chainofresponsibility;

class Email {

    private final String message;
    private Classification classification;

    Email(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    enum Classification {
        SPAM, FAN, COMPLAINT, NEW_LOCATION
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public Classification getClassification() {
        return classification;
    }

    @Override
    public String toString() {
        return message;
    }
}
