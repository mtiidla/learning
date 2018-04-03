package ee.mtiidla.cci.stack;

import java.util.EmptyStackException;

public class StackMin {

    // 3.2 How would you design a stack which, in addition to push and pop, has a function min
    // which returns the minimum element? Push, pop and min should all operate in O(1) time.

    //Hints #27, #59, #79

    public static class MyMinStack<T extends Comparable<T>> {

        private static class Node<T> {

            private T min;
            private T data;
            private Node<T> next;

            private Node(T data) {
                this.data = data;
            }

        }

        private Node<T> top;

        public void push(T data) {
            Node<T> node = new Node<>(data);
            if (top == null || node.data.compareTo(top.min) < 0) {
                node.min = node.data;
            } else {
                node.min = top.min;
            }
            node.next = top;
            top = node;

        }

        public T min() {
            return top != null ? top.min : null;
        }

        public T pop() {
            T data = null;
            if (top != null) {
                data = top.data;
                top = top.next;
            }
            return data;
        }

        public T peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            } else {
                return top.data;
            }
        }

        public boolean isEmpty() {
            return top == null;
        }

    }

    // Another solution that uses less space is to use 2 stacks,
    // the second stack is only for keeping min values.

}
