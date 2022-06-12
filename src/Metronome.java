import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;

public class Metronome extends Thread {
    private AtomicBoolean keepRunning;
    static double bpm = 60;

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
            Player player = new Player();
            Rhythm rhythm = new Rhythm();
            rhythm.addLayer("S");
            player.play(rhythm.getPattern());
        }
    }
}
