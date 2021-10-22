import java.util.ArrayList;
import java.util.List;

public class Month extends Program {

    protected int monthLength; //number of weeks in a new month object
    protected int monthType; //hypertrophy, strength, peak, etc
    protected int xpLvl;
    protected double monthVolume; //overall reps?
    protected ArrayList<Week> weeks = new ArrayList<>();

    public Month() {
        super();
        this.monthLength = 4;
        this.monthType = 0;
    }

    public Month(int monthType, int monthLength, int daysPerWeek) {
        this.setMonthType(monthType);
        this.setMonthLength(monthLength);
        this.daysPerWeek = daysPerWeek;
        this.determineMonthVolume();

        System.out.println("Volume for this month: " + this.getMonthVolume());
        System.out.println("Weeks in this month: " + this.getMonthLength());
        System.out.println("Type of month: " + this.getMonthType());

        this.createWeeks();
    }

    public void setMonthLength(int monthLength) { this.monthLength = monthLength; }

    public int getMonthLength() {
        return this.monthLength;
    }

    public void setMonthType(int monthType) {
        this.monthType = monthType;
    }

    public int getMonthType() {
        return this.monthType;
    }

    public void setXpLvl(int xpLvl) { this.xpLvl = xpLvl; }

    public double[] getLiftRatios() {
        return this.liftRatios;
    }

    public void setMonthVolume(double monthVolume) { this.monthVolume = monthVolume; }

    public double getMonthVolume() { return monthVolume; }

    public int getDaysPerWeek() { return this.daysPerWeek; }

    public void determineMonthVolume() {
        if (monthType == 0) {
            switch (xpLvl) {
                case 0: setMonthVolume(200 * monthLength);
                    break;
                case 1: setMonthVolume(225 * monthLength);
                    break;
                case 2: setMonthVolume(250 * monthLength);
                    break;
            }
        }
        else if (monthType == 1) {
            switch (xpLvl) {
                case 0: setMonthVolume(187.5 * monthLength);
                    break;
                case 1: setMonthVolume(212.5 * monthLength);
                    break;
                case 2: setMonthVolume(225 * monthLength);
                    break;
            }
        }
        else if (monthType == 2) {
            switch (xpLvl) {
                case 0: setMonthVolume(175 * monthLength);
                    break;
                case 1: setMonthVolume(187.5 * monthLength);
                    break;
                case 2: setMonthVolume(200 * monthLength);
                    break;
            }
        }
        else if (monthType == 3) {
            switch (xpLvl) {
                case 0: setMonthVolume(150 * monthLength);
                    break;
                case 1: setMonthVolume(162.5 * monthLength);
                    break;
                case 2: setMonthVolume(175 * monthLength);
                    break;
            }
        }
    }

    public void createWeeks() {
        int weekType = 0;
        for(int i = 0; i < monthLength; i++) {
            Week week = new Week(weekType, this.daysPerWeek, this.monthVolume, this.monthLength);
            weeks.add(week);
            weekType++;
        }
    }

}
