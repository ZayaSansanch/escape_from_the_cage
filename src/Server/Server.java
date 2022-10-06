package Server;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9876;
    ServerSocket ss;
    Socket s;
    DataInputStream dis;
    DataOutputStream dout;
    File img1;
    Timer timer;
    int connection = 0;

    private void string_write(String string) {
        try {
            dout.writeUTF(string);
            dout.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String string_read() {
        try {
            return dis.readUTF();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void send_tile_location(int T, int X, int Y, int Z) {
        String will_be_send = "T: " + T + ", X: " + X + ", Y: " + Y + ", Z: " + Z;
        string_write(will_be_send);
        System.out.println("SERVER: to " + this.connection + " user, send - " + will_be_send);
    }
    public Server() {
        try {
            ss = new ServerSocket(6666);

            while (true) {
                if (connection > 0) {
                    System.out.println();
                } connection++;

                s = ss.accept();
                dis = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());
//                System.out.println("SERVER: connected new user");

                send_tile_location(1, 0, 0, 0);
                send_tile_location(1, 1, 0, 0);
                send_tile_location(1, 0, 1, 0);
                send_tile_location(1, 1, 1, 0);
            }
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        new Server();
    }
}
