package ProgramSoloUpInGit;

public class VowelConsonant {

    static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }

    // Recursive
    static boolean hasMoreVowelsRecursive(String s) {
        return helper(s.toLowerCase(), 0, 0, 0);
    }

    static boolean helper(String s, int index, int vowels, int consonants) {

        if (index == s.length())
            return vowels > consonants;

        char ch = s.charAt(index);

        if (Character.isLetter(ch)) {
            if (isVowel(ch))
                vowels++;
            else
                consonants++;
        }

        return helper(s, index + 1, vowels, consonants);
    }

    // Iterative
    static boolean hasMoreVowelsIterative(String s) {

        int vowels = 0;
        int consonants = 0;

        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isLetter(ch)) {

                if (isVowel(ch))
                    vowels++;
                else
                    consonants++;
            }
        }

        return vowels > consonants;
    }

    public static void main(String[] args) {

        String input = "education";

        System.out.println(hasMoreVowelsRecursive(input));
        System.out.println(hasMoreVowelsIterative(input));
    }
}