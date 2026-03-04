import java.util.Scanner;

public class UC10_CaseInsensitiveSpaceIgnoredPalindrome {

    // Method for UC10
    public static boolean isPalindrome(String input) {

        // Step 1: Normalize string
        // Convert to lowercase
        input = input.toLowerCase();

        // Remove all spaces using regex
        input = input.replaceAll("\\s+", "");

        // Step 2: Check palindrome
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== UC10: Case-Insensitive & Space-Ignored Palindrome ===");
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println("It is a Palindrome.");
        } else {
            System.out.println("It is NOT a Palindrome.");
        }

        sc.close();
    }
}
