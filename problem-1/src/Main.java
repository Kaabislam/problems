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