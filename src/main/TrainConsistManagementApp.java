package main;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("        UC11 - Validate Train ID and Cargo Code           ");
        System.out.println("==========================================================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // ---- DEFINE REGEX RULES
        String trainIdRegex = "TRN-\\d{4}";
        String cargoCodeRegex = "PET-[A-Z]{2}";

        // Compile and Match Train ID
        Pattern trainPattern = Pattern.compile(trainIdRegex);
        Matcher trainMatcher = trainPattern.matcher(trainId);
        boolean isTrainValid = trainMatcher.matches();

        // Compile and Match Cargo Code
        Pattern cargoPattern = Pattern.compile(cargoCodeRegex);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);
        boolean isCargoValid = cargoMatcher.matches();

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);

        System.out.println("\nUC11 validation completed ...");
        scanner.close();
    }
}