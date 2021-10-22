import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MonthTest {

    @Test
    void setLiftRatios() {
    }

    @Test
    void getLiftRatios() {
    }

    @Test
    void setMonthVolume() {
    }

    @Test
    void determineMonthVolume() {
    }

    @Test
    void createWeeks() {
        Month month = new Month();
        month.setMonthLength(4);
        month.setDaysPerWeek(4);
        month.setMonthVolume(500);
        month.createWeeks();

        int numberOfWeeks = month.weeks.size();
        assertEquals(4, numberOfWeeks);

    }
}