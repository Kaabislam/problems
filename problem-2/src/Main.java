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