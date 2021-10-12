//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    public static final double firstMonthReps = 1000;
    public static final double secondMonthReps = 800;
    public static final double thirdMonthReps = 600;
    public static final double fourthMonthReps = 400;

    public static void printMonthlyVolume(double[] arr) {

        System.out.println("Volume for the month:");
        System.out.println("Total snatch reps: " + Math.ceil(arr[0]));
        System.out.println("Total clean and jerk reps: " + Math.ceil(arr[1]));
        System.out.println("Total squat reps: " + Math.ceil(arr[2]));
        System.out.println("Total press/push press reps: " + Math.ceil(arr[3]));
        System.out.println("Total accessory reps: " + (Math.ceil(arr[4])));
        System.out.println(" ");
    }

    public static int getExperienceLevel(String s) {
        return switch (s.toUpperCase()) {
            case ("BEGINNER") -> 0;
            case ("INTERMEDIATE") -> 1;
            case ("ADVANCED") -> 2;
            default -> throw new IllegalArgumentException("Error, not an acceptable value: " + s.toUpperCase());
        };
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double snatch, cleanAndJerk, backSquat, pushPress;
        String xpLvlStr;
        int distanceFromPeak;

        //get max sn/cj/bs/pp
        System.out.println("Enter max snatch:");
        snatch = input.nextDouble();
        System.out.println("Enter max clean and jerk:");
        cleanAndJerk = input.nextDouble();
        System.out.println("Enter max back squat:");
        backSquat = input.nextDouble();
        System.out.println("Enter max pushPress:");
        pushPress = input.nextDouble();

        //get experience level
        System.out.println("Enter experience level: (Beginner, intermediate, or advanced)");
        xpLvlStr = input.next();
        int experienceLevel = getExperienceLevel(xpLvlStr);

        //get length of cycle
        System.out.println("How far out are you from competition/max day?");
        distanceFromPeak = input.nextInt();

        Program program = new Program();
        program.setProgramValues(snatch, cleanAndJerk, backSquat, pushPress, experienceLevel, distanceFromPeak);



        double[] ratios = program.getRatios();

        List<Integer> monthLengths = program.getMonthLengths(distanceFromPeak);

        double[] allCycleReps = program.getCycleReps(monthLengths, experienceLevel);

        double hypertrophyPhaseReps = allCycleReps[0];
        double strengthPhaseReps = allCycleReps[1];
        double powerPhaseReps = allCycleReps[2];
        double peakPhaseReps = allCycleReps[3];

        double[] volumePercentages = program.getVolumePercentages(ratios);

        double[] hyperTrophyPhaseVolume = program.getMonthlyVolume(volumePercentages, hypertrophyPhaseReps);
        double[] strengthPhaseVolume = program.getMonthlyVolume(volumePercentages, strengthPhaseReps);
        double[] powerPhaseVolume = program.getMonthlyVolume(volumePercentages, powerPhaseReps);
        double[] peakingPhaseVolume = program.getMonthlyVolume(volumePercentages, peakPhaseReps);

        printMonthlyVolume(hyperTrophyPhaseVolume);
        printMonthlyVolume(strengthPhaseVolume);
        printMonthlyVolume(powerPhaseVolume);
        printMonthlyVolume(peakingPhaseVolume);
    }
}
