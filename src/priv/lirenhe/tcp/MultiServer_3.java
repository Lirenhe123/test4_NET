package priv.lirenhe.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer_3 {
	public static void main(String[] args) throws IOException {
		
		//���������� 
		ServerSocket serverSocket =new ServerSocket(10086); 
		Socket socket =null; 
		int count =0;//��¼�ͻ��˵����� 
		while(true){ 
			socket = serverSocket.accept(); //���ϵؼ�����ʹ��ѭ��
			ServerThread serverThread =new ServerThread(socket); //ÿ��socket����һ���������߳���
			serverThread.start(); 
			count++; 
			System.out.println("�ͻ������ӵ�������"+count); 
		} 
	}
}
class ServerThread extends Thread{
	//�������̴߳��� 
	//�ͱ��߳���ص�socket 
	Socket socket =null; 
	// 
	public ServerThread(Socket socket){ 
		this.socket = socket; 
	} 
	 
	public void run(){ 
	//������������� 
		System.out.println("ServerThread run()");
	} 
}