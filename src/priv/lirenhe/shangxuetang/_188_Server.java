package priv.lirenhe.shangxuetang;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;

public class _188_Server {
	public static void main(String args[]) throws IOException{
		//1,create server socket + port
		DatagramSocket server=new DatagramSocket(8889);
		//2,create receive container
		byte[] container=new byte[1024];
		//3,packet the data
		DatagramPacket packet=new DatagramPacket(container,container.length);
		//4,receive
		server.receive(packet);
		//5,analyze the data
		byte[] data=packet.getData();
		
		double num=convert(data);
	
		int len=packet.getLength();
		System.out.println(num);
		
	}
	
	
	public static double convert(byte[] data) throws IOException{
		DataInputStream dis=new DataInputStream(
					new ByteArrayInputStream(data)
				);
		double num=dis.readDouble();
		dis.close();
		return num;
		
	}
	

}
