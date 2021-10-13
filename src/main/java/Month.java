public class Month {

    protected int monthLength; //number of weeks in a new month object
    protected int monthType; //hypertrophy, strength, peak, etc
    protected int monthVolume; //overall reps?

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

    public void setMonthVolume(int monthVolume) {
        this.monthVolume = monthVolume;
    }
}
