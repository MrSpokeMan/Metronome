import javax.swing.*;

public class mainWindow {
    public static void main(String[] args) {
        Window gui = new Window();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting default way of closing window
        gui.setSize(300,200); // Setting size of window
        gui.setLocation(400,300); // Starting point of window
        gui.setTitle("Metronome App"); // Name of window
        gui.setVisible(true); // Setting visability of window
    }
}
