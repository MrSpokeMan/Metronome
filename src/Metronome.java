import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Metronome extends Thread {
    private AtomicBoolean keepRunning;
    static double bpm = 100;

    public Metronome() {
        keepRunning = new AtomicBoolean(true);
    }

    public void end() {
        keepRunning.set(false);
    }

    @Override
    public void run() {
        while (keepRunning.get()) {
            try {
                Thread.sleep((long)(1000*(60.0/bpm)));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
