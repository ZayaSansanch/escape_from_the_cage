package client;

import javax.swing.*;
import java.io.IOException;

public class Main extends JFrame {
    JFrame window;
    Window Window;

    public Main() {
//        window = new JFrame();
//        window.setTitle("escape_from_the_cage");
//        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        window.setBounds(0, 0, 1280, 720);
        Window = new Window();
//        window.add(Window);
//        window.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
