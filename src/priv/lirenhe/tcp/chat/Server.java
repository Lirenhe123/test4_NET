package priv.lirenhe.tcp.chat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private List<Socket> sockets=new ArrayList<Socket>();
	
	public static void main(String[] args) throws IOException{
		new Server().start();
	}
	
	public void start() throws IOException{
		ServerSocket server=new ServerSocket(10086);
		String buffer=null;
		while(true){
			Socket socket=server.accept();
			
			int i=1;
			String socketName="socket"+i;
			i++;
			synchronized(sockets){
				sockets.add(socket);
			}
			ThreadSocket threadSocket=new ThreadSocket(socket,socketName,sockets);
			
			new Thread(threadSocket).start();
		}
	}
}


