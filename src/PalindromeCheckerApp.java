import java.util.*;

class UseCase5PalindromeCheckerApp {

    void uc5check(String word) {

        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindrome = true;

        for (char c : word.toCharArray()) {
            if (stack.pop() != c) {
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

        UseCase5PalindromeCheckerApp uc5 =
                new UseCase5PalindromeCheckerApp();

        uc5.uc5check(wrd);
    }
}

