package ee.mtiidla.interview;

public class InterviewFB {

    // Remove a character from a string to make it a palindrome.
    // Given a string, we need to check whether it is possible to make this string a palindrome
    // after removing exactly one character from this.

//    isAlmostPalindrome(“nan”); // → true
//    isAlmostPalindrome(“aaba”); // → true
//    isAlmostPalindrome(“aabca”); // → false
//    isAlmostPalindrome(“abbb”); // → true
//    isAlmostPalindrome(“bbba”); // → true

    // O(n2) where n is length of the input string
    public boolean myBestGuess(String input) {

        boolean removedCharacter = false;
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                if (input.charAt(left + 1) == input.charAt(right)) {
                    if (removedCharacter) {
                        return false;
                    }
                    removedCharacter = true;
                    left++;
                    continue;
                }
                if (input.charAt(right - 1) == input.charAt(left)) {
                    if (removedCharacter) {
                        return false;
                    }
                    removedCharacter = true;
                    right--;
                    continue;
                }
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean bruteForce(String input) {
        if (isPalindrome(input)) {
            return true;
        }
        for (int i = 0; i < input.length(); i++) {
            String s = input.substring(0, i) + input.substring(i + 1, input.length());
            if (isPalindrome(s)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    //Solution
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeRange(s, i+1, j) ||
                        isPalindromeRange(s, i, j-1));
            }
        }
        return true;
    }

    private boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }

    // My interview answer, before time ran out
    public boolean isAlmostPalindrome(String input) {

        for (int i = 0; i < input.length() / 2; i++) {
            char begin = input.charAt(i); // a, b
            char end = input.charAt(input.length() - 1 - i); // b, b
            if (begin != end) {
                char nextBegin = input.charAt(i + 1);
                if (nextBegin != end) {
                    return false;
                }
                char prevEnd = input.charAt(input.length() - 2 - i);
                if (prevEnd != begin) {
                    return false;
                }

            }

        }

        return true;
    }

}
