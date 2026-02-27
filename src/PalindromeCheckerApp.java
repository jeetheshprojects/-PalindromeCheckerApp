import java.util.*;

class UseCase7PalindromeCheckerApp {

    void uc7check(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {
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

        UseCase7PalindromeCheckerApp uc7 =
                new UseCase7PalindromeCheckerApp();

        uc7.uc7check(wrd);
    }
}
