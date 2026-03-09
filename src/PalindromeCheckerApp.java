import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();

        System.out.println("Choose strategy: 1 = Stack, 2 = Deque");
        int choice = scanner.nextInt();

        PalindromeStrategy strategy;
        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }

        boolean result = strategy.checkPalindrome(input);
        System.out.println("Is Palindrome? : " + result);
    }
}
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }
        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) {
            deque.add(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}