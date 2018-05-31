package ee.mtiidla.headfirst.builder;

import java.time.LocalDate;

/**
 * The Builder Pattern is used to encapsulate the construction of a product and allow it to be
 * constructed in steps.
 */
class BuilderMainTest {

    public static void main(String[] args) {
        AbstractBuilder builder = new VacationBuilder();
        builder.buildDay(LocalDate.now());
        builder.addHotel(new Hotel("ObjectVille Grand Resort"));
        builder.addReservation(new Dining("Top Resto Objects"));
        builder.buildDay(LocalDate.now().plusDays(1));
        builder.addHotel(new Hotel("ObjectVille Grand Resort"));
        builder.addReservation(new Dining("Quick and Cheap"));
        builder.addSpecialEvent(new SpecialEvent("Object Conference"));
        builder.buildDay(LocalDate.now().plusDays(2));
        builder.addHotel(new Hotel("ObjectVille Grand Resort"));
        builder.addTickets(new ParkTickets("Siam Park"));
        VacationPlanner vacationPlanner = builder.getVacationPlanner();

        Client client = new Client("John", vacationPlanner.getVacation());
        System.out.println(client.toString());
        System.out.println(client.getName() + "'s vacation will cost $" + vacationPlanner.calculateCost() / 1000000);
    }

}
