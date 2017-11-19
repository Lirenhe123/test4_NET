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
     * ���췽�� 
     *  
     * @param socket 
     *            ��ǰ���ӵĿͻ��� 
     * @param list 
     *            �洢�����ӿͻ��˵ļ��� 
     */  
    public HandleSocket(Socket socket, List<Socket> list) {  
        this.socket = socket;  
        this.list = list;  
    }  
  
    /** 
     * �߳�run���� 
     */  
    @Override  
    public void run() {  
        InetAddress address = socket.getInetAddress(); // ��ȡ���ӵ�����������Ŀͻ��˵ĵ�ַ  
        String ip = address.getHostAddress();  
        System.out.println(ip + "�����ˣ�");  
        if (ip.equals("localhost")) {  //192.168.1.117
            synchronized (list) {  
                sendToAll(ip + "����Υ��������ѱ������������");  
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
                System.out.println(msg); // ������������˵Ŀ���̨  
                // ������ͻ���˵�Ļ��������������еĿͻ���  
                sendToAll(msg);  
            }  
  
        } catch (IOException e) {  
            // e.printStackTrace();  
            System.out.println(ip + "�����ˣ�");  
            synchronized (list) {  
                list.remove(socket);  
            }  
        }  
    }  
  
    /** 
     * ����Ϣ���͸����еĿͻ��ˣ�ȥ����ǰsocket 
     *  
     * @param msg 
     *            ���͵���Ϣ 
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
