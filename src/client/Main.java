package client;

import javax.swing.*;

public class Main extends JFrame {
    JFrame window;
    client.Window Window;

    public Main() {
        window = new JFrame();
        window.setTitle("escape_from_the_cage");
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setBounds(0, 0, 1280, 720);
        Window = new Window();
        window.add(Window);
        window.setVisible(true);

        Timer timer;
        timer = new Timer(0, e -> {
            window.revalidate();
            window.repaint();
        });
        timer.setRepeats(true);
        // Aprox. 60 FPS
        timer.setDelay(17);
        timer.start();
    }

    public static void main(String[] args) {
        new Main();
    }
}
