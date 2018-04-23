package ee.mtiidla.headfirst.adapter;

import java.util.Enumeration;
import java.util.Iterator;

class IteratorAdapter<E> implements Enumeration<E> {

    private final Iterator<E> iterator;

    IteratorAdapter(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public E nextElement() {
        return iterator.next();
    }
}
