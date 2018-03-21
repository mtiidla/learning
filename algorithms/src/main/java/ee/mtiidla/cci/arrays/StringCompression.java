package ee.mtiidla.cci.arrays;

public class StringCompression {

    // 1.6 Implement a method to perform basic string compression using the counts of repeated
    // characters. For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed"
    // string would not become smaller than the original string, your method should return the
    // original string. You can assume the string has only uppercase and lowercase letters {a-z}

    // Hints #92, #110

    public String bruteForce(String input) {

        StringBuilder output = new StringBuilder();

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count++;

            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                output.append(input.charAt(i)).append(count);
                count = 0;
            }
        }

        return output.length() < input.length() ? output.toString() : input;

    }

    public String myBestGuess(String input) {
        return bruteForce(input);
    }

    public String solution(String input) {
        int countCompressed = countCompressed(input);
        if (countCompressed >= input.length()) {
            return input;
        }

        StringBuilder output = new StringBuilder(countCompressed);

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count++;

            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                output.append(input.charAt(i)).append(count);
                count = 0;
            }
        }
        return output.toString();
    }

    private int countCompressed(String input) {
        int compressedLength = 0;
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count++;

            if (i + 1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(count).length();
                count = 0;
            }
        }
        return compressedLength;
    }

}
