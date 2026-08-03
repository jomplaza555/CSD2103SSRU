package ProgramSoloUpInGit;

public class Palindrome {

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    static boolean isPalindromeByReverse(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return s.equals(reverse(s));
    }

    static boolean isPalindromeRecursive(String s, int left, int right) {
        if (left >= right)
            return true;

        if (s.charAt(left) != s.charAt(right))
            return false;

        return isPalindromeRecursive(s, left + 1, right - 1);
    }

    public static void main(String[] args) {

        String input = "A man, a plan, a canal: Panama";

        String clean = input.replaceAll("[^a-zA-Z0-9]", "")
                            .toLowerCase();

        System.out.println(isPalindromeByReverse(input));
        System.out.println(isPalindromeRecursive(clean, 0, clean.length() - 1));
    }
}