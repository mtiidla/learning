package ee.mtiidla.headfirst.adapter;

import java.util.Enumeration;
import java.util.Iterator;

class EnumerationAdapter<E> implements Iterator<E> {

    private final Enumeration<E> enumeration;

    EnumerationAdapter(Enumeration<E> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public E next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
