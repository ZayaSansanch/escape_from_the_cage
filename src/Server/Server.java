package Server;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Server {
    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9876;
    ServerSocket ss;
    Socket s;
    DataInputStream dis;
    DataOutputStream dis2;
    File img1;
    Timer timer;
//    public int int_read() {
//        try {
//            return dis.readInt();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public String string_read() {
        try {
            return dis.readUTF();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Server() {
        img1 = new File("src/Server/date/1.png");
        byte[] byte_array = new byte[(int) img1.length()];
        System.out.println("SERVER: started");

        try {
            ss = new ServerSocket(6666);
            while (true) {
                s = ss.accept();
                dis = new DataInputStream(s.getInputStream());
                dis2 = new DataOutputStream(s.getOutputStream());

                String get = string_read();
                System.out.println("GOT: " + get);

                if (Objects.equals(get.substring(0, 3), "ned")) {
                    if (Objects.equals(get.substring(4), "img1")) {
                        dis2.writeInt((int) img1.length());
                        dis2.write(byte_array, 0, byte_array.length);
                        System.out.println("SERVER: sent img 1 (grass)");
                    }
                }
            }
        } catch (Exception e) {
//            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
