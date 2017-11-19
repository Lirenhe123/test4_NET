package priv.lirenhe.tcp.chat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class ThreadSocket implements Runnable{
	List<Socket> sockets=null;
	Socket socket=null;
	String socketName=null;
	String buffer=null;
	public ThreadSocket(Socket socket,String socketName,
			List<Socket>sockets){
		this.socket=socket;
		this.socketName=socketName;
		this.sockets=sockets;
	}
	
	public String receive() throws IOException{
		String receiveData=null;
		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						socket.getInputStream()));
		
		receiveData=dis.readUTF();
		buffer=receiveData;
		System.out.print("服务器receiveData是："+receiveData+"  ");
		System.out.println("服务器buffer是："+buffer);
		return receiveData;
	}
	public void sendtoOne(Socket socket) throws IOException{
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
								socket.getOutputStream()));
		dos.writeUTF(buffer);
		dos.flush();
	}
	public void sendtoAll() throws IOException{
		synchronized(sockets){
			for(Socket soc:sockets){
					if(soc!=socket){
						sendtoOne(soc);
					}
			}
		}
		
	}
	public void run(){
		try {
			/*if(buffer.startsWith("@")){
				System.out.println("发送给个人");
			}*/
			receive();
			sendtoAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
