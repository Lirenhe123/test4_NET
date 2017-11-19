package priv.lirenhe.shangxuetang;
import java.net.DatagramSocket;
import java.io.IOException;
import java.net.DatagramPacket;

public class _187Server {
	public static void main(String args[]) throws IOException{
		//1,create server socket + port
		DatagramSocket server=new DatagramSocket(8888);
		//2,create receive container
		byte[] container=new byte[1024];
		//3,packet the data
		DatagramPacket packet=new DatagramPacket(container,container.length);
		//4,receive
		server.receive(packet);
		//5,analyze the data
		byte[] data=new byte[1024];
		data=packet.getData();
		int len=packet.getLength();
		System.out.println(new String(data,0,len));
	}
}
