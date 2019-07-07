package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ReadThread extends Thread{
    Scanner sc;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    public ReadThread(Scanner sc, Socket socket, DataInputStream in, DataOutputStream out) {
        this.sc = sc;
        this.socket = socket;
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        //super.run();
        //        // чтение клавиатуры пользователя
        try{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("read");
                    for(;;) {
                        String loadStr = "";
                        try {
//                            try {
//                                out.writeUTF("tes111");
//                                out.flush();
//                            }catch (Exception e){
//                                e.printStackTrace();
//                            }

  //                          System.out.println("test");
                            loadStr= sc.nextLine();
                            System.out.println(loadStr);
                            if (loadStr.length() == 0) continue;
                        }catch (Exception e){
                           // e.printStackTrace();
                            continue;
                        }


                        if (loadStr.equals("/end")){
                            System.out.println("Пока");
                            System.exit(0);
                            break;
                        }
                        try {
                            out.writeUTF(loadStr);
                            out.flush();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
