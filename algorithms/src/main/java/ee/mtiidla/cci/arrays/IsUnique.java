package ee.mtiidla.cci.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsUnique {

    //1.1 Implement an algorithm to determine if a string has all unique characters. What if you
    // cannot use additional data structures?
    // Hints #44, #117, #132

    public boolean myBruteForce(String input) {

        Object dummy = new Object();
        Map<Character, Object> characters = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (characters.containsKey(c)) {
                return false;
            }
            characters.put(c, dummy);
        }

        return true;

    }

    public boolean myBestGuess(String input) {

        for (int i = 0; i < input.length(); i++) {
            if (input.indexOf(input.charAt(i), i + 1) != -1) {
                return false;
            }
        }
        return true;

    }

    public boolean solution_nLogN(String input) {

        char[] chars = input.toCharArray();
        Arrays.sort(chars);

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public boolean solutionAscii(String input) {

        if (input.length() > 128) return false;

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < input.length(); i++) {
            int character = input.charAt(i);
            if (charSet[character]) {
                return false;
            }
            charSet[character] = true;
        }

        return true;
    }

    // assumes only characters from a through Z
    public boolean solutionBitVector(String input) {
        int checker = 0;
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i) - 'a';
            if ((checker & (i << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

}
