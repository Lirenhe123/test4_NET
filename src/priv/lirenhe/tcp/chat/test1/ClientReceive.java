package priv.lirenhe.tcp.chat.test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceive extends Thread {  
    private Socket socket;  
  
    public ClientReceive(Socket socket) {  
        this.socket = socket;  
    }  
  
    @Override  
    public void run() {  
        try {  
            BufferedReader br = new BufferedReader(new InputStreamReader(  
                    socket.getInputStream()));  
            // 按行接收信息  
            String line = "";  
            while ((line = br.readLine()) != null) {  
                System.out.println(line);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
}  

