package ee.mtiidla.cci.arrays;

public class BinarySearch {

    public int recursive(int[] array, int value) {
        return recursive(array, 0, array.length - 1, value);
    }

    private int recursive(int[] array, int start, int end, int value) {

        if (start > end) {
            return -1;
        }

        int middle = (start + end) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (value < array[middle]) {
            return recursive(array, start, middle - 1, value);
        } else {
            return recursive(array, middle + 1, end, value);
        }
    }

    public int iterative(int[] array, int value) {

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {

            int middle = (start + end) / 2;

            if (array[middle] == value) {
                return middle;
            } else if (value < array[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }

        }

        return -1;
    }

}
