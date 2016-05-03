package server;
import java.io.*;
import java.net.*;
import java.util.*;
public class HTTPServer{
  private static Map servletCache=new HashMap();
  
  public static void main(String args[]) {
    int port;
    ServerSocket serverSocket;
      
    try { 
       port = Integer.parseInt(args[0]);
     }catch (Exception e) {
       System.out.println("port = 8080 (Ĭ��)");
       port = 8080; //Ĭ�϶˿�Ϊ8080
     }

     try{
       serverSocket = new ServerSocket(port); 
       System.out.println("���������ڼ����˿ڣ�" + serverSocket.getLocalPort());
        
       while(true) { //��������һ������ѭ���в��Ͻ������Կͻ���TCP��������
         try{
           //�ȴ��ͻ���TCP��������
           final Socket socket = serverSocket.accept(); 
           System.out.println("��������ͻ���һ���µ�TCP���ӣ��ÿͻ��ĵ�ַΪ��"+
                socket.getInetAddress()+":" + socket.getPort());
          
           service(socket);  //��Ӧ�ͻ�����
        }catch(Exception e){e.printStackTrace();} 
      } //#while
    }catch (Exception e) {e.printStackTrace();}
  }

  /** ��Ӧ�ͻ���HTTP���� */
  public static void service(Socket socket)throws Exception{
    
    /*��ȡHTTP������Ϣ*/
    InputStream socketIn=socket.getInputStream(); //���������
    Thread.sleep(500);  //˯��500���룬�ȴ�HTTP����  
    int size=socketIn.available();
    byte[] requestBuffer=new byte[size];
    socketIn.read(requestBuffer);
    String request=new String(requestBuffer);
    System.out.println(request); //��ӡHTTP��������
     
    /*����HTTP����*/
    //���HTTP����ĵ�һ��
    String firstLineOfRequest=request.substring(0,request.indexOf("\r\n"));
    //����HTTP����ĵ�һ�� 
    String[] parts=firstLineOfRequest.split(" "); 
    String uri=parts[1]; //���HTTP�����е�uri
    
    /*����������Servlet����̬����Servlet�����service()����*/   
    if(uri.indexOf("servlet")!=-1){
      //���Servlet������
      String servletName=null;
      if(uri.indexOf("?")!=-1)
        servletName=uri.substring(uri.indexOf("servlet/")+8,uri.indexOf("?"));
      else
        servletName=uri.substring(uri.indexOf("servlet/")+8,uri.length());
      //���Դ�Servlet�����л�ȡServlet����
      Servlet servlet=(Servlet)servletCache.get(servletName);
      //���Servlet�����в�����Servlet���󣬾ʹ������������������Servlet������
      if(servlet==null){
        servlet=(Servlet)Class.forName("server."+servletName).newInstance(); 
        servlet.init();//�ȵ���Servlet�����init()����
        servletCache.put(servletName,servlet);
      }   
      
      //����Servlet��service()����      
      servlet.service(requestBuffer,socket.getOutputStream()); //������request��response
      
      Thread.sleep(1000);  //˯��1�룬�ȴ��ͻ�����HTTP��Ӧ���        
      socket.close(); //�ر�TCP����  
      return;
    } 
  }
}