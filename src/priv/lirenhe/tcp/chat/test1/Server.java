package priv.lirenhe.tcp.chat.test1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {  
	public static void main(String[] args) throws IOException {
		List<Socket> list=new ArrayList<>();
		ServerSocket server=new ServerSocket(10000);
		while(true){
			Socket socket = server.accept();
			synchronized (list) {  
                list.add(socket);  
            }
			new HandleSocket(socket,list).start();
			
		}
		
	}
   /* public static void main(String[] args) throws IOException,  
            InterruptedException {  
        List<Socket> list = new ArrayList<>();  
  
        // 创建服务器端的套接字  
        ServerSocket server = new ServerSocket(10000);  
  
        while(true){  
            // 接收客户端的阻塞方法  
            Socket socket = server.accept();  
            // 设计到多个线程可能会对集合进行增删的操作，要进行同步的处理  
            synchronized (list) {  
                list.add(socket);  
            }  
            // 启动一个新的线程去处理这个客户端的交流  
            new HandleSocket(socket,list).start();
        }  
　　　　 // 因为不知道客户端什么时候发送信息，所以服务端要一直开启不能关闭。  
    }  */
}  
