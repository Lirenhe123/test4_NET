package priv.lirenhe.tcp.chat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket client=new Socket("localhost",10086);
		
		Send sender=new Send(client);
		new Thread(sender).start();
		
		Receive receiver=new Receive(client);
		new Thread(receiver).start();
//		System.out.println("接收到的数据是："+receiver.getReceiveData());
		
	}

}
