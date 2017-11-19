package priv.lirenhe.tcp.chat;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
	Socket socket=null;
	String receiveData=null;
	
	public Receive(Socket socket){
		this.socket=socket;
	}
	public String getReceiveData(){
		return this.receiveData;
	}
	public String receive(){
		DataInputStream dis=null;
		try {
			dis = new DataInputStream(
					new BufferedInputStream(
							socket.getInputStream()));
			this.receiveData=dis.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
			try {
				socket.shutdownInput();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return receiveData;
		
	}
	@Override
	public void run() {
		System.out.println(receive());
		
	}
	
}

