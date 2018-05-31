package ee.mtiidla.headfirst.builder;

class VacationPlanner {

    private final Vacation vacation;

    public VacationPlanner(Vacation vacation) {
        this.vacation = vacation;
    }

    public Vacation getVacation() {
        return vacation;
    }

    public int calculateCost() {
        return vacation.hashCode();
    }
}
