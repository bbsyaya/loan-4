package com.hrbb.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import org.apache.log4j.Logger;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.junit.Test;

import com.gnete.net.socket.SocketHelper;

public class SocketTestBase {
	protected Logger logger = Logger.getLogger(SocketTestBase.class);

//	private String url = "221.212.155.77";
	private String url = "10.1.5.224";
	private Integer port = 12121;

	protected String sendMessage(String message) throws Exception {
		StringBuilder response = new StringBuilder();
		Socket socket = null;

		try {
			socket = new Socket(url, port);
			socket.setSoTimeout(20000);
			/*OutputStreamWriter writer = new OutputStreamWriter(
					socket.getOutputStream(), "GBK");
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));

			logger.error("about to write message...");

			writer.write(message, 0, message.length());
			writer.flush();

			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				response.append(line);
			}
			logger.info(response.toString());*/
			OutputStream out = socket.getOutputStream();
			byte[] mess = message.getBytes("GBK");
			SocketHelper helper = new SocketHelper(); 
			helper.setLengthByte(6);
			//helper.set

			byte[] returnMess = helper.sendAndReceive(socket, mess);

			
			
			
			logger.info(new String(returnMess, "GBK"));
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
			} finally {
				socket = null;
			}
		}

		return response.toString();
	}
//	
//	@Test
//	public  void testtest() throws Exception{
//		Socket socket = null;
//		String message ="<UMSFX></UMSFX>";
//		socket = new Socket("221.212.155.77", 12121);
//		socket.setSoTimeout(10000);
//		OutputStream out = socket.getOutputStream();
//		byte[] mess = message.getBytes("GBK");
//		int len = mess.length;
//		out.write(mess);
//		out.flush();
//		InputStream in = socket.getInputStream();
//		byte[] returnMess = new byte[len];
//		int off = 0;
//		     while (off < returnMess.length - 1) {
//		       int read = in.read(returnMess, off, returnMess.length - off);
//		       off+= read;
//		     }
//		System.out.println("return:"+returnMess);
//		
//		
//		System.out.println(new String(returnMess, "UTF8"));
//	}

}
