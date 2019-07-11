package Client;

//import java.awt.Dimension;
//import java.awt.Point;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;

//import javax.swing.JFrame;

//import Enums.Direction;
import Enums.Status;
import Shared.Map;
import Shared.MessageType;
import Shared.Piece;


public class Client extends Socket implements Runnable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8842554546971028409L;
	public Socket client;
//	private int locationX;
//	private int locationY;
//	private int imageSize;
//	private int numberLines;
//	private int numberColumns;
//	private ArrayList<Piece> pieces = new ArrayList<Piece>();
//	private Piece movingRectangle;
	private Status statusGame = Status.MOVING;
	public int score = 0;
	public int target = 0;
//	private Map map;
	private Frame frame;
	
	private boolean canCreate = true;
	private ServerHandler serverHandler;
	
	
	
	public Client() throws UnknownHostException, IOException {
			super(InetAddress.getByName("127.0.0.1"),8080);
		
			
//			Socket socket = new Socke
//			client = new Socket(InetAddress.getByName("localhost"),8080);
//			new Thread(serverHandler = new ServerHandler(client,this)).start();
			
			System.out.println("ServerHandler created.");
			new Thread(serverHandler = new ServerHandler(this)).start();;
			configFrame();
			
//			System.out.println(InetAddress.getByName("localhost"));
			
			
//			setVisible(true);
//			addKeyListener(new KeyListener() {
//				
//				@Override
//				public void keyTyped(KeyEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//				
//				@Override
//				public void keyReleased(KeyEvent e) {
//					// TODO Auto-generated method stub
//					if(movingRectangle != null) movingRectangle.setDirection(Direction.DOWN);									
//				}
//				
//				@Override
//				public void keyPressed(KeyEvent e) {
//					// TODO Auto-generated method stub
//					int keyCode = e.getKeyCode();
//					switch (keyCode) {
//					case KeyEvent.VK_DOWN:
//						if(movingRectangle != null)
//							movingRectangle.setDirection(Direction.DOWNFAST);
//						break;
//					case KeyEvent.VK_LEFT:
//						if(movingRectangle != null)
//							movingRectangle.setDirection(Direction.LEFT);
//						break;
//					case KeyEvent.VK_RIGHT:
//						if(movingRectangle != null)
//							movingRectangle.setDirection(Direction.RIGHT);
//						break;
//					case KeyEvent.VK_SPACE:
//						movingRectangle = null;					
//						break;
//					default:
//						break;
//					}
//				}
//			});

	}
	
	
	private void configFrame() {
		// TODO Auto-generated method stub
		
		serverHandler.doRequest(MessageType.REQUEST_CONFIG);
		
		
//		frame = new Frame(numberColumns, numberLines, imageWidth, imageHeight);
	}
	
	public void configFrame(int numberColumns, int numberLines, int imageWidth, int imageHeight) {
		frame = new Frame(numberColumns, numberLines, imageWidth, imageHeight);
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@SuppressWarnings("null")
	public static void main(String[] args) {
		Client c = null;
		try {
			c = new Client();
//		System.out.println("Client: " + c.movingRectangle.getFuturePosition());

		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("No server online.");
			try {
				c.shutdownInput();
				c.shutdownOutput();
			}catch(IOException error) {
				
				
			}
			
			System.exit(0);
			
//			System.out.println("try catch unknowhostexception");
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();	
			
			System.out.println("No server online.");
			System.exit(1);
//			System.out.println("try catch unknowhostexception");
		}
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(statusGame != Status.FINISHED) {				
			try {
				if(canCreate()) {

					create();
				}
				
				if(frame.movingRectangle != null) {
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							frame.movingRectangle.run();
						}
					}).start();
				}
				Thread.sleep(10);
//				thread.join();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public boolean canCreate() {
		return canCreate;
	}
	
	public Piece getMovingPiece() {
		return frame.movingRectangle;
	}
	
	
	public void setMovingPiece(int identifier, int x, int y,int width, int height) {
//		if(this.movingRectangle.getIdentifier() !=)
//		this.movingRectangle = new Piece(identifier,x,y,width,height);
	}
	
	private void create() {
		
		
//		if(movingRectangle != null) finishedPieces.add(movingRectangle);
//		movingRectangle = new Piece();
//		pieces.add(movingRectangle);
	}
	
	public Map getMap() {
		return this.frame.map;
	}
	
	public Frame getFrame() {
		return this.frame;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
