package ee.mtiidla.cci.stack;

import java.util.EmptyStackException;

public class HandWrittenStack<E> {

    private static class Node<E> {

        private E data;

        private Node<E> next;

        private Node(E data) {
            this.data = data;
        }
    }

    private Node<E> top;

    public void push(E data){
        Node<E> node = new Node<>(data);
        node.next = top;
        top = node;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            E data = top.data;
            top = top.next;
            return data;
        }
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }


}
