package ee.mtiidla.headfirst.builder;

import java.time.LocalDate;

class VacationBuilder implements AbstractBuilder {

    private final Vacation vacation;

    VacationBuilder() {
        vacation = new Vacation();
    }

    @Override
    public void buildDay(LocalDate localDate) {
        vacation.addDay(localDate);
    }

    @Override
    public void addHotel(Hotel hotel) {
        vacation.addItem(hotel);
    }

    @Override
    public void addReservation(Dining dining) {
        vacation.addItem(dining);
    }

    @Override
    public void addSpecialEvent(SpecialEvent event) {
        vacation.addItem(event);
    }

    @Override
    public void addTickets(ParkTickets tickets) {
        vacation.addItem(tickets);
    }

    @Override
    public VacationPlanner getVacationPlanner() {
        return new VacationPlanner(vacation);
    }
}
