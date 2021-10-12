import java.util.Arrays;
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
        System.out.println(ratios[0]);

        double[] volumePercentages = program.getVolumePercentages(ratios);

        double[] hyperTrophyPhaseVolume = program.getMonthlyVolume(volumePercentages, firstMonthReps);
        double[] strengthPhaseVolume = program.getMonthlyVolume(volumePercentages, secondMonthReps);
        double[] powerPhaseVolume = program.getMonthlyVolume(volumePercentages, thirdMonthReps);
        double[] peakingPhaseVolume = program.getMonthlyVolume(volumePercentages, fourthMonthReps);

        printMonthlyVolume(hyperTrophyPhaseVolume);
        printMonthlyVolume(strengthPhaseVolume);
        printMonthlyVolume(powerPhaseVolume);
        printMonthlyVolume(peakingPhaseVolume);
    }
}
