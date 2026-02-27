import java.util.*;

class UseCase6PalindromeCheckerApp {

    void uc6check(String input) {

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            char q = queue.remove();
            char s = stack.pop();

            if (q != s) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word: ");
        String wrd = sc.nextLine();

        UseCase6PalindromeCheckerApp uc6 =
                new UseCase6PalindromeCheckerApp();

        uc6.uc6check(wrd);
    }
}

