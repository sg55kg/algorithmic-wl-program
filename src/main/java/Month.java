import java.util.ArrayList;
import java.util.List;

public class Month {

    protected int monthLength; //number of weeks in a new month object
    protected int monthType; //hypertrophy, strength, peak, etc
    protected int xpLvl;
    protected double monthVolume; //overall reps?
    protected double[] ratios;
    protected ArrayList<Week> weeks;

    public void setMonthLength(int monthLength) {

        this.monthLength = monthLength; //passed down from Program class?
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

    public void setMonthVolume(double monthVolume) {
        this.monthVolume = monthVolume;
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
