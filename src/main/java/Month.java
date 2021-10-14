import java.util.ArrayList;
import java.util.List;

public class Month extends Program {

    protected int monthLength; //number of weeks in a new month object
    protected int monthType; //hypertrophy, strength, peak, etc
    protected int xpLvl;
    protected double monthVolume; //overall reps?
    protected double[] ratios;
    protected ArrayList<Week> weeks;

    public Month(int monthType, int monthLength, int xpLvl) {
        this.setMonthType(monthType);
        this.setMonthLength(monthLength);
        this.setXpLvl(xpLvl);
        this.determineMonthVolume(this.monthLength);
        System.out.println("Volume for this month: " + this.getMonthVolume());
    }

    public void setMonthLength(int monthLength) {

        this.monthLength = monthLength;
    }

    public int getMonthLength() {
        return monthLength;
    }

    public void setMonthType(int monthType) {
        this.monthType = monthType;
    }

    public int getMonthType() {
        return monthType;
    }

    public void setMonthVolume(double monthVolume) { this.monthVolume = monthVolume; }

    public double getMonthVolume() { return monthVolume; }

    public void determineMonthVolume(int monthLength) {
        if (this.monthType == 0) {
            switch (this.xpLvl) {
                case 0: setMonthVolume(200 * monthLength);
                    break;
                case 1: setMonthVolume(225 * monthLength);
                    break;
                case 2: setMonthVolume(250 * monthLength);
                    break;
            }
        }
        else if (this.monthType == 1) {
            switch (this.xpLvl) {
                case 0: setMonthVolume(187.5 * monthLength);
                    break;
                case 1: setMonthVolume(212.5 * monthLength);
                    break;
                case 2: setMonthVolume(225 * monthLength);
                    break;
            }
        }
        else if (this.monthType == 2) {
            switch (this.xpLvl) {
                case 0: setMonthVolume(175 * monthLength);
                    break;
                case 1: setMonthVolume(187.5 * monthLength);
                    break;
                case 2: setMonthVolume(200 * monthLength);
                    break;
            }
        }
        else if (this.monthType == 3) {
            switch (this.xpLvl) {
                case 0: setMonthVolume(150 * monthLength);
                    break;
                case 1: setMonthVolume(162.5 * monthLength);
                    break;
                case 2: setMonthVolume(175 * monthLength);
                    break;
            }
        }
    }

    public void setXpLvl(int xpLvl) {
        this.xpLvl = xpLvl;
    }

    public int getXpLvl() {
        return xpLvl;
    }

    public void setRatios(double[] ratios) {
        this.ratios = ratios;
    }

    public double[] getRatios() {
        return ratios;
    }
}
