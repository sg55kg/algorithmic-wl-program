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
    void testDetermineMonthVolume() {
        Month month = new Month();
        month.setMonthType(1);

        month.determineMonthVolume();
        double monthVolume = month.getMonthVolume();

        assertEquals(750, monthVolume);
    }

    @Test
    void testDetermineMonthVolumeWithShorterMonth() {
        Month month = new Month();
        month.setMonthLength(2);
        month.determineMonthVolume();

        double monthVolume = month.getMonthVolume();
        assertEquals(400, monthVolume);
    }

    @Test
    void createWeeksReturnsCorrectAmountOfWeeks() {
        Month month = new Month();
        month.setMonthLength(3);
        month.setDaysPerWeek(4);
        month.setMonthVolume(500);
        month.createWeeks();

        int numberOfWeeks = month.weeks.size();
        assertEquals(3, numberOfWeeks);

    }

    @Test
    void testMonthsInheritDaysPerWeek() {
        Program program = new Program();
        program.setDaysPerWeek(3);
        program.createMonths();

        for(Month month : program.months) {
            assertEquals(3, month.getDaysPerWeek());
        }

    }

}