package server;
import java.io.*;
import java.net.*;
import java.util.Base64;
public class MapServlet implements Servlet{
  public void init()throws Exception{
    System.out.println("MapServlet is inited");
  }
  public void service(byte[] requestBuffer, OutputStream out)throws Exception{
    String request=new String(requestBuffer);

    //获得HTTP请求的第一行
    String firstLineOfRequest=request.substring(0,request.indexOf("\r\n"));
    //解析HTTP请求的第一行 
    String[] parts=firstLineOfRequest.split(" "); 
    String method=parts[0]; //获得HTTP请求中的请求方式
    String uri=parts[1]; //获得HTTP请求中的uri
    
	String param1 = "";
	String param2 = "";
	//设定是get的方法，把Post方法去掉
	if(method.equalsIgnoreCase("get")){     
      //假定uri="servlet/MapServlet?ref1=103.000&ref2=30.000"
      //parameters="ref1=103.000&ref2=30.000"
      String parameters=uri.substring(uri.indexOf("?"),uri.length()); 
      parts=parameters.split("&");
      param1=parts[0].split("=")[1];
	  param2=parts[1].split("=")[1];
	  //后台打印获得的经纬度
      System.out.println("\t" + param1 + "\t" + param2); 
	  //创建new.html文件
	  creatNewHtml(param1, param2);
	  //调用浏览器打开new.html文件
	  Process process = Runtime.getRuntime().exec("cmd /c start d:\\jad\\new.html");
    } 
	
    /*创建并发送HTTP响应*/
    //发送HTTP响应第一行
    out.write("HTTP/1.1 200 OK\r\n".getBytes());
    //发送HTTP响应头
    out.write("Content-Type:text/html; charset=GBK\r\n\r\n".getBytes());
    //发送HTTP响应正文
    out.write("<html><head><title>传参页面</title><style>".getBytes());
	out.write("table {border: 2px dotted black;}#name{margin-top: 50px;}".getBytes());
	out.write("</style></head><body>".getBytes());
	out.write("<table width=\"100%\" align=\"center\">".getBytes());
	out.write("<tr><td></td><td>经度</td><td>纬度</td></tr><tr><td>传入的经纬度</td>".getBytes());
	out.write(new String("<td>"+param1+"</td>").getBytes());
	out.write(new String("<td>"+param2+"</td></tr></table>").getBytes());
	out.write("<table id=\"name\" align=\"center\">".getBytes());
	out.write("<tr><td>潘搌鹏</td></tr><tr><td>12电子信息工程</td></tr><tr><td>汽车防盗定位器</td></tr></table></body></html>".getBytes());
  }

public static void creatNewHtml(String param1, String param2) throws Exception{
		File test = new File("D:\\jad\\map.html");
		File newHtml = new File("D:\\jad\\new.html");
		BufferedReader br = new BufferedReader(new FileReader(test));
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(newHtml));
		String str;
		//参数内容
		/*
		 *var param1 = "******"; 
		 *var param2 = "******";
		 **/
		String str1 = "	var param1 = "+param1+";";
		String str2 = "	var param2 = "+param2+";";
		while((str = br.readLine()) != null){
			if(str.indexOf("var param1") != -1){
				out.write(str1);out.write("\r\n");
			}else if(str.indexOf("var param2") != -1){
				out.write(str2);out.write("\r\n");
			}else{
				out.write(str);out.write("\r\n");
			}
			
		}
		br.close();
		out.close();				
}
}
