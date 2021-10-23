import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeekTest {

    @Test
    void testSetDayVolumesWorksForSixDays() {
        Week week = new Week(1, 6, 500, 4);
        week.setWeekVolume(500);
        week.setDayVolumes(week.days);
        for (Day day : week.days) {
            if (day.getDayType() == 0) {
                assertEquals(75, day.getTotalDayVolume());
            } else if (day.getDayType() == 1) {
                assertEquals(125, day.getTotalDayVolume());
            } else {
                assertEquals(50, day.getTotalDayVolume());
            }
        }
    }

    @Test
    void testCreateDaysGivesCorrectDayOrder() {
        Week week = new Week(1, 3, 500, 4);
        for (Day day : week.days) {
            int dayOrder = 0;
            assertEquals(dayOrder, day.dayOrder);
            dayOrder++;
        }

    }

    @Test
    void setDayVolumesWorksSubFourDays() {
        Week week = new Week(1, 3, 500, 4);
        week.setWeekVolume(500); //override default volume for tests
        week.setDayVolumes(week.days);
        for (Day day : week.days) {
            if (day.getDayType() == 0) {
                assertEquals(150, day.getTotalDayVolume());
            } else if (day.getDayType() == 1) {
                assertEquals(175, day.getTotalDayVolume());
            } else if (day.getDayType() == 2) {
                assertEquals(150, day.getTotalDayVolume());
            }
        }
    }
}