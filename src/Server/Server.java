package Server;




import java.io.IOException;
import java.io.ObjectOutputStream;
//import java.awt.Dimension;
//import java.awt.ScrollPane;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.BindException;
//import java.net.Inet4Address;
//import java.net.InetAddress;
import java.net.ServerSocket;
//import java.net.Socket;
import Client.Client;
import java.net.SocketException;
import java.util.ArrayList;

import javax.swing.JTextArea;

import Shared.Map;
import Shared.Message;




public class Server extends Thread{

	
	
	///////////////////
	//Client side//////
	///////////////////
	
	protected int PORT = 0;
	protected int numberLines;
	protected int numberColumns;
	protected int velocityDefault;
	private JTextArea serverText;
	private ArrayList<Client> clients = new ArrayList<Client>();
	protected boolean isAlive = false;
	private ServerSocket serverSocket;
	private Map map;
	private Client newClient;
	private String inetAddress;
	
	
	
	@Override
	public void interrupt() {
		// TODO Auto-generated method stub
		try {
			//super.finalize();
			System.out.close();
			serverSocket.close();
//			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			
		}

	}
	
	
	
	
	public void run(){
		try {
								
				appendText("");
				appendText("Server starting...");
				
				try {
					serverSocket = new ServerSocket(PORT);
				}catch(Exception e) {
					e.printStackTrace();
				}

				serverText.setText(serverText.getText() + "\n" + "Server started at address: " + serverSocket.getInetAddress());
				serverText.setText(serverText.getText() + "\n" + "Server started at PORT: " + PORT);
				
				map = new Map(numberLines, numberColumns, numberColumns / 40, numberLines / 40, null, this);
				
				serverText.setText(serverText.getText() + "\n" + "MapServer created: " + map.toString());
				
				
				while(!serverSocket.isClosed()) {
					serverText.setText(serverText.getText() + "\n" + "Waiting for new client...");
					
					
//					serverText.getRootPane().repaint();
					newClient = null;
					try {
						newClient = (Client) serverSocket.accept();
						
						clients.add(newClient);
						new Thread(new ClientHandler(this,newClient)).start();
						serverText.setText(serverText.getText() + "\n" + "New client connected " + newClient.getInetAddress());
					}catch(SocketException e) {
						if(newClient != null) {
							newClient.close();
							serverText.setText(serverText.getText() + "\n" + "Client disconnected " + newClient.getInetAddress());
						}
					}
					
					
					
					
//					new ClientHandler(this,client).start();
					
					
//					clientHandler.start();
					if(serverText.getRootPane() != null)serverText.getRootPane().repaint();
					
					
				}
				
//				System.out.println("Server terminating.");
				
				
				
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
//			serverSocket.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			
			try {
				if(serverSocket != null) {
					if(!serverSocket.isClosed()) {
						serverSocket.setReuseAddress(true);
					
						serverSocket.close();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
	public synchronized void broadcast(Message message) {
		for(Client client: clients){
			try {
				ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
				
				output.writeObject(message);
				output.flush();
//				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private synchronized void appendText(String message) {
		if(message.equals("")) serverText.setText("");
		serverText.setText(serverText.getText() + "\n");
		serverText.setText(serverText.getText() + "\n" + message);
		serverText.getRootPane().repaint();
	}
	
	
	

	

	

	
	
	
	
	

	
	

	
//	public Server(int lines, int columns, int velocity, int PORT, JTextArea serverText) {
//		this.PORT = PORT;
//		this.numberLines = lines;
//		this.numberColumns = columns;
//		this.velocityDefault = velocity;
//		this.serverText = serverText;
//	}
	
	public Server(int lines, int columns, int velocity, String InetAddress, JTextArea serverText) {
		String addressAux = InetAddress;
		System.out.println("Processing inetAddress..." + addressAux);
		if(InetAddress.split(":").length == 2) {
			this.PORT = Integer.parseInt(InetAddress.split(":")[1]);
			
		}
		else {
//			throw new NullPointerException("InetAddress cannot be null.");
		}
//		this.inetAddress = InetAddress.split(":")[0];
		this.inetAddress = addressAux;
		this.numberLines = lines;
		this.numberColumns = columns;
		this.velocityDefault = velocity;
		this.serverText = serverText;
		this.serverText.setSize(200,1000);
//		this.serverText.setSize(new Dimension(((JFrame)this.serverText).);
		
		System.out.println("Server starting at address: " + this.inetAddress);
		System.out.println("Server starting at port: " + this.PORT);
		

	}
	
	public int getNumberLines() {
		return this.numberLines;
	}
	
	public int getNumberColumns() {
		return this.numberColumns;
	}
	
	public int getNumberPieces() {
		return this.map.getNumberPieces();
	}
	
	public Map getMap() {
		return this.map;
	}
	
	

	
	
	
	}
