package ee.mtiidla.cci.stack;

import java.util.Stack;

public class QueueWithStacks {

    // 3.4 Implement a MyQueue class which implements a queue using two stacks.

    // Hints #15, #32, #43

    public static class MyQueueBruteForce<E> {

        private final Stack<E> stack;
        private final Stack<E> reverse;

        public MyQueueBruteForce() {
            stack = new Stack<>();
            reverse = new Stack<>();
        }

        public void push(E element) {
            stack.push(element);
        }

        public E peek() {
            while (!stack.isEmpty()) {
                reverse.push(stack.pop());
            }
            E result = reverse.peek();
            while (!reverse.isEmpty()) {
                stack.push(reverse.pop());
            }
            return result;
        }

        public E poll() {
            while (!stack.isEmpty()) {
                reverse.push(stack.pop());
            }
            E result = reverse.pop();
            while (!reverse.isEmpty()) {
                stack.push(reverse.pop());
            }
            return result;
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

    }

    public static class MyQueueSolution<E> {

        private final Stack<E> stack;
        private final Stack<E> reverse;

        public MyQueueSolution() {
            stack = new Stack<>();
            reverse = new Stack<>();
        }

        public void add(E element) {
            stack.push(element);
        }

        public E peek() {
            shiftStacks();
            return reverse.peek();
        }

        public E remove() {
            shiftStacks();
            return reverse.pop();
        }

        private void shiftStacks() {
            if (reverse.isEmpty()) {
                while (!stack.isEmpty()) {
                    reverse.push(stack.pop());
                }
            }
        }

        public boolean isEmpty() {
            return stack.isEmpty() && reverse.isEmpty();
        }

    }

}
