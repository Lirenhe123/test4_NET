package priv.lirenhe.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiServer_3 {
	public static void main(String[] args) throws IOException {
		
		//服务器代码 
		ServerSocket serverSocket =new ServerSocket(10086); 
		Socket socket =null; 
		int count =0;//记录客户端的数量 
		while(true){ 
			socket = serverSocket.accept(); //不断地监听，使用循环
			ServerThread serverThread =new ServerThread(socket); //每个socket都在一个独立的线程中
			serverThread.start(); 
			count++; 
			System.out.println("客户端连接的数量："+count); 
		} 
	}
}
class ServerThread extends Thread{
	//服务器线程处理 
	//和本线程相关的socket 
	Socket socket =null; 
	// 
	public ServerThread(Socket socket){ 
		this.socket = socket; 
	} 
	 
	public void run(){ 
	//服务器处理代码 
		System.out.println("ServerThread run()");
	} 
}