package ee.mtiidla.cci.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    // 1.2 Given two strings, write a method to decide if one is a permutation of the other.
    // Hints #1, #84, #122, #131

    public boolean bruteForce(String first, String second) {

        if (first.length() != second.length()) {
            return false;
        }

        return sort(first).equals(sort(second));
    }

    private static String sort(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public boolean myBestGuess(String first, String second) {

        if (first.length() != second.length()) {
            return false;
        }

        char[] charSet = new char[128];

        for (int i = 0; i < first.length(); i++) {
            charSet[first.charAt(i)]++;
        }

        for (int i = 0; i < second.length(); i++) {
            char charAt = second.charAt(i);
            int count = charSet[charAt];
            if (count == 0) {
                return false;
            }
            charSet[charAt]--;
        }

        return true;
    }

    public boolean myBestGuessMap(String first, String second) {

        String longer = first.length() > second.length() ? first : second;
        String shorter = first == longer ? second : first;

        Map<Character, Integer> charMap = new HashMap<>(longer.length());
        for (int i = 0; i < longer.length(); i++) {
            char character = longer.charAt(i);
            Integer count = charMap.get(character);
            if (count == null) {
                charMap.put(character, 1);
            } else {
                charMap.put(character, count + 1);
            }
        }
        for (int i = 0; i < shorter.length(); i++) {
            char character = shorter.charAt(i);
            Integer count = charMap.get(character);
            if (count == null || count == 0) {
                return false;
            } else {
                charMap.put(character, count - 1);
            }
        }
        return true;
    }

}
