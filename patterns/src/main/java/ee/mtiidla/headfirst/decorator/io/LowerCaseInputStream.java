package ee.mtiidla.headfirst.decorator.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class LowerCaseInputStream extends FilterInputStream {

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int character = super.read();
        return character == -1 ? character : Character.toLowerCase(character);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result = super.read(b, off, len);
        for (int i = 0; i < off + result; i++) {
            b[i] = (byte) Character.toLowerCase(b[i]);
        }
        return result;
    }
}
