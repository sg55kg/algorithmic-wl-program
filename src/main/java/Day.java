import java.util.ArrayList;

public class Day extends Week {

    protected int dayType, numberOfDays, dayOrder, weekType;
    protected double totalDayVolume, parentWeekVolume;
    protected double[] liftRatios;
    protected ArrayList<Exercise> exercises = new ArrayList<>();

    public Day(int dayOrder, double parentWeekVolume, int numberOfDays, int weekType) {
        this.dayOrder = dayOrder;
        this.numberOfDays = numberOfDays;
        this.parentWeekVolume = parentWeekVolume;
        this.weekType = weekType;
        this.setDayType(dayOrder, numberOfDays);
    }

    public void setDayType(int dayOrder, int numberOfDays) {
        //0 type day = heavy, 1 type = medium, 2 type = easy
        if (dayOrder == 0) {
            if (numberOfDays > 5)
                this.dayType = 0;
             else
                this.dayType = 1;

        } else if (dayOrder == 1) {
            if (numberOfDays > 4)
                this.dayType = 2;
             else
                this.dayType = 1;

        } else if (dayOrder == 2) {
            if (numberOfDays == 3)
                this.dayType = 0;
             else if (numberOfDays == 4)
                this.dayType = 2;
             else
                this.dayType = 1;

        } else if (dayOrder == 3) {
            if (numberOfDays == 4)
                this.dayType = 0;
             else
                this.dayType = 2;

        } else if (dayOrder == 4) {
            if (numberOfDays == 5)
                this.dayType = 2;
             else
                this.dayType = 0;
        } else {
            this.dayType = 1;
        }
    }

    public int getDayType() {
        return dayType;
    }

    public void setTotalDayVolume(double totalDayVolume) {
        this.totalDayVolume = totalDayVolume;
    }

    public double getTotalDayVolume() {
        return totalDayVolume;
    }
}
