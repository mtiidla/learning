package ee.mtiidla.headfirst.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * The Proxy Pattern provides a surrogate or placeholder for another object to control access to it.
 *
 * A Remote Proxy manages interaction between a client and a remote object.
 *
 * A Virtual Proxy controls access to an object that is expensive to instantiate.
 *
 * A Protection Proxy control access to the methods of an object based on the caller.
 *
 */
class MatchMakingTest {

    public static void main(String[] args) {

        Person person = new PersonImpl("Joe", "male");
        person.setHotOrNotRating(7);

        Person ownerProxy = getOwnerProxy(person);
        ownerProxy.setInterests("bowling, go");
        System.out.println(person);
        System.out.println("Interests set from owner proxy");
        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating());


        Person nonOwnerProxy = getNonOwnerProxy(person);
        System.out.println(person);
        try {
            nonOwnerProxy.setInterests("bowling, go");
        } catch (Exception e) {
            System.out.println("Can't set interests from non owner proxy");
        }
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println(person);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());


    }

    private static Person getOwnerProxy(Person person) {
        return getProxy(person, new OwnerInvocationHandler(person));
    }

    private static Person getNonOwnerProxy(Person person) {
        return getProxy(person, new NonOwnerInvocationHandler(person));
    }

    private static Person getProxy(Person person, InvocationHandler invocationHandler) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                invocationHandler
        );
    }

}
