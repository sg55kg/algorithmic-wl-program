import java.util.ArrayList;

public class Week {

    protected int numberOfDays;
    protected int weekType; //deload week, top week, etc
    protected int parentMonthSize;
    protected double weekVolume, totalVolume; //reps per week and overall
    protected ArrayList<Day> days = new ArrayList<>();

    public Week(int weekType, int numberOfDays, double totalVolume, int parentMonthSize) {
        this.setWeekType(weekType);
        this.setNumberOfDays(numberOfDays);
        this.setTotalVolume(totalVolume);
        this.setParentMonthSize(parentMonthSize);
        this.determineWeekVolume();

        System.out.println("Reps for this week: " + this.weekVolume + " reps");

        this.setDays(numberOfDays, weekType);
    }

    public void determineWeekVolume() {
        if(this.parentMonthSize == 4) {
            switch (this.weekType) {
                case 0:
                    setWeekVolume(this.totalVolume * .275);
                    break;
                case 1:
                    setWeekVolume(this.totalVolume * .325);
                    break;
                case 2:
                    setWeekVolume(this.totalVolume * .20);
                    break;
                case 3:
                    setWeekVolume(this.totalVolume * .225);
                    break;
            }
        }
        else if(this.parentMonthSize == 3) {
            switch (this.weekType) {
                case 0:
                    setWeekVolume(this.totalVolume * .275);
                    break;
                case 1:
                    setWeekVolume(this.totalVolume * .35);
                    break;
                case 2:
                    setWeekVolume(this.totalVolume * .375);
                    break;
            }
        }
        else if(this.parentMonthSize == 2) {
            switch (this.weekType) {
                case 0:
                    setWeekVolume(this.totalVolume * .45);
                    break;
                case 1:
                    setWeekVolume(this.totalVolume * .55);
                    break;
            }
        }
        else {
            setWeekVolume(this.totalVolume);
        }
    }

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

    public void setWeekVolume(double weekVolume) {
        this.weekVolume = weekVolume;
    }

    public double getWeekVolume() {
        return weekVolume;
    }

    public void setTotalVolume(double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public void setParentMonthSize(int parentMonthSize) {
        this.parentMonthSize = parentMonthSize;
    }

    public void setDays(int numberOfDays, int weekType) {
        int i = 0;
        int dayOrder = 0;
        while (i < numberOfDays) {
            Day day = new Day(dayOrder, this.weekVolume, this.numberOfDays, weekType);
            dayOrder++;
            i++;
        }
    }

    public void setDayVolumes(ArrayList<Day> days, double weekVolume) {
        for (Day day : days) {
            if (day.getDayType() == 0) {
                
            }
        }
    }
}
