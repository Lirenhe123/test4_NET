package priv.lirenhe.tcp.chat.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

public class HandleSocket extends Thread {  
	  
    private Socket socket;  
    private List<Socket> list;  
  
    /** 
     * 构造方法 
     *  
     * @param socket 
     *            当前连接的客户端 
     * @param list 
     *            存储已连接客户端的集合 
     */  
    public HandleSocket(Socket socket, List<Socket> list) {  
        this.socket = socket;  
        this.list = list;  
    }  
  
    /** 
     * 线程run方法 
     */  
    @Override  
    public void run() {  
        InetAddress address = socket.getInetAddress(); // 获取连接到服务器的这的客户端的地址  
        String ip = address.getHostAddress();  
        System.out.println(ip + "上线了！");  
        if (ip.equals("localhost")) {  //192.168.1.117
            synchronized (list) {  
                sendToAll(ip + "由于违规操作，已被拉入黑名单！");  
                list.remove(socket);  
            }  
            return;  
        }  
  
        try {  
            BufferedReader br = new BufferedReader(new InputStreamReader(  
                    socket.getInputStream(), "gbk"));  
  
            String line = "";  
            while ((line = br.readLine()) != null) {  
                String msg = ip + ":" + line;  
                System.out.println(msg); // 输出到服务器端的控制台  
                // 把这个客户端说的话，发给其他所有的客户端  
                sendToAll(msg);  
            }  
  
        } catch (IOException e) {  
            // e.printStackTrace();  
            System.out.println(ip + "下线了！");  
            synchronized (list) {  
                list.remove(socket);  
            }  
        }  
    }  
  
    /** 
     * 把信息发送给所有的客户端，去除当前socket 
     *  
     * @param msg 
     *            发送的信息 
     */  
    private void sendToAll(String msg) {  
        synchronized (list) {  
            for (Socket s : list) {  
                if (s != socket) {  
                    try {  
                        PrintStream ps = new PrintStream(s.getOutputStream()); 
                        ps.print(msg);
                        ps.println();  
                    } catch (IOException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }  
    }  
  
}  
