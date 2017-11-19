package priv.lirenhe.tcp.chat;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{
	Socket socket=null;
	String sendData=null;
	public Send(Socket socket){
		this.socket=socket;
	}
	public String input() throws IOException{
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		String consoleData=br.readLine();
		this.sendData=consoleData;
		return consoleData;
		
	}
	/*public void input(){
		Input input=new Input();
		new Thread(input).start();
		this.sendData=input.getInputString();
	}*/
	public void send(){
		DataOutputStream dos=null;
		try {
			dos = new DataOutputStream(
					new BufferedOutputStream(
									socket.getOutputStream()));
			if(this.sendData!=null){
				dos.writeUTF(this.sendData);
				dos.flush();
			}else{
				input();
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				socket.shutdownOutput();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	
	}
	@Override
	public void run() {
		try {
			input();
		} catch (IOException e) {
			e.printStackTrace();
		}
		send();
		
	}
	
}


