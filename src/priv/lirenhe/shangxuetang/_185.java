package priv.lirenhe.shangxuetang;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.net.InetSocketAddress;
public class _185 {
	public static void main(String args[]) throws UnknownHostException{
		/*
		InetAddress addressLocal=InetAddress.getLocalHost();
		System.out.println(addressLocal);
		System.out.println(addressLocal.getHostAddress());
		System.out.println(addressLocal.getHostName());
		
		InetAddress addressWeb1=InetAddress.getByName("www.baidu.com");
		System.out.println(addressWeb1.getHostAddress());
		System.out.println(addressWeb1.getHostName());
		
		InetAddress addressWeb2=InetAddress.getByName("111.13.100.91");
		System.out.println(addressWeb2.getHostAddress());
		System.out.println(addressWeb2.getHostName());
		*/
		
		/*
		//InetSocketAddress就是对InetAddress的封装，加了个port
		InetSocketAddress inetadd1=new InetSocketAddress("127.0.0.1",9999);
		System.out.println(inetadd1);
		System.out.println(inetadd1.getHostName());
		System.out.println(inetadd1.getPort());
		//不能字节获取hostAddress，必须先获取InetAddress
		System.out.println(inetadd1.getAddress().getHostAddress());
		*/
		
		InetSocketAddress inetadd2=new InetSocketAddress(InetAddress.getByName("127.0.0.1"),8080);
		System.out.println(inetadd2.getHostName());
		System.out.println(inetadd2.getPort());
		InetAddress address1=inetadd2.getAddress();
		System.out.println(address1.getHostAddress());
		System.out.println(address1.getHostName());
		
		byte[] add=address1.getAddress();
		String str=Arrays.toString(add);
		System.out.println(str);
		
	}
	

}
