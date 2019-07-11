package Server;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;

import Shared.Message;
import Shared.MessageType;

public class ClientHandler implements Runnable {
//	private ObjectOutputStream output;
//	private ObjectInputStream input;
//	private InputStream inputStream;
//	private OutputStream outputStream;
	private Socket socket;
	private Server server;
	
	public ClientHandler(Server server, Socket socket) throws SocketException{
		this.server = server;
		this.socket = socket;
		
		this.socket.setKeepAlive(true);
	}
	
	

	
	
	








	private void process(Object message) {
		Message messageResult = (Message)message;
		switch (messageResult.getType()) {
		case REQUEST_CONFIG:
			
//			super(new Random().nextInt(frame.getNumberColumns()) * 
//					(frame.getWidth()/frame.getNumberColumns()),0);
			
			Random randomX = new Random();
			int randomXResult = randomX.nextInt(server.getNumberColumns());
			
			
			Message response = new Message(MessageType.
					RESPONSE_CONFIG,50,50,randomXResult,0,
					server.getNumberLines(),server.getNumberColumns());
			writeMessage((Object)response);
			
			server.getMap().createPiece();
			break;

		

		default:
			break;
		}
//		Message response = new Message(MessageType.RESPONSE_CONFIG,200, 200);
//		writeMessage(response);
//		System.out.println("Processing message ... " + messageResult.getWith() + " ... " + messageResult.getHeight());
		
		// TODO Auto-generated method stub
		
	}
	
	
	private void writeMessage(Object message) {
		try {
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			
			output.writeObject(message);
			output.flush();
//			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







	@Override
	public void run() {
		// TODO Auto-generated method stub

		
		try {
			
			
			while(!socket.isClosed()) {
					
				
					System.out.println("[ClientHandler] Waiting client request...");
					Object message = null;
					if(socket.getInputStream()!=null) {
						try {
							if((message = (Object)new ObjectInputStream(socket.getInputStream()).readObject()) != null) {
								
								System.out.println("[ClientHandler] Processing request...");
								process(message);
//								socket.getInputStream().skip(10000);
							}
						}catch(EOFException eofException) {
							socket.close();
						}
						
					}
					
//					socket.getInputStream().close();
					
//					Thread.sleep(2000);
				
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
