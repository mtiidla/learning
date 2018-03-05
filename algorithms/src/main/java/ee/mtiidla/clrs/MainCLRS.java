package ee.mtiidla.clrs;

import java.util.Arrays;

public class MainCLRS {

    public static void main(String... args) {

        int[] input = {5, 4, 3, 2, 1};
        new InsertionSort().sort(input);

        print(Arrays.toString(input));

        int[] input2 = {2, 4, 5, 7, 1, 2, 3, 6};
        new MergeSort().sort(input2, 0, 7);
        println(input2);
    }

    public static void print(Object input) {
        System.out.print(input);
    }

    public static <T> void println(T[] input) {
        System.out.println(Arrays.toString(input));
    }

    public static <T> void println(int[] input) {
        System.out.println(Arrays.toString(input));
    }

}
