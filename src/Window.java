import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private final JButton onOff;
    private final JButton increase;
    private final JButton decrease;
    private final JFormattedTextField text;

    public Window() {
        setLayout(new FlowLayout()); // Setting position of buttons in window (flow - in one row)
        onOff = new JButton("On/Off"); // Adding buttons to the window
        increase = new JButton("+");
        decrease = new JButton("-");
        add(onOff);
        add(increase);
        add(decrease);
        text = new JFormattedTextField();
        text.setEditable(true);
        text.setValue(Metronome.bpm);
        add(text);

        ToggleHandler handler = new ToggleHandler();
        onOff.addActionListener(handler);

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

    private static class DecreaseBpm implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Metronome.bpm--;
        }
    }
}

