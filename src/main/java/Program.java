import java.util.LinkedList;
import java.util.List;

public final class Program {


    private double snatch, cleanJerk, backSquat, pushPress;
    private int xpLvl, cycleLength;

    public void setProgramValues(double snatch, double cleanJerk, double backSquat, double pushPress, int xpLvl, int cycleLength) {
        this.snatch = snatch;
        this.cleanJerk = cleanJerk;
        this.backSquat = backSquat;
        this.pushPress = pushPress;
        this.xpLvl = xpLvl;
        this.cycleLength = cycleLength;
    }

    //return ratios between lifts
    public double[] getRatios() {
        double snatchToCJ = snatch / cleanJerk;
        double cleanJerkToBS = cleanJerk / backSquat;
        double pushPressToCJ = cleanJerk / pushPress;

        return new double[] { snatchToCJ, cleanJerkToBS, pushPressToCJ };
    }

    //get lengths (in weeks) of each phase/month. If 16, each gets 4 weeks. If 15, hypertrophy gets 3, rest 4, etc.
    public List<Integer> getMonthLengths(int cycleLength) {
        int hypertrophyLength, strengthLength, powerLength, peakLength;
        List<Integer> monthLengths = new LinkedList<>();

        int tempCycleLength = cycleLength;

        while(tempCycleLength > 0) {
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
            }
        }
        return monthLengths;
    }

    //
    public double getCycleReps(List<Integer> monthLengths, int xpLvl) {
        return 0;
    }

    //take ratios and return percentage of volume each lift should have
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
        return new double[] { snatchVolume, cleanJerkVolume, squatVolume, pressVolume,accessoryVolume };
    }

    public double[] getMonthlyVolume(double[] liftsVolume, double totalMonthReps) {
        double snatchReps, cleanAndJerkReps, squatReps, pressReps, accessories;

        snatchReps = totalMonthReps * liftsVolume[0];
        cleanAndJerkReps = totalMonthReps * liftsVolume[1];
        squatReps = totalMonthReps * liftsVolume[2];
        pressReps = totalMonthReps * liftsVolume[3];
        accessories = totalMonthReps * liftsVolume[4];

        return new double[] { snatchReps, cleanAndJerkReps, squatReps, pressReps, accessories };
    }
}
