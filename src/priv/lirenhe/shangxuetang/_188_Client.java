package priv.lirenhe.shangxuetang;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class _188_Client {
	/**
	 * 89.12 数据+类型
	 * double-->字节数组 字节数组输出流
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException{
		DatagramSocket client=new DatagramSocket(6667);
		double num=89.12;
		
		byte[] data=conver(num);
		DatagramPacket packet=new DatagramPacket(
				data,data.length,new InetSocketAddress("localhost",8889));
		client.send(packet);
		client.close();
		
	}
	
	public static byte[] conver(double num) throws IOException{
		byte[] data=null;
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(bos);
		dos.writeDouble(num);
		dos.flush();
		data=bos.toByteArray();
		dos.close();
		return data;
		
	}
}
