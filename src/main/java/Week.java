import java.util.ArrayList;

public class Week extends Programmable {

    protected int weekType; //deload week, top week, etc
    protected int parentMonthSize;
    protected double weekVolume, parentMonthVolume; //reps per week and overall
    protected ArrayList<Day> days = new ArrayList<>();

    public Week() {
        super();
    }

    public Week(int weekType, int daysPerWeek, double parentMonthVolume, int parentMonthSize) {
        this.weekType = weekType;
        this.daysPerWeek = daysPerWeek;
        this.parentMonthVolume = parentMonthVolume;
        this.setParentMonthSize(parentMonthSize);
        this.determineWeekVolume();
        printWeekInfo();
        this.createDays();
        this.setDayVolumes(this.days);
        printDayInfo();
    }

    public void determineWeekVolume() {
        if(this.parentMonthSize == 4) {
            switch (this.weekType) {
                case 0:
                    setWeekVolume(this.parentMonthVolume * .275);
                    break;
                case 1:
                    setWeekVolume(this.parentMonthVolume * .325);
                    break;
                case 2:
                    setWeekVolume(this.parentMonthVolume * .20);
                    break;
                case 3:
                    setWeekVolume(this.parentMonthVolume * .225);
                    break;
            }
        }
        else if(this.parentMonthSize == 3) {
            switch (this.weekType) {
                case 0:
                    setWeekVolume(this.parentMonthVolume * .275);
                    break;
                case 1:
                    setWeekVolume(this.parentMonthVolume * .35);
                    break;
                case 2:
                    setWeekVolume(this.parentMonthVolume * .375);
                    break;
            }
        }
        else if(this.parentMonthSize == 2) {
            switch (this.weekType) {
                case 0:
                    setWeekVolume(this.parentMonthVolume * .45);
                    break;
                case 1:
                    setWeekVolume(this.parentMonthVolume * .55);
                    break;
            }
        }
        else {
            setWeekVolume(this.parentMonthVolume);
        }
    }

    public void createDays() {
        int daysPerWeek = getDaysPerWeek();
        double weekVolume = getWeekVolume();
        int weekType = getWeekType();
        int dayOrder = 0;

        for(int i = 0; i < daysPerWeek; i++) {
            Day day = new Day(dayOrder, weekVolume, daysPerWeek, weekType);
            days.add(day);
            dayOrder++;
        }
    }

    public void setDayVolumes(ArrayList<Day> days) {
        double dayVolume;
        double weekVolume = this.weekVolume;
        int daysPerWeek = getDaysPerWeek();
        //0 - hard day, 1 - med day, 2 - easy day
        for (Day day : days) {
            if (day.getDayType() == 0) {
                dayVolume = Math.floor(weekVolume * (.40 - (.05 * (daysPerWeek - 1))));
                day.setTotalDayVolume(dayVolume);
            } else if (day.getDayType() == 1) {
                if (daysPerWeek == 6) {
                    dayVolume = Math.floor(weekVolume * .25);
                } else {
                    dayVolume = Math.floor(weekVolume * (.40 - (.025 * (daysPerWeek - 1))));
                }
                day.setTotalDayVolume(dayVolume);
            } else {
                dayVolume = Math.floor(weekVolume * (.225 - (.025 * (daysPerWeek - 1))));
                day.setTotalDayVolume(dayVolume);
            }
        }
    }

    public void printWeekInfo() {
        System.out.println("Week type: " + getWeekType() + " Total volume: " + getWeekVolume());
    }

    public void printDayInfo() {
        for (Day day : this.days) {
            System.out.println("Day: " + (day.dayOrder + 1) + " Type: " + day.getDayType() + " Reps: " + day.getTotalDayVolume());
        }
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

    public void setParentMonthSize(int parentMonthSize) {
        this.parentMonthSize = parentMonthSize;
    }
}
