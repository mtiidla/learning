package ee.mtiidla.cci;

import java.util.Arrays;

import ee.mtiidla.cci.arrays.CheckPermutation;
import ee.mtiidla.cci.arrays.IsUnique;
import ee.mtiidla.cci.arrays.URLify;

class CrackingCodingInterviewMain {

    public static void main(String... args) {

        URLify();
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
        System.out.println(new String(urLify.bruteForce(input, length)));

    }

}
