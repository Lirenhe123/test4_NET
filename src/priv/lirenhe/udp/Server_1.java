package priv.lirenhe.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server_1 {
	public static void main(String[] args) throws IOException {
		//�������ˣ�ʵ�ֻ���UDP���û���¼ 
		//1��������������DatagramSocket��ָ���˿� 
		DatagramSocket socket =new DatagramSocket(10010); 
		//2���������ݱ������ڽ��ܿͻ��˷��͵����� 
		byte[] data =new byte[1024];// 
		DatagramPacket packet =new DatagramPacket(data,data.length); 
		//3�����ܿͻ��˷��͵����� 
		socket.receive(packet);//�˷����ڽ������ݱ�֮ǰ��һ������ 
		//4����ȡ���� 
		String info =new String(data,0,packet.getLength()); 
		System.out.println("���Ƿ��������ͻ��˸�����"+info); 
		
		
		//��ͻ�����Ӧ���� 
		//1������ͻ��˵ĵ�ַ���˿ںš����� 
		InetAddress address = packet.getAddress(); 
		int port = packet.getPort(); 
		byte[] data2 = "��ӭ����".getBytes(); 
		//2���������ݱ���������Ӧ��������Ϣ 
		DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port); 
		//3����Ӧ�ͻ��� 
		socket.send(packet2); 
		//4���ر���Դ 
		socket.close(); 
	}
}
