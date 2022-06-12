import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private final JButton onOff;
    private final JButton increase;
    private final JButton decrease;
    private final JButton increase5;
    private final JButton decrease5;
    private final JFormattedTextField text;

    public Window() {
        setLayout(new FlowLayout()); // Setting position of buttons in window (flow - in one row)
        onOff = new JButton("On/Off"); // Adding buttons to the window
        increase = new JButton("+");
        decrease = new JButton("-");
        increase5 = new JButton("+ 5");
        decrease5 = new JButton("- 5");
        add(onOff);
        add(increase5);
        add(increase);
        add(decrease);
        add(decrease5);
        text = new JFormattedTextField();
        text.setEditable(true);
        text.setValue(Metronome.bpm);
        add(text);

        ToggleHandler handler = new ToggleHandler();
        onOff.addActionListener(handler);

        Increase5Bpm plus5Handle = new Increase5Bpm();
        increase5.addActionListener(plus5Handle);

        Decrease5Bpm minus5Handle = new Decrease5Bpm();
        decrease5.addActionListener(minus5Handle);

        IncreaseBpm plusHandle = new IncreaseBpm();
        increase.addActionListener(plusHandle);

        DecreaseBpm minusHandle = new DecreaseBpm();
        decrease.addActionListener(minusHandle);
    }

    private class ToggleHandler implements ActionListener {
        private Metronome metro;

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if(e.getSource() == onOff) {
                if (metro == null) {
                    metro = new Metronome();
                    Thread t = new Thread(metro);
                    t.start();
                } else {
                    metro.end();
                    metro = null;
                }
            }
        }
    }

    private static class IncreaseBpm implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Metronome.bpm++;
        }
    }

    private static class Increase5Bpm implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Metronome.bpm += 5;
        }
    }

    private static class DecreaseBpm implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Metronome.bpm--;
        }
    }

    private static class Decrease5Bpm implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Metronome.bpm-=5;
        }
    }
}

