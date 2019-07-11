package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.net.Socket;

//import javax.swing.JFrame;

import Shared.Message;
import Shared.MessageType;



public class ServerHandler implements Runnable {
//	private Socket socket;
	private Client client;
	
	
	
	public ServerHandler(Client client) {
//		this.socket = socket;
		this.client = client;
	}
	
	@Override
	public void run() {
//		ObjectInputStream input = null;
//		System.out.println("[ServerHandler] Running.....");
		
		try {
//			System.out.println("[ServerHandler] Creating input channel....");
//			System.out.println("[ServerHandler] Socket is alive... " + socket.getInputStream().toString());
//			input = new ObjectInputStream(socket.getInputStream());
//			System.out.println("[ServerHandler] Input channel created sucessfully...");
			
			while(client.isConnected()) {
				
				
				System.out.println("Waiting for server messages...");
				Object message = null;
				if((message = new ObjectInputStream(client.getInputStream()).readObject()) != null) {
					
					
					process(message);
					System.out.println("Processing message...");
				
			
			
			
				}
			}	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally {
//			try {
//				if(input != null) input.close();
//				
//				
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	
	private void process(Object message) {
		Message messageResult = (Message) message;
		
		switch (messageResult.getType()) {
		
		
			
		case RESPONSE_CONFIG:
//			client.setSize(messageResult.getWith(),messageResult.getHeight());
//			client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			client.setVisible(true);
			
//			client.fr
			
			int numberColumns = messageResult.getNumberColumns();
			int numberLines = messageResult.getNumberLines();
			int imageWidth = messageResult.getWith();
			int imageHeight = messageResult.getHeight();
			
//			System.out.println("Processing response config...");
//			System.out.println("NumberColumns: " + numberColumns);
//			System.out.println("NumberLines: " + numberLines);
			
			client.configFrame(numberColumns, numberLines, imageWidth, imageHeight);
//			Thread thread = new Thread(client.getFrame().movingRectangle);
//			thread.start();
//			thread.join();
			
			
			break;
		default:
			break;
		}
	}
	
	
	public void doRequest(MessageType type) {
		writeMessage((Object)new Message(type));
	}
	
	
	private synchronized void writeMessage(Object message) {
		try {
			ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
			
			System.out.println("Writing message on channel..");
			output.writeObject(message);
			output.flush();
			
//			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
