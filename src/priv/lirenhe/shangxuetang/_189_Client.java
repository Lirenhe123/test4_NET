package priv.lirenhe.shangxuetang;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class _189_Client {
	public static void main(String args[]) throws UnknownHostException, IOException{
		Socket client=new Socket("localhost",8888);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		BufferedReader br=new BufferedReader(
				new InputStreamReader(
								client.getInputStream()
							)
				);
		
		
		String echo=br.readLine();
		System.out.println(echo);
		br.close();
	}

}
