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
       System.out.println("port = 8080 (默认)");
       port = 8080; //默认端口为8080
     }

     try{
       serverSocket = new ServerSocket(port); 
       System.out.println("服务器正在监听端口：" + serverSocket.getLocalPort());
        
       while(true) { //服务器在一个无限循环中不断接收来自客户的TCP连接请求
         try{
           //等待客户的TCP连接请求
           final Socket socket = serverSocket.accept(); 
           System.out.println("建立了与客户的一个新的TCP连接，该客户的地址为："+
                socket.getInetAddress()+":" + socket.getPort());
          
           service(socket);  //响应客户请求
        }catch(Exception e){e.printStackTrace();} 
      } //#while
    }catch (Exception e) {e.printStackTrace();}
  }

  /** 响应客户的HTTP请求 */
  public static void service(Socket socket)throws Exception{
    
    /*读取HTTP请求信息*/
    InputStream socketIn=socket.getInputStream(); //获得输入流
    Thread.sleep(500);  //睡眠500毫秒，等待HTTP请求  
    int size=socketIn.available();
    byte[] requestBuffer=new byte[size];
    socketIn.read(requestBuffer);
    String request=new String(requestBuffer);
    System.out.println(request); //打印HTTP请求数据
     
    /*解析HTTP请求*/
    //获得HTTP请求的第一行
    String firstLineOfRequest=request.substring(0,request.indexOf("\r\n"));
    //解析HTTP请求的第一行 
    String[] parts=firstLineOfRequest.split(" "); 
    String uri=parts[1]; //获得HTTP请求中的uri
    
    /*如果请求访问Servlet，则动态调用Servlet对象的service()方法*/   
    if(uri.indexOf("servlet")!=-1){
      //获得Servlet的名字
      String servletName=null;
      if(uri.indexOf("?")!=-1)
        servletName=uri.substring(uri.indexOf("servlet/")+8,uri.indexOf("?"));
      else
        servletName=uri.substring(uri.indexOf("servlet/")+8,uri.length());
      //尝试从Servlet缓存中获取Servlet对象
      Servlet servlet=(Servlet)servletCache.get(servletName);
      //如果Servlet缓存中不存在Servlet对象，就创建它，并把它存放在Servlet缓存中
      if(servlet==null){
        servlet=(Servlet)Class.forName("server."+servletName).newInstance(); 
        servlet.init();//先调用Servlet对象的init()方法
        servletCache.put(servletName,servlet);
      }   
      
      //调用Servlet的service()方法      
      servlet.service(requestBuffer,socket.getOutputStream()); //这里是request和response
      
      Thread.sleep(1000);  //睡眠1秒，等待客户接收HTTP响应结果        
      socket.close(); //关闭TCP连接  
      return;
    } 
  }
}