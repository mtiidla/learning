package ee.mtiidla.cci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ee.mtiidla.cci.arrays.CheckPermutation;
import ee.mtiidla.cci.arrays.IsUnique;
import ee.mtiidla.cci.arrays.OneAway;
import ee.mtiidla.cci.arrays.StringCompression;
import ee.mtiidla.cci.arrays.URLify;
import javafx.util.Pair;

class CrackingCodingInterviewMain {

    public static void main(String... args) {

        StringCompression();
    }

    private static void bigO() {
        BigO bigO = new BigO();

        System.out.println(bigO.fibonacci(2));
        int[] memo = new int[21];
        System.out.println(bigO.fibonacciMemo(20, memo));
        System.out.println(Arrays.toString(memo));
        System.out.println(bigO.fibonacciIterative(20));
    }

    public static void IsUnique() {

        IsUnique unique = new IsUnique();
        long start = System.nanoTime();
        String input = " !\"#$%&\\'()*+,-./0123456789:;"
                + "<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        System.out.println(unique.myBruteForce(input));
        System.out.println(unique.myBestGuess(input));
        System.out.println(unique.solution_nLogN(input));
        System.out.println(unique.solutionAscii(input));
        System.out.println(unique.solutionBitVector(input));

    }

    public static void CheckPermutation() {

        CheckPermutation permutation = new CheckPermutation();
        String second = "abcdefc";
        String first = "feabdcc";
        System.out.println(permutation.bruteForce(first, second));
        System.out.println(permutation.myBestGuess(first, second));

    }

    public static void URLify() {

        URLify urLify = new URLify();
        String src = "Mr John    Smith          ";
        char[] input = src.toCharArray();
        int length = src.trim().length();
//        System.out.println(new String(urLify.bruteForce(input, length)));
        System.out.println(new String(urLify.myBestGuess(input, length)));
//        System.out.println(new String(urLify.solution(input, length)));

    }

    public static void OneAway() {

        OneAway oneAway = new OneAway();
        List<Pair<String, String>> input = new ArrayList<>();
        input.add(new Pair<>("pale", "ple"));
        input.add(new Pair<>("pales", "pale"));
        input.add(new Pair<>("pale", "bale"));
        input.add(new Pair<>("pale", "bae"));
        for (Pair<String, String> pair : input) {
            System.out.println(pair + " -> " + oneAway.solution(pair.getKey(), pair.getValue()));
        }
    }

    public static void StringCompression() {

        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.bruteForce("aabcccccaaa"));
        System.out.println(stringCompression.bruteForce("abcccccccdef"));
        System.out.println(stringCompression.bruteForce("abccccccccdef"));
        System.out.println(stringCompression.solution("aabcccccaaa"));

    }


}
