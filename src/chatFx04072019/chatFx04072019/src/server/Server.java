package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;

public class Server {
    Vector <ClientHandler> clients;

    public Server() throws SQLException {
        AuthService.connect();
//        System.out.println(AuthService.getNickByLoginAndPass("login1","pass1"));

        ServerSocket server = null;
        Socket socket = null;

        try {
            clients = new Vector<>();
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");

            while(true){
                socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this,socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }
    public  void sendMessageToClient(String nick, String workStr ){
        String[] msg = workStr.split(" ");
        if(!msg[1].equals("/w")) return;
        for (ClientHandler o: clients) {
            if(o.getNick().equals(nick)) {
                o.sendMsg(workStr);
                return;
            }
            //o.sendMsg(workStr);
        }
        for (ClientHandler o: clients) {
            if(o.getNick().equals(msg[0].substring(0,msg[0].length() - 1))) {
                o.sendMsg("Клиент не в сети");
                return;
            }
            //o.sendMsg(workStr);
        }

    }
    public void broadcastMsg(String str){
        String[] msg = str.split(" ");
        if(msg[1].equals("/w")) {
            if (msg[2].equals(msg[0].substring(0,msg[0].length() - 1))){
                sendMessageToClient(msg[2], msg[2] + ": /w "+  msg[2] +" Нельзя посылать сообщение себе" );
            }else {
                sendMessageToClient(msg[2], str);
                sendMessageToClient(msg[0].substring(0, msg[0].length() - 1), str);
            }
            return;
        }

        for (ClientHandler o: clients) {
            o.sendMsg(str);
        }
    }

    public void subscribe(ClientHandler clientHandler){
        for (ClientHandler o: clients) {
            if ( o.getNick().equals(clientHandler.getNick())) {
                clientHandler.sendMsg("Клиент зарегистрирован");
                clientHandler.sendMsg("/end");
               // clientHandler.
                return;
            }

        }

        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }
}
