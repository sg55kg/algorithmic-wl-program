import java.util.*;

public class Program {

    protected double snatch, cleanAndJerk, backSquat, pushPress;
    protected int xpLvl, totalCycleLength, numberOfMonths;
    protected List<Month> months = new ArrayList<>();

    public void setLiftNumbers(double snatch, double cleanAndJerk, double backSquat, double pushPress) {
        this.snatch = snatch;
        this.cleanAndJerk = cleanAndJerk;
        this.backSquat = backSquat;
        this.pushPress = pushPress;
    }

    public void setXpLvl(int xpLvl) {
        this.xpLvl = xpLvl;
    }

    public void setTotalCycleLength(int totalCycleLength) {
        this.totalCycleLength = totalCycleLength;
    }

    public void setNumberOfMonths() {

        if(this.totalCycleLength > 12) {
            this.numberOfMonths = 4;
        } else if(this.totalCycleLength > 8) {
            this.numberOfMonths = 3;
        } else if(this.totalCycleLength > 4) {
            this.numberOfMonths = 2;
        } else if(this.totalCycleLength > 0) {
            this.numberOfMonths = 1;
        } else this.numberOfMonths = 0;
    }

    public int getNumberOfMonths() {
        return numberOfMonths;
    }

    //dynamically add months to the List and set their types/lengths
    public void addMonthsToList() {
        int cycleLength = this.totalCycleLength;
        int monthType = 0, monthLength, subtractWeeks = 12;

        while(cycleLength > 0) {
            monthLength = cycleLength - subtractWeeks;
            Month month = new Month(monthType, monthLength, this.xpLvl);
            this.months.add(month);
            cycleLength = subtractWeeks;
            subtractWeeks -= 4;
            monthType++;
            System.out.println(month);
            System.out.println(month.getMonthLength());
        }
    }
}
