package priv.lirenhe.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client_1 {
	public static void main(String[] args) throws IOException {
		//�ͻ��� 
		//1������������ĵ�ַ���˿ںš����� 
		InetAddress address =InetAddress.getByName("localhost"); 
		int port =10010; 
		byte[] data ="�û�����admin;���룺123".getBytes(); 
		//2���������ݱ����������͵�������Ϣ 
		DatagramPacket packet = new DatagramPacket(data,data.length,address,port); 
		//3������DatagramSocket���� 
		DatagramSocket socket =new DatagramSocket(); 
		//4����������������� 
		socket.send(packet); 
		 
		 
		//���ܷ���������Ӧ���� 
		//====================================== 
		//1���������ݱ������ڽ��ܷ���������Ӧ���� 
		byte[] data2 = new byte[1024]; 
		DatagramPacket packet2 = new DatagramPacket(data2,data2.length); 
		//2�����ܷ�������Ӧ������ 
		socket.receive(packet2); 
		String reply = new String(data2,0,packet2.getLength()); //��Ҫʹ��data����ʱ�����鳤��
		//packet2.getLength()��ֱ�ӵõ����ܵ����߷��������ݳ���
		System.out.println("���ǿͻ��ˣ�������˵��"+reply); 
		//4���ر���Դ 
		socket.close(); 
	}
}
