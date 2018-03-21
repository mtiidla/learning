package ee.mtiidla.cci.arrays;

public class OneAway {

    // 1.5 There are three types of edits that can be performed on strings: insert a character,
    // remove a character, or replace a character. Given two strings, write a function to check
    // if they are one edit (or zero edits) away.

    // EXAMPLE
    // pale, ple   -> true
    // pales, pale -> true
    // pale, bale  -> true
    // pale, bae   -> false

    public boolean bruteForce(String first, String second) {

        // substring without one character and check equals

        throw new UnsupportedOperationException("Too terrible to bother");
    }

    public boolean solution(String first, String second) {

        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        String shorter = first.length() < second.length() ? first : second;
        String longer = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < longer.length() && index1 < shorter.length()) {
            if (shorter.charAt(index1) != longer.charAt(index2)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                if (shorter.length() == longer.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;

        }
        return true;
    }

}
