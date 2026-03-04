import java.util.Stack;

public class PalindromeCheckerApp {

    // Encapsulated data
    private String input;

    // Constructor
    public PalindromeCheckerApp(String input) {
        this.input = input;
    }

    // Public service method
    public boolean checkPalindrome() {

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Compare original string with reversed string
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}