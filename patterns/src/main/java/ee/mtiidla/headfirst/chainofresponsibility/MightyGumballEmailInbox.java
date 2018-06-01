package ee.mtiidla.headfirst.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * The Chain of Responsibility Pattern allows you to give more than one object a chance to handle a
 * request.
 */
class MightyGumballEmailInbox {

    public static void main(String[] args) {

        EmailClassifier ai = new EmailClassifier();
        List<Email> emails = getInbox();
        for (Email email : emails) {
            ai.classifyEmail(email);
        }

        EmailHandler handler = new SpamEmailHandler(new FanEmailHandler(
                new ComplaintEmailHandler(new NewLocationEmailHandler(new EndOfChainHandler()))));

        for (Email email : emails) {
            handler.handleRequest(email);
        }

    }

    private static List<Email> getInbox() {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email("I love your new Gumball Machines, they are just wonderful!"));
        emails.add(new Email(
                "Your Gumball Machines must be removed! My kids are addicted to these devils!"));
        emails.add(new Email(
                "Could you please also open up a new Gumball Machine at my favourite location?"));
        emails.add(new Email(
                "We can offer you the best Gumball cleaning products you have ever imagined!"));
        emails.add(new Email("Beep boop beep?"));
        return emails;
    }

}
