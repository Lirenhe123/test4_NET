package priv.lirenhe.shangxuetang;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.DatagramPacket;
import java.net.SocketAddress;

public class _187Client {
	public static void main(String args[]) throws IOException{
		//1,create client+port
		DatagramSocket client=new DatagramSocket(6666);
		//2,data
		String msg="slflaslflaslf很快就上课";
		byte[] data=new byte[1024];
		data=msg.getBytes();
		//3,packet
		DatagramPacket packet=new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
		//4,send
		client.send(packet);
		client.close();
	}
	
	

}
