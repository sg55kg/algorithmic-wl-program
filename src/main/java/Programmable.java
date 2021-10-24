public abstract class Programmable {
    double snatch, cleanAndJerk, backSquat, pushPress;
    int daysPerWeek, totalCycleLength, xpLvl;
    double[] liftRatios;

    public void setLiftNumbers(double snatch, double cleanAndJerk, double backSquat, double pushPress) {
        this.snatch = snatch;
        this.cleanAndJerk = cleanAndJerk;
        this.backSquat = backSquat;
        this.pushPress = pushPress;
    }

    public void setDaysPerWeek(int daysPerWeek) {
        this.daysPerWeek = daysPerWeek;
    }

    public void setXpLvl(int xpLvl) {
        this.xpLvl = xpLvl;
    }

    public void setLiftRatios() {
        double[] ratios = new double[3];

        double snatchToCleanAndJerk = Math.round(this.snatch / this.cleanAndJerk * 100) / 100.0;
        double cleanAndJerkToSquat = Math.round(this.cleanAndJerk / this.backSquat * 100) / 100.0;
        double pushPressToCleanAndJerk = Math.round(this.pushPress / this.cleanAndJerk * 100) / 100.0;

        ratios[0] = snatchToCleanAndJerk;
        ratios[1] = cleanAndJerkToSquat;
        ratios[2] = pushPressToCleanAndJerk;

        this.liftRatios = ratios;
    }

    public int getTotalCycleLength() {
        return totalCycleLength;
    }

    public int getXpLvl() {
        return xpLvl;
    }

    public int getDaysPerWeek() {
        return daysPerWeek;
    }

    public double[] getLiftRatios() {
        return liftRatios;
    }
}
