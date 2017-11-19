package priv.lirenhe.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 这种思维时错的，不需要我来建立三次握手
 * client和server中只有一个输入输出流
 * @author lenovo
 *
 */
public class Server_1 {
	public static void main(String[] args) throws IOException {
		String buffer=null;
		ServerSocket server=new ServerSocket(9999);
		System.out.println("监听-->阻塞-->等待");
		Socket socket=server.accept();
		System.out.println("接受到连接请求，第一次握手成功");
		
		BufferedWriter bw1=null;
		String response="yes已经接受到你的请求";
		bw1=new BufferedWriter(
				new OutputStreamWriter(
						socket.getOutputStream()));
		bw1.write(response);
		bw1.newLine();
		bw1.flush();
		System.out.println("回应完成，第二次握手成功");
		
		BufferedReader br=new BufferedReader(
				new InputStreamReader(
						socket.getInputStream()));
		String readline=null;
		while((readline=br.readLine())!=null){
			buffer=readline;
			System.out.println("客户端发送了："+readline);
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
			System.out.println("完成回应的数据");
		}
		br.close();
		bw1.close();
		bw2.close();
	}
}
