import java.util.*;

public final class Program {

    private double snatch, cleanJerk, backSquat, pushPress;
    private int xpLvl, cycleLength;
    private ArrayList<Month> months;


    public void setProgramValues(double snatch, double cleanJerk, double backSquat, double pushPress, int xpLvl, int cycleLength) {
        this.snatch = snatch;
        this.cleanJerk = cleanJerk;
        this.backSquat = backSquat;
        this.pushPress = pushPress;
        this.xpLvl = xpLvl;
        this.cycleLength = cycleLength;
        //this might be redundant if the snatch/cj/etc variables are stored in the App class anyway
    }

    //return ratios between lifts
    public double[] getRatios() {
        double snatchToCJ = snatch / cleanJerk;
        double cleanJerkToBS = cleanJerk / backSquat;
        double pushPressToCJ = cleanJerk / pushPress;

        return new double[]{snatchToCJ, cleanJerkToBS, pushPressToCJ};
    }

    //get lengths (in weeks) of each phase/month. If 16, each gets 4 weeks. If 15, hypertrophy gets 3, rest 4, etc.
    public List<Integer> getMonthLengths() {
        int hypertrophyLength, strengthLength, powerLength, peakLength;
        List<Integer> monthLengths = new ArrayList<>();

        int tempCycleLength = cycleLength;

        while (tempCycleLength > 0) {
            if (tempCycleLength > 12) {
                hypertrophyLength = tempCycleLength - 12;
                monthLengths.add(hypertrophyLength);
                tempCycleLength = 12;

            } else if (tempCycleLength > 8) {
                strengthLength = tempCycleLength - 8;
                monthLengths.add(strengthLength);
                tempCycleLength = 8;

            } else if (tempCycleLength > 4) {
                powerLength = tempCycleLength - 4;
                monthLengths.add(powerLength);
                tempCycleLength = 4;
            } else {
                peakLength = tempCycleLength;
                monthLengths.add(peakLength);
                tempCycleLength = 0;
            }
        }
        return monthLengths;
    }

    //
    public double[] getCycleReps(List<Integer> monthLengths) {
        double hypertrophyReps = 0.0, strengthReps = 0.0, powerReps = 0.0, peakReps = 0.0;

        if (xpLvl == 0) {
            hypertrophyReps = monthLengths.get(0) * 200.0;
            strengthReps = monthLengths.get(1) * 175.0;
            powerReps = monthLengths.get(2) * 150.0;
            peakReps = monthLengths.get(3) * 125.0;
        }

        if (xpLvl == 1) {
            hypertrophyReps = monthLengths.get(0) * 225.0;
            strengthReps = monthLengths.get(1) * 200.0;
            powerReps = monthLengths.get(2) * 175.0;
            peakReps = monthLengths.get(3) * 125.0;
        }

        if (xpLvl == 2) {
            hypertrophyReps = monthLengths.get(0) * 250.0;
            strengthReps = monthLengths.get(1) * 200.0;
            powerReps = monthLengths.get(2) * 150.0;
            peakReps = monthLengths.get(3) * 125.0;
        }
        return new double[]{hypertrophyReps, strengthReps, powerReps, peakReps};
    }

    //take ratios and return percentage of volume each lift should have
    //this method can probably be moved to the Month or week class, and each month object will get the ratios/reps/etc
    //and use a method like this to determine the percentage of volume each lift will get
    public double[] getVolumePercentages(double[] ratios) {
        double snatchVolume = .20;
        double cleanJerkVolume = .20;
        double squatVolume = .20;
        double pressVolume = .20;
        double accessoryVolume = .20;

        if (ratios[0] > .80) {
            snatchVolume -= .025;
            cleanJerkVolume += .025;
        } else if (ratios[0] < .75) {
            snatchVolume += .025;
            cleanJerkVolume -= .025;
        }

        if (ratios[1] > .80) {
            squatVolume += .05;
            pressVolume += .025;
            accessoryVolume += .025;
            snatchVolume -= .05;
            cleanJerkVolume -= .05;
        } else if (ratios[1] < .75) {
            squatVolume -= .05;
            cleanJerkVolume += .025;
            snatchVolume += .025;
        }

        if (ratios[2] > .80) {
            pressVolume -= .05;
            cleanJerkVolume += .025;
            snatchVolume += .025;
        } else if (ratios[2] > .70) {
            pressVolume += .05;
            snatchVolume -= .025;
            cleanJerkVolume -= .025;
        }
        return new double[]{snatchVolume, cleanJerkVolume, squatVolume, pressVolume, accessoryVolume};
    }

    public double[] getMonthlyVolume(double[] liftsVolumePercent, double totalMonthReps) {
        double snatchReps, cleanAndJerkReps, squatReps, pressReps, accessories;

        snatchReps = totalMonthReps * liftsVolumePercent[0];
        cleanAndJerkReps = totalMonthReps * liftsVolumePercent[1];
        squatReps = totalMonthReps * liftsVolumePercent[2];
        pressReps = totalMonthReps * liftsVolumePercent[3];
        accessories = totalMonthReps * liftsVolumePercent[4];

        return new double[]{snatchReps, cleanAndJerkReps, squatReps, pressReps, accessories};
    }

    public void createMonths(double[] cycleReps, int xpLvl, double[] ratios) {
        this.months = null;
    }
}
