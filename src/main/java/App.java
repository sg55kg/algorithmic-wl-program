//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    public static int getExperienceLevel(String s) {
        return switch (s.toUpperCase()) {
            case ("BEGINNER") -> 0;
            case ("INTERMEDIATE") -> 1;
            case ("ADVANCED") -> 2;
            default -> throw new IllegalArgumentException("Error, not an acceptable value: " + s.toUpperCase());
        };
    }

    public static void main(String[] args) {
        //declare variables
        Scanner input = new Scanner(System.in);
        double snatch, cleanAndJerk, backSquat, pushPress;
        String xpLvlStr;
        int distanceFromPeak, daysPerWeek;

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

        //get total length of macrocycle
        System.out.println("How many weeks out are you from competition/max day?");
        distanceFromPeak = input.nextInt();

        //get number of days per week user will train
        System.out.println("How many days per week will you train?");
        daysPerWeek = input.nextInt();

        //init new program with user input values
        Program program = new Program
                (snatch, cleanAndJerk, backSquat, pushPress, experienceLevel, distanceFromPeak, daysPerWeek);
    }
}
