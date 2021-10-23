import java.util.ArrayList;

public class Day {

    protected int dayType, daysPerWeek, dayOrder, weekType;
    protected double totalDayVolume, parentWeekVolume;
    protected double[] liftRatios;
    protected ArrayList<Exercise> exercises = new ArrayList<>();

    public Day(int dayOrder, double parentWeekVolume, int daysPerWeek, int weekType) {
        this.dayOrder = dayOrder;
        this.daysPerWeek = daysPerWeek;
        this.parentWeekVolume = parentWeekVolume;
        this.weekType = weekType;
        this.setDayType();
    }

    public void setDayType() {
        //0 type day = heavy, 1 type = medium, 2 type = easy
        int dayOrder = getDayOrder();
        int daysPerWeek = getDaysPerWeek();

        if (dayOrder == 0) {
            if (daysPerWeek > 5)
                this.dayType = 0;
             else
                this.dayType = 1;

        } else if (dayOrder == 1) {
            if (daysPerWeek > 4)
                this.dayType = 2;
             else
                this.dayType = 1;

        } else if (dayOrder == 2) {
            if (daysPerWeek == 3)
                this.dayType = 0;
             else if (daysPerWeek == 4)
                this.dayType = 2;
             else
                this.dayType = 1;

        } else if (dayOrder == 3) {
            if (daysPerWeek == 4)
                this.dayType = 0;
             else
                this.dayType = 2;

        } else if (dayOrder == 4) {
            if (daysPerWeek == 5)
                this.dayType = 2;
             else
                this.dayType = 0;
        } else {
            this.dayType = 1;
        }
    }

    public void printDayInfo() {
        System.out.println("Day: " + (dayOrder + 1) + " Type: " + getDayType() + " Reps: " + getTotalDayVolume());
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

    public int getDayOrder() {
        return dayOrder;
    }

    public int getDaysPerWeek() {
        return daysPerWeek;
    }
}
