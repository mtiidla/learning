package ee.mtiidla.clrs;

class InsertionSort {

    // O(n2)
    public void sort(int[] input) {

        for (int j = 1; j < input.length; j++) {
            int key = input[j];
            int i = j - 1;
            while (i >= 0 && input[i] > key) {
                input[i + 1] = input[i];
                i = i - 1;
            }
            input[i + 1] = key;
        }

    }

}
