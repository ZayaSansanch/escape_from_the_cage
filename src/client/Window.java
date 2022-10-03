package client;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Window extends JPanel {
    Socket socket;
    DataOutputStream dout;
    DataInputStream dis;
    private void write_string(String string) {
        try {
            dout.writeUTF(string);
            dout.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Window() {
        try{
            socket = new Socket("localhost",6666);
            dout = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println(e);
        }
        write_string("ned img1");
        try {
            while (true) {
//                System.out.println(dis.readUTF());
                System.out.println(dis.read());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
