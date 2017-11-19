package priv.lirenhe.shangxuetang;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class _186 {
	public static void main(String args[]) throws IOException{
		/*
		URL url = new URL("http://www.baidu.com:80/index.html?uname=kslf");
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getFile());
		System.out.println(url.getRef());
		System.out.println(url.getQuery());
		*/
		/*
		URL url =new URL("http://www.baidu.com:80/a");
		url=new URL(url,"/index.html?uname=fjkg");
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getFile());
		System.out.println(url.getRef());
		System.out.println(url.getQuery());
		*/
		/**
		 * 获取资源：源代码
		 */
		/*
		URL url=new URL("http://www.baidu.com");
		InputStream is=url.openStream();
		byte[] flush=new byte[1024];
		int len =0;
		while((len=is.read(flush))!=-1){
			System.out.println(new String(flush,0,len));
		}
		is.close();
		*/
		
		
		
		URL url=new URL("http://www.icourse163.org/");
		BufferedReader br=
				new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
			BufferedWriter bw=
					new BufferedWriter(
							new OutputStreamWriter(
							new FileOutputStream(
									"index.html"),"utf-8"));
					
			String msg=null;
				while((msg=br.readLine())!=null){
					//System.out.println(msg);
					bw.append(msg);
					bw.newLine();
				}
				bw.flush();
				bw.close();
				br.close();
		
	}

}
