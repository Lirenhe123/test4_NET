package priv.lirenhe.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ����˼άʱ��ģ�����Ҫ����������������
 * client��server��ֻ��һ�����������
 * @author lenovo
 *
 */
public class Server_1 {
	public static void main(String[] args) throws IOException {
		String buffer=null;
		ServerSocket server=new ServerSocket(9999);
		System.out.println("����-->����-->�ȴ�");
		Socket socket=server.accept();
		System.out.println("���ܵ��������󣬵�һ�����ֳɹ�");
		
		BufferedWriter bw1=null;
		String response="yes�Ѿ����ܵ��������";
		bw1=new BufferedWriter(
				new OutputStreamWriter(
						socket.getOutputStream()));
		bw1.write(response);
		bw1.newLine();
		bw1.flush();
		System.out.println("��Ӧ��ɣ��ڶ������ֳɹ�");
		
		BufferedReader br=new BufferedReader(
				new InputStreamReader(
						socket.getInputStream()));
		String readline=null;
		while((readline=br.readLine())!=null){
			buffer=readline;
			System.out.println("�ͻ��˷����ˣ�"+readline);
		}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		BufferedWriter bw2=null;
		if(buffer.contains("you")){
			String responseData="i give me to you";
			bw2=new BufferedWriter(
					new OutputStreamWriter(
							socket.getOutputStream()));
			bw2.write(responseData);
			bw2.newLine();
			bw2.flush();
			System.out.println("��ɻ�Ӧ������");
		}
		br.close();
		bw1.close();
		bw2.close();
	}
}
