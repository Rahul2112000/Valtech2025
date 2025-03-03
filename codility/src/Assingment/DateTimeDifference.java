package Assingment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimeDifference {

    // Method to compute the time difference
    public static String computeTimeDifference(LocalDateTime startTime, LocalDateTime endTime) {
        if (endTime.isBefore(startTime)) {
            return "End time must be after start time.";
        }

        // Calculate the duration between the two times
        Duration duration = Duration.between(startTime, endTime);

        // Extract days, hours, and minutes
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;

        return String.format("%d day(s), %d hour(s), %d minute(s)", days, hours, minutes);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // DateTime format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
            // Input start time
            System.out.println("Enter start time (yyyy-MM-dd HH:mm):");
            String startTimeInput = scanner.nextLine();
            LocalDateTime startTime = LocalDateTime.parse(startTimeInput, formatter);

            // Input end time
            System.out.println("Enter end time (yyyy-MM-dd HH:mm):");
            String endTimeInput = scanner.nextLine();
            LocalDateTime endTime = LocalDateTime.parse(endTimeInput, formatter);

            // Compute and display the difference
            String result = computeTimeDifference(startTime, endTime);
            System.out.println("Time Difference: " + result);
        } catch (Exception e) {
            System.out.println("Invalid input format. Please use yyyy-MM-dd HH:mm.");
        }

        scanner.close();
    }
}
