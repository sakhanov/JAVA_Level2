package Lesson6;

import java.net.Socket;



public class client {
    //Socket static socket

    public  static void main(String[] args){
        ClientApi client = new ClientApi();
        client.run();
        System.out.println("Клиент запущен");
    }
}
