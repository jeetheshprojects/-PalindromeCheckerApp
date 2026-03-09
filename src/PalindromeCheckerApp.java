import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayDeque;
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        PalindromeStrategy stackStrategy = new StackStrategy();
        long startStack = System.nanoTime();
        boolean stackResult = stackStrategy.checkPalindrome(normalized);
        long endStack = System.nanoTime();
        long stackTime = endStack - startStack;
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        long startDeque = System.nanoTime();
        boolean dequeResult = dequeStrategy.checkPalindrome(normalized);
        long endDeque = System.nanoTime();
        long dequeTime = endDeque - startDeque;
        System.out.println("Input : " + input);
        System.out.println("StackStrategy -> Is Palindrome? : " + stackResult + " | Execution Time : " + stackTime + " ns");
        System.out.println("DequeStrategy -> Is Palindrome? : " + dequeResult + " | Execution Time : " + dequeTime + " ns");

        scanner.close();
    }
}

interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
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
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean checkPalindrome(String input) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
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