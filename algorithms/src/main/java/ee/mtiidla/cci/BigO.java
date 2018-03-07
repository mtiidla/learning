package ee.mtiidla.cci;

class BigO {

    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int fibonacciMemo(int n, int[] memo) {

        if (n <= 1) {
            memo[n] = n;
        } else if (memo[n] == 0){
            memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
        }
        return memo[n];
    }

    public int fibonacciIterative(int n) {
        if (n <= 1) {
            return 1;
        }
        int previous = 1;
        int result = 1;
        for (int i = 2; i < n; i++) {
            int temp = result;
            result = previous + result;
            previous = temp;
        }
        return result;
    }

}
