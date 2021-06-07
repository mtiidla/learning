package ee.mtiidla.headfirst.adapter;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

class IteratorAdapterTest {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Enumeration<Integer> enumeration = new IteratorAdapter<>(integers.iterator());
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

//        @SuppressWarnings("unchecked")
//        Iterator<String> iterator = new EnumerationAdapter<>();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }

}
