package priv.lirenhe.shangxuetang;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class _189_Server {
	public static void main(String args[]) throws IOException{
		ServerSocket server=new ServerSocket(8888);// addr == null ? InetAddress.anyLocalAddress() : addr
		Socket socket=server.accept();
		System.out.println("一个客户端建立连接");
		
		String str="sjfslfsllflsflsf";
		BufferedWriter bw=new BufferedWriter(
					new OutputStreamWriter(
							socket.getOutputStream()
							)
				);
		bw.write(str);
		bw.newLine();
		bw.flush();
		bw.close();
		
	}
	

}
