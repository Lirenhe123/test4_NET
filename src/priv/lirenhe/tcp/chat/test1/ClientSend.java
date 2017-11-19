package priv.lirenhe.tcp.chat.test1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSend extends Thread {  
    private Scanner scanner;  
    private Socket socket;  
  
    public ClientSend(Socket socket) {  
        this.socket = socket;  
    }  
  
    @Override  
    public void run() {  
        scanner = new Scanner(System.in);  
  
        try {  
            PrintStream ps = new PrintStream(socket.getOutputStream());  
            String line = "";  
            // ����ʽ������Ϣ  
            while ((line = scanner.nextLine()) != null) {  
                ps.println(line);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
}  
