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

    //���HTTP����ĵ�һ��
    String firstLineOfRequest=request.substring(0,request.indexOf("\r\n"));
    //����HTTP����ĵ�һ�� 
    String[] parts=firstLineOfRequest.split(" "); 
    String method=parts[0]; //���HTTP�����е�����ʽ
    String uri=parts[1]; //���HTTP�����е�uri
    
	String param1 = "";
	String param2 = "";
	//�趨��get�ķ�������Post����ȥ��
	if(method.equalsIgnoreCase("get")){     
      //�ٶ�uri="servlet/MapServlet?ref1=103.000&ref2=30.000"
      //parameters="ref1=103.000&ref2=30.000"
      String parameters=uri.substring(uri.indexOf("?"),uri.length()); 
      parts=parameters.split("&");
      param1=parts[0].split("=")[1];
	  param2=parts[1].split("=")[1];
	  //��̨��ӡ��õľ�γ��
      System.out.println("\t" + param1 + "\t" + param2); 
	  //����new.html�ļ�
	  creatNewHtml(param1, param2);
	  //�����������new.html�ļ�
	  Process process = Runtime.getRuntime().exec("cmd /c start d:\\jad\\new.html");
    } 
	
    /*����������HTTP��Ӧ*/
    //����HTTP��Ӧ��һ��
    out.write("HTTP/1.1 200 OK\r\n".getBytes());
    //����HTTP��Ӧͷ
    out.write("Content-Type:text/html; charset=GBK\r\n\r\n".getBytes());
    //����HTTP��Ӧ����
    out.write("<html><head><title>����ҳ��</title><style>".getBytes());
	out.write("table {border: 2px dotted black;}#name{margin-top: 50px;}".getBytes());
	out.write("</style></head><body>".getBytes());
	out.write("<table width=\"100%\" align=\"center\">".getBytes());
	out.write("<tr><td></td><td>����</td><td>γ��</td></tr><tr><td>����ľ�γ��</td>".getBytes());
	out.write(new String("<td>"+param1+"</td>").getBytes());
	out.write(new String("<td>"+param2+"</td></tr></table>").getBytes());
	out.write("<table id=\"name\" align=\"center\">".getBytes());
	out.write("<tr><td>������</td></tr><tr><td>12������Ϣ����</td></tr><tr><td>����������λ��</td></tr></table></body></html>".getBytes());
  }

public static void creatNewHtml(String param1, String param2) throws Exception{
		File test = new File("D:\\jad\\map.html");
		File newHtml = new File("D:\\jad\\new.html");
		BufferedReader br = new BufferedReader(new FileReader(test));
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(newHtml));
		String str;
		//��������
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