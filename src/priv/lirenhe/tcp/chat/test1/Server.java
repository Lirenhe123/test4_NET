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
  
        // �����������˵��׽���  
        ServerSocket server = new ServerSocket(10000);  
  
        while(true){  
            // ���տͻ��˵���������  
            Socket socket = server.accept();  
            // ��Ƶ�����߳̿��ܻ�Լ��Ͻ�����ɾ�Ĳ�����Ҫ����ͬ���Ĵ���  
            synchronized (list) {  
                list.add(socket);  
            }  
            // ����һ���µ��߳�ȥ��������ͻ��˵Ľ���  
            new HandleSocket(socket,list).start();
        }  
�������� // ��Ϊ��֪���ͻ���ʲôʱ������Ϣ�����Է����Ҫһֱ�������ܹرա�  
    }  */
}  
