package Assingment;

import java.util.*;

public class MobileRank {

    static class MobileRanking {
        String number;
        int rank;

        MobileRanking(String number, int rank) {
            this.number = number;
            this.rank = rank;
        }
    }

    private static int calcRank(String num) {
        int rank = 0;

        // Check for ascending order
        boolean isAscending = true;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) < num.charAt(i - 1)) {
                isAscending = false;
                break;
            }
        }
        if (isAscending) rank += 30; // Highest priority

        // Check for descending order
        boolean isDescending = true;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) > num.charAt(i - 1)) {
                isDescending = false;
                break;
            }
        }
        if (isDescending) rank += 20; // Second highest priority

        // Check for repeated digits
        Set<Character> digits = new HashSet<>();
        int repeatedCount = 0;
        for (char c : num.toCharArray()) {
            if (!digits.add(c)) {
                repeatedCount++;
            }
        }
        if (repeatedCount > 0) rank += (repeatedCount * 5); // Weighted by repetitions

        return rank;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of mobiles:");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        List<String> mobiles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the mobile " + (i + 1) + ":");
            String number = sc.nextLine();

            // Validate mobile number length (must be 10 digits)
            if (number.length() != 10 || !number.matches("\\d{10}")) {
                System.out.println("Invalid mobile number! It must be exactly 10 digits. Skipping this number.");
                continue;
            }

            mobiles.add(number);
        }

        List<MobileRanking> rankNumber = new ArrayList<>();
        for (String num : mobiles) {
            int rank = calcRank(num);
            rankNumber.add(new MobileRanking(num, rank));
        }

        // Sort by rank (descending) and then by the number itself (ascending)
        rankNumber.sort((a, b) -> {
            if (a.rank != b.rank) {
                return Integer.compare(b.rank, a.rank); // Higher rank first
            } else {
                return a.number.compareTo(b.number); // If same rank, sort by number
            }
        });

        // Display the ranked mobile numbers
        System.out.println("\nMobiles based on rank:");
        int rank = 1;
        for (MobileRanking mr : rankNumber) {
            System.out.println("Mobile Number: " + mr.number + " | Rank: " + rank);
            rank++;
        }

        sc.close();
    }
}
