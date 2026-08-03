package ProgramSoloUpInGit;

public class ReverseString {

    // Recursive Algorithm
    static String reverseRecursive(String s) {
        if (s.length() <= 1)
            return s;

        return s.charAt(s.length() - 1)
                + reverseRecursive(s.substring(0, s.length() - 1));
    }

    // Iterative Algorithm
    static String reverseIterative(String s) {
        String result = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {

        String input = "pots&pans";

        System.out.println("Input : " + input);

        System.out.println("Recursive : "
                + reverseRecursive(input));

        System.out.println("Iterative : "
                + reverseIterative(input));
    }

}