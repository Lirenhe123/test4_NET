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
  
        // ����������Ϣ���߳�  
        new ClientSend(client).start();  
        // ����������Ϣ���߳�  
        new ClientReceive(client).start();
        System.out.println("adslflsdlf");
����������// ��ΪҪʵ�����칦�ܣ�������ֻ����һ����Ϣ������������Ϳͻ��˶����ܹرա�  
        // client.shutdownOutput();  
        // client.close();  
  
    }  */
} 
