package ee.mtiidla.clrs;

class MergeSort {

    void merge(int[] array, int start, int middle, int end) {

        int n1 = middle - start + 1;
        int n2 = end - middle;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            left[i] = array[start + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = array[middle + i + 1];
        }

        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = start; k <= end; k++) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
        }

    }

    // O(n log n)
    void sort(int[] A, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            sort(A, start , middle);
            sort(A, middle + 1, end);
            merge(A, start, middle, end);
        }
    }


}
