package ee.mtiidla.cci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ee.mtiidla.cci.arrays.CheckPermutation;
import ee.mtiidla.cci.arrays.IsUnique;
import ee.mtiidla.cci.arrays.OneAway;
import ee.mtiidla.cci.arrays.StringCompression;
import ee.mtiidla.cci.arrays.URLify;
import ee.mtiidla.cci.stack.QueueWithStacks.MyQueueBruteForce;
import ee.mtiidla.cci.stack.StackMin;
import ee.mtiidla.interview.InterviewFB;

class CrackingCodingInterviewMain {

    public static void main(String... args) {

//        int[] input = new int[]{8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
////        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//
//        BinarySearchTree tree = new BinarySearchTree();
//        BinarySearchTree.Node root = null;
//        for (int value : input) {
//            root = tree.insert(root, value);
//        }
////        BinarySearchTree.Node root = tree.fromSortedArray(input);
//        TreePrinter.print(root);
//        System.out.println("PRE: " + tree.preOrderTraversal(root));
//        System.out.println("IN: " + tree.inOrderTraversal(root));
//        System.out.println("POST: " + tree.postOrderTraversal(root));
//
//        TreePrinter.print(root);

        InterviewFB interview = new InterviewFB();
        String[] inputs = new String[]{"nan", "aaba", "aabca", "abbb", "bbba", "", "ab", "abecbea"};
        for (String input : inputs) {
            System.out.println(input + " - " + interview.myBestGuess(input));
        }
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

    public static void QueueWithStacks() {

        MyQueueBruteForce<Integer> queue = new MyQueueBruteForce<>();
        int[] elements = new int[]{1, 2, 3, 4, 5};
        for (int element : elements) {
            queue.push(element);
        }
        System.out.println("Peek: " + queue.peek());
        while (!queue.isEmpty()) {
            System.out.println("Poll: " + queue.poll());
        }

    }

    public static void StackMin() {
        StackMin.MyMinStack<Integer> myMinStack = new StackMin.MyMinStack<>();
        System.out.println(myMinStack.min());
        int[] input = new int[]{5, 3, 4, -2, 1, 0, -1};
        for (int i : input) {
            myMinStack.push(i);
            System.out.println(myMinStack.min());
        }
    }

    private static class Pair<T, U> {
        private T key;
        private U value;

        public Pair(T key, U value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public U getValue() {
            return value;
        }
    }
}
