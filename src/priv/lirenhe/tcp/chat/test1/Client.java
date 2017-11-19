package priv.lirenhe.tcp.chat.test1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket client=new Socket("localhost",10000);
		new ClientSend(client).start();
		new ClientReceive(client).start();
	}
    /*public static void main(String args[]) throws UnknownHostException,  
            IOException {  
        Socket client = new Socket("192.168.1.188", 10000);  
  
        // 穿件发送信息的线程  
        new ClientSend(client).start();  
        // 创建接收信息的线程  
        new ClientReceive(client).start();
        System.out.println("adslflsdlf");
　　　　　// 因为要实现聊天功能，而不是只发送一次信息，所以输出流和客户端都不能关闭。  
        // client.shutdownOutput();  
        // client.close();  
  
    }  */
} 
