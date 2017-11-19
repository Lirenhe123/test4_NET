package priv.lirenhe.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * ����˼άʱ��ģ�����Ҫ����������������
 * client��server��ֻ��һ�����������
 * @author lenovo
 *
 */
public class Client_1 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String buffer=null;
		Socket socket=new Socket("localhost",9999);
		System.out.println("����������");
		
		
		BufferedReader br1=new BufferedReader(
				new InputStreamReader(
						socket.getInputStream()));
		String readline=null;
		while((readline=br1.readLine())!=null){
			buffer=readline;
			System.out.println("�������ķ�Ӧ��"+readline);
		}
		
		BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(
						socket.getOutputStream()));
		System.out.println("************");
		if(buffer.contains("yes")){
			String request="I want you";
			bw.write(request);
			bw.flush();
			System.out.println("���������");
		}
		
		BufferedReader br2=new BufferedReader(
				new InputStreamReader(
						socket.getInputStream()));
		String readlineData=null;
		while((readlineData=br2.readLine())!=null){
			System.out.println("��÷���˵����ݣ�"+readlineData);
		}
		br1.close();
		br2.close();
		bw.close();
	}
}
