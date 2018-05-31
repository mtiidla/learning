package ee.mtiidla.headfirst.builder;

import java.time.LocalDate;

interface AbstractBuilder {

    void buildDay(LocalDate localDate);

    void addHotel(Hotel hotel);

    void addReservation(Dining dining);

    void addSpecialEvent(SpecialEvent event);

    void addTickets(ParkTickets tickets);

    VacationPlanner getVacationPlanner();

}
