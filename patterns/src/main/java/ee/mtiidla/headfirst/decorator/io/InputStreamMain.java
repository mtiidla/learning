package ee.mtiidla.headfirst.decorator.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

class InputStreamMain {

    public static void main(String[] args) {

        try {
            int c;
            ClassLoader classLoader = Hello.class.getClassLoader();
            InputStream resource = classLoader.getResourceAsStream("test.txt");
            InputStream stream = new LowerCaseInputStream(
                    new BufferedInputStream(resource));

            while ((c = stream.read()) >= 0) {
                System.out.print((char) c);
            }

            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static class Hello {

    }

}
