import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    Program program = new Program();
    @BeforeEach
    void setUp() {

    }

    @Test
    void setLiftRatios() {
    }

    @Test
    void setMonthTypeValue() {
    }

    @Test
    void setInitSubTractWeeksValue() {
    }

    @Test
    void testAddMonthsToListAddsTheCorrectNumberOfMonths() {
        program.setTotalCycleLength(12);
        program.createMonths();
        int months = program.months.size();
        assertEquals(3, months);

        Program program2 = new Program();
        program2.setTotalCycleLength(5);
        program2.createMonths();
        int months2 = program2.months.size();
        assertEquals(2, months2);
    }

    @Test
    void testSetTotalCycleLengthThrowsException() {
        Program program = new Program();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           program.setTotalCycleLength(17);
        });
        System.out.println("Exception thrown " + exception);
    }
}