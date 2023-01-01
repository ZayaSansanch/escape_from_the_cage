package client;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

public class Window extends JPanel {
    Socket socket;
    DataOutputStream dout;
    DataInputStream dis;
    BufferedImage img1;
    URL url_img1;
    private void string_write(String string) {
        try {
            dout.writeUTF(string);
            dout.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Window() {
        try{
//            socket = new Socket("159.223.209.4", 6666);
            socket = new Socket("localhost", 6666);
            dout = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println("Error with connect: " + e);
        }
        
        try {
            url_img1 = new URL("https://cageescape.lovie.dev/game-resources/img1.png");
            img1 = ImageIO.read(url_img1);
        } catch (IOException e) {
            throw new RuntimeException("Error with get image from url: " + e);
        }

        for (int i = 0; i < 4; i++) {
            String get = string_read();
            int T, X, Y, Z;
            System.out.println("Got: T: " + get.charAt(3) + ", X: " + get.charAt(9) + ", Y: " + get.charAt(15) + ", Z: " + get.charAt(21));
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img1, 0, 0 ,128, 128, this);
    }
    public String string_read() {
        try {
            return dis.readUTF();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Json {
    private URL url_date;
    public Json() {
        JSONObject jsonO = new JSONObject();
//        JSONObject json1 = new JSONObject();
        JSONParser parser = new JSONParser();

        try {
            url_date = new URL("https://cageescape.lovie.dev/game-resources/date.png");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}