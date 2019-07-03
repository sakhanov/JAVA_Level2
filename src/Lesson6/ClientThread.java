package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.rmi.server.ExportException;
import java.util.Scanner;

public class ClientThread extends Thread {
    Scanner sc;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    public ClientThread(Scanner sc, Socket socket, DataInputStream in, DataOutputStream out) {
        this.sc = sc;
        this.socket = socket;
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        //super.run();
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(;;){
                        String str ="";
                        try {
                            str = in.readUTF();
                        }catch (Exception e){
                           e.printStackTrace();
                            continue;
                        }
                        if(str.equals("/end")){
                            System.out.println("Клиент отключился");
                            break;
                        }
                        System.out.println(str);
                    }

                }
            }).start();
        }catch (Exception e){
            e.printStackTrace();;
        }

    }
}
