import java.util.*;

public class Program {

    protected double snatch, cleanAndJerk, backSquat, pushPress;
    protected double[] liftRatios;
    protected int xpLvl, totalCycleLength, daysPerWeek;
    protected List<Month> months = new ArrayList<>();

    public Program() {

    }

    public Program(double snatch, double cleanAndJerk, double backSquat, double pushPress, int xpLvl, int totalCycleLength, int daysPerWeek) {
        this.setLiftNumbers(snatch, cleanAndJerk, backSquat, pushPress);
        this.setLiftRatios(snatch, cleanAndJerk, backSquat, pushPress);
        this.setXpLvl(xpLvl);
        this.setTotalCycleLength(totalCycleLength);
        this.setDaysPerWeek(daysPerWeek);
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

    public void setDaysPerWeek(int daysPerWeek) {
        this.daysPerWeek = daysPerWeek;
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

    //set initial values for addMonthToList function
    public int setMonthTypeValue(int cycleLength) {
        int monthType;
        if (cycleLength > 12) {
            return monthType = 0;
        } else if (cycleLength > 8) {
            return monthType = 1;
        } else if (cycleLength > 4) {
            return monthType = 2;
        } else return monthType = 3;
    }

    public int setInitSubTractWeeksValue() {
        int subtractWeeks;
        if(this.totalCycleLength > 12) {
            return subtractWeeks = 12;
        } else if (this.totalCycleLength > 8) {
            return subtractWeeks = 8;
        } else if (this.totalCycleLength > 4) {
            return subtractWeeks = 4;
        } else return subtractWeeks = 0;
    }

    //dynamically add months to the List and set their types/lengths
    public void addMonthsToList() {
        int cycleLength = this.totalCycleLength;
        int monthLength, subtractWeeks = setInitSubTractWeeksValue();

        while(cycleLength > 0) {

            monthLength = cycleLength - subtractWeeks;
            int monthType = setMonthTypeValue(cycleLength);
            Month month = new Month(monthType, monthLength, this.xpLvl, this.liftRatios, this.daysPerWeek);
            this.months.add(month);

            cycleLength = subtractWeeks;
            subtractWeeks -= 4;
        }
    }
}
