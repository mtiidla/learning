package ee.mtiidla.headfirst.mvc;

import javax.swing.JProgressBar;

class BeatBar extends JProgressBar implements Runnable {

    public BeatBar() {
        Thread thread = new Thread(this);
        setMaximum(100);
        thread.start();
    }

    public void run() {
        while (true) {
            int value = getValue();
            value = (int)(value * .75);
            setValue(value);
            repaint();
            try {
                Thread.sleep(50);
            } catch (Exception e) {};
        }
    }
}
