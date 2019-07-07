package Lesson6;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    static  int  port = 8189;
    public static void main(String[] args){
        ServerSocket server  = null;
        Socket socket = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Сервер запущен");

            socket = server.accept();
            Scanner sc = new Scanner(socket.getInputStream());
           // DataInputStream in;
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            for(;;){
                String s = sc.nextLine();
                if (s.equals("/end")){
                    System.out.println("Пока");
                    break;
                }
                System.out.println(s);
                out.println(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
