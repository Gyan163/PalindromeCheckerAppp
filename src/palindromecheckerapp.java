import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {

    // 1️⃣ Strategy Interface
    interface PalindromeStrategy {
        boolean check(String input);
    }

    // 2️⃣ Stack Strategy
    static class StackStrategy implements PalindromeStrategy {

        @Override
        public boolean check(String input) {

            Stack<Character> stack = new Stack<>();

            for (char c : input.toCharArray()) {
                stack.push(c);
            }

            for (char c : input.toCharArray()) {
                if (c != stack.pop()) {
                    return false;
                }
            }

            return true;
        }
    }

    // 3️⃣ Deque Strategy
    static class DequeStrategy implements PalindromeStrategy {

        @Override
        public boolean check(String input) {

            Deque<Character> deque = new ArrayDeque<>();

            for (char c : input.toCharArray()) {
                deque.addLast(c);
            }

            while (deque.size() > 1) {
                if (deque.removeFirst() != deque.removeLast()) {
                    return false;
                }
            }

            return true;
        }
    }

    // 4️⃣ Context Class
    static class PalindromeContext {

        private PalindromeStrategy strategy;

        public PalindromeContext(PalindromeStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean execute(String input) {
            return strategy.check(input);
        }
    }

    // 5️⃣ Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==== Palindrome Checker App ====");
        System.out.println("UC12: Strategy Pattern for Palindrome");
        System.out.println();

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Choose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        PalindromeStrategy strategy;

        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.execute(input);

        if (result) {
            System.out.println("Result: It is a Palindrome.");
        } else {
            System.out.println("Result: It is NOT a Palindrome.");
        }

        sc.close();
    }
}