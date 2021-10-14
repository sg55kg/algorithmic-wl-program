import java.util.*;

public class Program {

    protected double snatch, cleanAndJerk, backSquat, pushPress;
    protected double[] liftRatios;
    protected int xpLvl, totalCycleLength;
    protected List<Month> months = new ArrayList<>();

    public Program(double snatch, double cleanAndJerk, double backSquat, double pushPress, int xpLvl, int totalCycleLength) {
        this.setLiftNumbers(snatch, cleanAndJerk, backSquat, pushPress);
        this.setLiftRatios(snatch, cleanAndJerk, backSquat, pushPress);
        this.setXpLvl(xpLvl);
        this.setTotalCycleLength(totalCycleLength);
        this.addMonthsToList();
    }

    public void setLiftNumbers(double snatch, double cleanAndJerk, double backSquat, double pushPress) {
        this.snatch = snatch;
        this.cleanAndJerk = cleanAndJerk;
        this.backSquat = backSquat;
        this.pushPress = pushPress;
    }

    public void setXpLvl(int xpLvl) { this.xpLvl = xpLvl; }

    public void setTotalCycleLength(int totalCycleLength) {
        this.totalCycleLength = totalCycleLength;
    }

    public void setLiftRatios(double snatch, double cleanAndJerk, double backSquat, double pushPress) {
        double[] ratios = new double[3];

        double snatchToCleanAndJerk = snatch / cleanAndJerk;
        double cleanAndJerkToSquat = cleanAndJerk / backSquat;
        double pushPressToCleanAndJerk = pushPress / cleanAndJerk;

        ratios[0] = snatchToCleanAndJerk;
        ratios[1] = cleanAndJerkToSquat;
        ratios[2] = pushPressToCleanAndJerk;

        this.liftRatios = ratios;
    }

    //dynamically add months to the List and set their types/lengths
    public void addMonthsToList() {
        int cycleLength = this.totalCycleLength;
        int monthType = 0, monthLength, subtractWeeks = 12;

        while(cycleLength > 0) {
            monthLength = cycleLength - subtractWeeks;
            Month month = new Month(monthType, monthLength, this.xpLvl, this.liftRatios);
            this.months.add(month);

            cycleLength = subtractWeeks;
            subtractWeeks -= 4;
            monthType++;
        }
    }
}
