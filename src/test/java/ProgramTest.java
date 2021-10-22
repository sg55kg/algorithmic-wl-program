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
    void addMonthsToList() {
        program.setTotalCycleLength(12);
        program.addMonthsToList();
        int months = program.months.size();
        assertEquals(3, months);
    }
}