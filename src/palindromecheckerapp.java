import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class PalindromeCheck {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = sc.nextLine();

        // Convert to lowercase (optional – makes it case insensitive)
        word = word.toLowerCase();

        Queue<Character> queue = new LinkedList<>();  // FIFO
        Stack<Character> stack = new Stack<>();       // LIFO

        // Step 1: Enqueue and Push characters
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            queue.add(ch);   // Enqueue
            stack.push(ch);  // Push
        }

        boolean isPalindrome = true;

        // Step 2: Compare dequeue and pop
        while (!queue.isEmpty()) {

            char fromQueue = queue.remove();  // Dequeue
            char fromStack = stack.pop();     // Pop

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        // Step 3: Display result
        if (isPalindrome) {
            System.out.println(word + " is a Palindrome.");
        } else {
            System.out.println(word + " is NOT a Palindrome.");
        }

        sc.close();
    }
}
