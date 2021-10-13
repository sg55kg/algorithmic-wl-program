import java.util.ArrayList;

public class Week {

    protected int numberOfDays;
    protected int weekType; //deload week, top week, etc
    protected int weekVolume; //reps per week
    protected ArrayList<Day> days;

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setWeekType(int weekType) {
        this.weekType = weekType;
    }

    public int getWeekType() {
        return weekType;
    }

    public void setWeekVolume(int weekVolume) {
        this.weekVolume = weekVolume;
    }

    public int getWeekVolume() {
        return weekVolume;
    }
}
