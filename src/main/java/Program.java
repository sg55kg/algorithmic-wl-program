import java.util.*;

public class Program {

    protected double snatch, cleanAndJerk, backSquat, pushPress;
    protected int xpLvl, totalCycleLength;
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

    public List<Integer> setMonthLengths() {
        int cycleLength = this.totalCycleLength;
        List<Integer> monthLengths = new ArrayList<>();

        while(cycleLength > 0) {
            if (cycleLength > 12) {
                int hypertrophyCycleLength = cycleLength - 12;
                monthLengths.add(hypertrophyCycleLength);
                cycleLength = 12;
            } else if (cycleLength > 8) {
                int strengthCycleLength = cycleLength - 8;
                monthLengths.add(strengthCycleLength);
                cycleLength = 8;
            } else if (cycleLength > 4) {
                int powerCycleLength = cycleLength - 4;
                monthLengths.add(powerCycleLength);
                cycleLength = 4;
            } else if (cycleLength > 0) {
                int peakCycleLength = cycleLength;
                monthLengths.add(peakCycleLength);
                cycleLength = 0;
            }
        }
        return monthLengths;
    }

    public void addMonth(List<Integer> monthLengths) {
        for (int monthLength : monthLengths) {
            Month month = new Month();
            month.setMonthLength(monthLength);
            this.months.add(month);
        }
    }
}
