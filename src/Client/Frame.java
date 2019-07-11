package Client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

import Enums.Direction;
import Enums.Status;
import Shared.Map;
import Shared.Piece;

public class Frame extends JFrame{
	protected static final long serialVersionUID = 1L;
	private final int locationX = 500;
	private final int locationY = 150;
//	private final int imageSize = 32;
//	private final int numberLines = 10;
//	private final int numberColumns = 6;
	private ArrayList<Piece> pieces = new ArrayList<Piece>();
	private ArrayList<Piece> finishedPieces = new ArrayList<Piece>(); 
	protected Piece movingRectangle;
	protected Status statusGame = Status.MOVING;
	public int score = 0;
	protected Map map;
//	public int target = 0;
//	private String title = "Score:" + score;
	
	public Frame(int numberColumns, int numberLines, int imageWidth, int imageHeight) {
//		target = randomTarget();
		setSize(numberColumns * imageWidth, numberLines * imageHeight);
		setLocation(locationX, locationY);
//		setVisible(true);
//		setTitle("Score:" + score + " Target: " + target);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
//				 TODO Auto-generated method stub
//				System.out.println("keyTyped");

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
//				if(e.getKeyCode() != KeyEvent.VK_SPACE) {
//					if(movingRectangle != null)
//						movingRectangle.setDirection(Direction.DOWN);
//				}
				// TODO Fazer pedido servidor para andar

			}
			
			@Override
			public void keyPressed(KeyEvent e) {
//				int keyCode = e.getKeyCode();
//				switch (keyCode) {
//				case KeyEvent.VK_DOWN:
//					if(movingRectangle != null)
//						movingRectangle.setDirection(Direction.DOWNFAST);
//					break;
//				case KeyEvent.VK_LEFT:
//					if(movingRectangle != null)
//						movingRectangle.setDirection(Direction.LEFT);
//					break;
//				case KeyEvent.VK_RIGHT:
//					if(movingRectangle != null)
//						movingRectangle.setDirection(Direction.RIGHT);
//					break;
//				case KeyEvent.VK_SPACE:
//					movingRectangle = null;					
//					break;
//				default:
//					break;
//				}
				//TODO Fazer pedido servidor para andar
				
			}
		});
	}
	
	
	
	public void spawn() {
			while(statusGame != Status.FINISHED) {				
				try {
					if(canCreate()) {

						create();
					}
//					new Thread(new Runnable() {
//						
//						@Override
//						public void run() {
//							m
//						}
//					}).start();
//					Thread thread = new Thread(movingRectangle);
//					thread.start();
//					thread.join();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		
	}
	
//	public int randomTarget() {
//		return (int)(new Random().nextInt((int) Math.pow(2, numberColumns)));
//	}

//	public void checkStatus() {
//		if(movingRectangle == null) {
//			for(Piece p: finishedPieces) {
//				p.cleanPiece(getGraphics());
//			}
//			finishedPieces.clear();
//			pieces.clear();
//			target = randomTarget();
//			score = 0;
//			Thread.currentThread().interrupt();
////			return;
//		}else {
//			for(int i = getMaxLine(); i > 0; i--) {
//				if(lineComplete(i)) {
//					int value = 0;
//	
//					for(Piece p: finishedPieces) {
//						if(p.getLine() == i) {
//							p.setRemoveMark(true);
//							value = value + p.getValueInt();
//						}else {
//							p.setRemoveMark(false);
//						}
//					}
//					if(value == target) {
//						System.out.println("Line complete...." + i);
//						score = score + value;
//						target = randomTarget();
//						clearFinished(i);
//	//					setTitle("Score: " + score + "  Target: " + target);
//					}
//				}
//			}
//		}
//		setTitle("Score:" + score + " [" + target + "]");
//	}
	
	
//	private boolean lineComplete(int line) {
//		int count = 0;
//		int value = 0;
//		for(Piece p: finishedPieces) {
//			if(p.getLine() == line) {
//				value = value + p.getValueInt();
//				count++;
//			}
//			
//		}
////		System.out.println("Line complete..." + value + " ...  counter .. " + count + " ... numberColumns .. " + numberColumns );
//		if(count  == numberColumns) {
//			if(value == target) return true;
//		}
//		return false;
//	}
	
//	private void clearFinished(int line) {
//
//		ArrayList<Piece> result = new ArrayList<Piece>();
//		for(Piece p: finishedPieces) {
//			p.cleanPiece(getGraphics());
//			if(!p.getRemoveMark()) {
//				if(p.getLine() > line) {
//					result.add(p.Clone(false));
//				}else {
//					result.add(p.Clone(true));
//				}
//			}
//		}
//		finishedPieces.clear();
//		finishedPieces = result;
//		for(Piece piece: finishedPieces) {
//			piece.paintPiece(getGraphics());
//		}
//	}
	
	
	private void create() {
		map.createPiece();
	}
//		if(movingRectangle != null) finishedPieces.add(movingRectangle);
//		movingRectangle = new Piece(this);
//		pieces.add(movingRectangle);
//	}
	
	public int getPiecesCounter() {
		return pieces.size();
	}
	
//	public int getNumberLines() {
//		return numberLines;
//	}
//	
//	public int getNumberColumns() {
//		return numberColumns;
//	}
	
	private boolean canCreate() {
//		for(Piece p: pieces) {
//			if(p.isAlive()) return false;
//		}
		return true;
	}
	
	
//	public static void main(String[] args) {
//		new Frame().spawn();
//	}



//	public boolean canMove(Rectangle target) {
//		for(Piece p : finishedPieces) {
//			Rectangle r = new Rectangle(p.x, p.y, p.getWidth(), p.getHeight());
//			if(r.intersects(target)) return false;
//		}
//		return true;
//	}



//	public int getMaxLine() {
//		int max = 0;
//		for(Piece p: finishedPieces) {
//			if(p.getLine() > max) max = p.getLine();
//		}
//		return max;
//	}





	
}
