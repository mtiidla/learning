package ee.mtiidla.cci;

import java.util.Arrays;

class CrackingCodingInterviewMain {

    public static void main(String... args) {

        BigO bigO = new BigO();

        System.out.println(bigO.fibonacci(2));
        int[] memo = new int[21];
        System.out.println(bigO.fibonacciMemo(20, memo));
        System.out.println(Arrays.toString(memo));
        System.out.println(bigO.fibonacciIterative(20));
    }

}
