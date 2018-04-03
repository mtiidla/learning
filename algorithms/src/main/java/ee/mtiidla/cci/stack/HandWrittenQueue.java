package ee.mtiidla.cci.stack;

import java.util.EmptyStackException;

public class HandWrittenQueue<E> {

    private static class Node<E> {

        private E item;
        private Node<E> next;

        private Node(E item) {
            this.item = item;
        }
    }

    private Node<E> first;
    private Node<E> last;

    public void add(E item) {
        Node<E> node = new Node<>(item);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {
            first = last;
        }
    }

    public E remove() {
        if (first == null) {
            throw new EmptyStackException();
        }
        E item = first.item;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return item;
    }

    public E peek() {
        if (first == null) {
            throw new EmptyStackException();
        }
        return first.item;
    }

    public boolean isEmpty() {
        return first == null;
    }

}
