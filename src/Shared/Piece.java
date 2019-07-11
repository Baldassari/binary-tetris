package Shared;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Client.Frame;
import Enums.Block;
import Enums.Direction;
import Enums.Status;
//import Enums.Value;
import Enums.Value;

public class Piece extends Rectangle implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1528565773086697691L;
//	private int identifier = 0;
	private Block blockStatus = Block.NOT_BLOCKED;
	private Direction direction = Direction.DOWN;
//	private Direction nextDirection = Direction.DOWN;
	private BufferedImage image;
	private Status status = Status.MOVING;
	private Value value = Value.NONE;
	private Frame frame;
	protected Graphics g;
	
	private Rectangle futurePosition = new Rectangle();
	
	
	
	public Piece(int x, int y, int width, int heights, Frame frame) {
		super( new Point(x,y),new Dimension(width,heights));
		if(frame != null) {
			this.frame = frame;
			this.g = frame.getGraphics();
		}
		calculateRandom();
//		this.identifier = identifier;
//		value = value.getRandom();
		
		System.out.println("Creating piece..");
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Rectangle askPosition(Direction direction) {
		Rectangle result = new Rectangle();
		
		
		
		
		
		return futurePosition = result;
	}
	
	
	
	public Rectangle getArea() {
		return new Rectangle(x, y, width, height);
	}
	
	
	public boolean isAlive() {
		return (status != Status.MOVING);
	}
	
	public boolean isFinished() {
		return status == Status.FINISHED;
	}
	
	public boolean isToRemove() {
		return status == Status.REMOVED;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Piece initiating...");
			while(isAlive()) {
				
				if(canMove()) {
					move(this.g);
				}
				System.out.println("Moving...");
	//			updateFrame();
				
				Thread.sleep(1000);
				
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Piece is finished ... " + serialVersionUID);
		}
	}
	
	private void move(Graphics g) throws InterruptedException{
//		calculateResult();
		
		cleanPiece(g);
		canMove();
		move();

		
		paintPiece(g);

//		Thread.sleep(10 - (velocity.getVelocity() * 3));
		Thread.sleep(10);
		frame.revalidate();
		
	}
	
	private boolean canMove() {
		
		return true;
	}
	
	private void move() {
		switch (direction) {
		case DOWN:			
			switch (blockStatus) {
			case BLOCKED_DOWN:
			case BLOCKED_DOWN_LEFT:
			case BLOCKED_DOWN_LEFT_RIGHT:
			case BLOCKED_DOWN_RIGHT:
			case BLOCKED_UP_DOWN:
				moveIdle();
				break;
			case BLOCKED_LEFT:
			case BLOCKED_LEFT_RIGHT:
			case BLOCKED_RIGHT:
			case BLOCKED_UP:
			case BLOCKED_UP_LEFT:
			case NOT_BLOCKED:
			case BLOCKED_UP_RIGHT:
				moveDown();
				break;
			case FINISHED:
				break;
			default:
				break;
			}
			break;
		case DOWNFAST:
			switch (blockStatus) {
			case BLOCKED_DOWN:
			case BLOCKED_DOWN_LEFT:
			case BLOCKED_DOWN_LEFT_RIGHT:
			case BLOCKED_DOWN_RIGHT:
			case BLOCKED_UP_DOWN:
				moveIdle();
				break;
			case BLOCKED_LEFT:
			case BLOCKED_LEFT_RIGHT:
			case BLOCKED_RIGHT:
			case BLOCKED_UP:
			case BLOCKED_UP_LEFT:
			case BLOCKED_UP_RIGHT:
			case NOT_BLOCKED:
				moveDownFast();
				break;
				
			case FINISHED:
				break;
			default:
				break;
			}
			
			break;
		case LEFT:
			switch (blockStatus) {
			case BLOCKED_DOWN:
			case BLOCKED_DOWN_RIGHT:
			case BLOCKED_RIGHT:
			case BLOCKED_UP:
			case BLOCKED_UP_DOWN:
			case BLOCKED_UP_RIGHT:
			case NOT_BLOCKED:		
				moveLeft();
				break;
			case BLOCKED_DOWN_LEFT:
			case BLOCKED_DOWN_LEFT_RIGHT:
			case BLOCKED_LEFT:
			case BLOCKED_LEFT_RIGHT:
			case BLOCKED_UP_LEFT:
				moveIdle();
 				break;
			case FINISHED:
				break;
			default:
				break;
			}
			
			break;
		case RIGHT:
			switch (blockStatus) {
			case BLOCKED_DOWN:
			case BLOCKED_DOWN_LEFT:
			case BLOCKED_UP:	
			case BLOCKED_LEFT:
			case BLOCKED_UP_DOWN:
			case BLOCKED_UP_LEFT:
			case NOT_BLOCKED:			
				moveRight();
				break;
			case BLOCKED_DOWN_LEFT_RIGHT:
			case BLOCKED_DOWN_RIGHT:
			case BLOCKED_LEFT_RIGHT:
			case BLOCKED_RIGHT:
			case BLOCKED_UP_RIGHT:
				moveIdle();
				break;
			case FINISHED:
				break;		
			default:
				break;
			}
			break;
		case UP:
			switch (blockStatus) {
			case BLOCKED_DOWN:
			case BLOCKED_DOWN_LEFT:
			case BLOCKED_DOWN_LEFT_RIGHT:
			case BLOCKED_DOWN_RIGHT:
			case BLOCKED_LEFT:
			case BLOCKED_LEFT_RIGHT:
			case BLOCKED_RIGHT:
			case NOT_BLOCKED:
				moveIdle();
				break;
			case BLOCKED_UP:
			case BLOCKED_UP_DOWN:
			case BLOCKED_UP_LEFT:
			case BLOCKED_UP_RIGHT:
			case FINISHED:
				break;

			default:
				break;
			}
			break;
		default:
			break;
		}
	}
	
	
	private void moveIdle() {
		setLocation(x, y);
	}
	
	
	
	private void moveDown() {
		setLocation(x,y + 1);
	}
	
	private void moveDownFast() {
		setLocation(x,y + 3);
	}
	
	private void moveLeft() {
		setLocation(x - 1, y);
	}
	
	private void moveRight() {
		setLocation(x + 1, y);
	}
	
	
	public int getIdentifier() {
		return (int) Piece.serialVersionUID;
	}
	
	public Rectangle getFuturePosition() {
		return futurePosition;
	}
	
//	private void setNextDirection(Direction direction) {
//		this.direction = direction;
//	}
	
	
	private void calculateRandom() {
		try {
//			Value value = Value;
			Value random = Value.getRandom();
			switch (random) {
			case ONE:
				value = random;
				image = ImageIO.read(new File("../binarymultiplayer/images/number_one.png"));
				break;
			case ZERO:
				value = random;
				image = ImageIO.read(new File("../binarymultiplayer/images/number_zero.png"));
				break;
			case NONE:
				value = random;
				image = ImageIO.read(new File("../binarymultiplayer/images/number_zero.png")); 
			default:
				break;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void getFutureRectangle() {
//		boolean responseMoveDown = frame.canMove(new Rectangle(this.x, this.y + velocity.getVelocity(), image.getWidth(), image.getHeight()));
//		boolean responseMoveLeft = frame.canMove(new Rectangle(this.x - image.getWidth(),this.y,image.getWidth(),image.getHeight()));
//		boolean responseMoveRight = frame.canMove(new Rectangle(this.x + image.getWidth(), this.y, image.getWidth(), image.getHeight()));
//		boolean responseBlockSpeed = frame.canMove(new Rectangle(this.x, this.y + image.getHeight(), image.getWidth(), image.getHeight()));
//		boolean validHeightBlockSpeed = this.y + (image.getHeight() * 2) < frame.getHeight();
//		boolean finalHeight = this.y + image.getHeight() > frame.getHeight();
//		boolean validLeft = this.x > 0;
//		boolean validRight = this.x + image.getWidth() < frame.getWidth();
//		boolean blockSpeedBoolean = !validHeightBlockSpeed || !responseBlockSpeed;
		
		switch (direction) {
		case DOWN:
			blockStatus = Block.NOT_BLOCKED;
//			if(blockSpeedBoolean) blockStatus = Block.BLOCKED_SPEED;
//			if(finalHeight) {blockStatus = Block.BLOCKED_TOTAL; break;}
//			if(!responseMoveDown) {blockStatus = Block.BLOCKED_TOTAL; break;}
//			if(!validLeft) blockStatus = Block.BLOCKED_LEFT;
//			if(!responseMoveLeft) blockStatus = Block.BLOCKED_LEFT;
//			if(!validLeft && blockSpeedBoolean) blockStatus = Block.BLOCKED_SPEEDLEFT;
//			if(!responseMoveLeft && blockSpeedBoolean) blockStatus = Block.BLOCKED_SPEEDLEFT;
//			if(!validRight) blockStatus = Block.BLOCKED_RIGHT;
//			if(!responseMoveRight) blockStatus = Block.BLOCKED_RIGHT;
//			if(!validRight && blockSpeedBoolean) blockStatus = Block.BLOCKED_SPEEDRIGHT;
//			if(!responseMoveRight && blockSpeedBoolean) blockStatus = Block.BLOCKED_SPEEDRIGHT;
//			if(!responseMoveRight && !responseMoveLeft) blockStatus = Block.BLOCKED_LEFTRIGHT;
//			if(!validLeft && !responseMoveRight) blockStatus = Block.BLOCKED_LEFTRIGHT;
//			if(!validRight && !responseMoveLeft) blockStatus = Block.BLOCKED_LEFTRIGHT;
//			if(!validLeft && !responseMoveRight && blockSpeedBoolean) blockStatus = Block.BLOCKED_FULL;
//			if(!validRight && !responseMoveLeft && blockSpeedBoolean) blockStatus = Block.BLOCKED_FULL;
//			if(!responseMoveLeft && !responseMoveRight && blockSpeedBoolean) blockStatus = Block.BLOCKED_FULL;
			break;
		case LEFT:
		case RIGHT:
			blockStatus = Block.NOT_BLOCKED;
			break;
		default:
			break;
		}
	}
	
	
	public void paintPiece(Graphics g) {
		if(g != null) {
			if(image != null) g.drawImage(image, this.x, this.y, null);
		}
	}	
	public void cleanPiece(Graphics g) {
		if(g != null) {
			if(image != null)g.clearRect(this.x, this.y, image.getWidth(), image.getHeight());
		}
	}
}
