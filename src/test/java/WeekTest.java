import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeekTest {

    @Test
    void setDayVolumesWorks() {
        Week week = new Week(1, 6, 500, 4);
        week.createDays();
        week.setDayVolumes(week.days, 500);
        for (Day day : week.days) {
            if (day.getDayType() == 0) {
                assertEquals(100, day.getTotalDayVolume());
            } else if (day.getDayType() == 1) {
                assertEquals(125, day.getTotalDayVolume());
            } else {
                assertEquals(150, day.getTotalDayVolume());
            }
        }
    }

    @Test
    void setDayVolumesWorksSubFourDays() {
        Week week = new Week(1, 3, 500, 4);
        week.createDays();
        week.setDayVolumes(week.days, 500);
        for (Day day : week.days) {
            if (day.getDayType() == 0) {
                assertEquals(150, day.getTotalDayVolume());
            } else if (day.getDayType() == 1) {
                assertEquals(175, day.getTotalDayVolume());
            } else {
                assertEquals(150, day.getTotalDayVolume());
                //test reveals there is an easy day in sub-four day weeks, so this needs to be fixed.
            }
        }
    }
}