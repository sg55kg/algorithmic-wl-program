import java.util.ArrayList;

public class Day {

    protected int dayType, numberOfDays, dayOrder;
    protected double totalDayVolume, parentWeekVolume;
    protected double[] liftRatios;
    protected ArrayList<Exercise> exercises = new ArrayList<>();

    public Day(int dayOrder, double parentWeekVolume, double[] liftRatios, int numberOfDays) {
        this.dayOrder = dayOrder;
        this.liftRatios = liftRatios;
        this.numberOfDays = numberOfDays;
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

        } else if (dayOrder == 3) {
            if (numberOfDays == 3)
                this.dayType = 0;
             else if (numberOfDays == 4)
                this.dayType = 2;
             else
                this.dayType = 1;

        } else if (dayOrder == 4) {
            if (numberOfDays == 4)
                this.dayType = 0;
             else
                this.dayType = 2;

        } else if (dayOrder == 5) {
            if (numberOfDays == 5)
                this.dayType = 2;
             else
                this.dayType = 0;
        } else {
            this.dayType = 1;
        }
    }
}
