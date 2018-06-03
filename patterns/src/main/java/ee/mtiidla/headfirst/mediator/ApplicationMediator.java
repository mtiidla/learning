package ee.mtiidla.headfirst.mediator;

import java.util.ArrayList;
import java.util.List;

class ApplicationMediator implements Mediator {

    private List<Colleague> colleagues;

    public ApplicationMediator() {
        colleagues = new ArrayList<>();
    }

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void send(String message, Colleague originator) {
        for (Colleague colleague : colleagues) {
            if (colleague != originator) {
                colleague.receive(message);
            }
        }
    }
}
