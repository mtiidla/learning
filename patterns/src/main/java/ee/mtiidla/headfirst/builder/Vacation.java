package ee.mtiidla.headfirst.builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

class Vacation {

    private final HashMap<LocalDate, List<Object>> vacation;

    private LocalDate lastdate;

    public Vacation() {
        vacation = new LinkedHashMap<>();
    }

    public void addDay(LocalDate date) {
        lastdate = date;
        vacation.put(date, new ArrayList<>());
    }

    public void addItem(Object o) {
        vacation.get(lastdate).add(o);
    }

    @Override
    public String toString() {
        return vacation.toString();
    }
}
