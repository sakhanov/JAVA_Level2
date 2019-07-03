package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientApi {
    final static String host ="localhost";
    final static  int port = 8189;
    Scanner sc;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    ClientThread streamOut;
    ReadThread streamInput;
    public ClientApi() {
        try {
            socket = new Socket(host, port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            out.writeUTF("Привет");
            out.flush();
            out.f
        }catch (Exception e){
            e.printStackTrace();
        }

        streamOut = new ClientThread(sc, socket, in, out);
        streamInput = new ReadThread(sc, socket, in, out);

        try  {
            this.sc = new Scanner(System.in);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public Scanner getSc() {
        return sc;
    }

    public Socket getSocket() {
        return socket;
    }

    public DataInputStream getIn() {
        return in;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void run(){
        // чтение сервера
        try {
            out.writeUTF("Привет");
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }

        //streamOut.start();
        streamInput.start();


    }
}
