package priv.lirenhe.tcp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Input implements Runnable{
	String inputString=null;
	
	public String getInputString(){
		return this.inputString;
	}
	@Override
	public void run() {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		try {
			String consoleData=br.readLine();
			this.inputString=consoleData;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
