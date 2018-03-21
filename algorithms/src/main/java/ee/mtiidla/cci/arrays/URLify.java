package ee.mtiidla.cci.arrays;

public class URLify {

    // 1.3 Write a method to replace all spaces in a string with "%20". You may assume that the
    // string has sufficient space at the end to hold the additional characters, and that you are
    // given the "true" length of the string. (Note: if implementing in Java, please use a
    // character array so that you can perform this operation in place.)

    // EXAMPLE
    // Input: "Mr John Smith    ", true length 13
    // Output: "Mr%20John%20Smith"

    // Hints #53, #118

    public char[] bruteForce(char[] input, int length) {

        int i = 0;
        while (i < input.length) {
            if (input[i] == ' ') {
                for (int j = input.length - 1; j > i + 2; j--) {
                    input[j] = input[j - 2];
                }
                input[i] = '%';
                input[i + 1] = '2';
                input[i + 2] = '0';
                i+=2;
            } else {
                i++;
            }
        }

        return input;
    }

    public char[] myBestGuess(char[] input, int length) {

        int noOfSpaces = (input.length - length) / 2;

        for (int i = length - 1; i >= 0; i--) {
            if (input[i] != ' ') {
                input[i + noOfSpaces * 2] = input[i];
            } else {
                noOfSpaces--;
                int index = i + noOfSpaces * 2;
                input[index] = '%';
                input[index + 1] = '2';
                input[index + 2] = '0';
            }
        }

        return input;
    }

    public char[] solution(char[] input, int length) {
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (input[i] == ' ') {
                spaceCount++;
            }
        }
        int index = length + spaceCount * 2;
        if (length < input.length) {
            input[length] = '\0';
        }

        for (int i = length - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                input[index - 1] = '0';
                input[index - 2] = '2';
                input[index - 3] = '%';
                index = index - 3;
            } else {
                input[index - 1] = input[i];
                index--;
            }
        }
        return input;
    }

}
