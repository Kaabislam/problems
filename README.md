Both the problem Solution available on master branch

## PROBLEM-1

import java.util.Scanner;

public class Main {
    /*
     Approach: Iterate through each test case and check each checkpoint (except the first and last)
     to see if it is strictly greater than its neighbors. Count such checkpoints as peaks.
     Time Complexity: O(T * N), where T is the number of test cases and N is the number of checkpoints.
     Space Complexity: O(N) per test case for storing heights.
    */
    private static int countPeaks(int[] heights) {
        int peakCount = 0;

        // A peak must have at least one checkpoint before and after it
        for (int i = 1; i < heights.length - 1; i++) {
            if (heights[i] > heights[i - 1] && heights[i] > heights[i + 1]) {
                peakCount++;
            }
        }

        return peakCount;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int testCaseCount = scanner.nextInt();

        // Process each test case
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int checkpointCount = scanner.nextInt();
            int[] heights = new int[checkpointCount];

            // Read the heights of the checkpoints
            for (int i = 0; i < checkpointCount; i++) {
                heights[i] = scanner.nextInt();
            }
            // Count the number of peaks
            int peakCount = countPeaks(heights);
            // Print the result for the current test case
            System.out.printf("Case #%d: %d%n", testCase, peakCount);
        }

        scanner.close();
    }
}


## PROBLEM-2

import java.util.Scanner;

public class Main {

    /*
     Approach: Iterate through the string, collect alphabets and sum digits separately.
     Sort the alphabets and append the sum to the sorted string.
     Time Complexity: O(L * log(L)), where L is the length of the string (due to sorting).
     Space Complexity: O(L) for storing alphabets and digits.
    */

    private static String processString(String input) {
        StringBuilder alphabets = new StringBuilder();
        int digitSum = 0;

        // Iterate through each character in the string
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                alphabets.append(ch); // Collect alphabets
            } else if (Character.isDigit(ch)) {
                digitSum += Character.getNumericValue(ch); // Sum up the digits
            }
        }

        // Sort the collected alphabets
        char[] alphabetArray = alphabets.toString().toCharArray();
        java.util.Arrays.sort(alphabetArray);

        // Construct the final result
        return new String(alphabetArray) + digitSum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string:");
        String input = scanner.nextLine();

        String result = processString(input);

        System.out.println(result);

        scanner.close();
    }
}
