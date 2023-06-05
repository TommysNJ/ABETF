import javax.swing.*;

public class
Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Programa();
                frame.setSize(1000, 750);
                frame.setVisible(true);
            }
        });
    }
}
