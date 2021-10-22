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