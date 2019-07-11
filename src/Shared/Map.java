package Shared;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.function.BiConsumer;

import Client.Frame;
import Server.Server;

public class Map{
	
	protected HashMap<Integer, Point> piecesPosition = new HashMap<Integer, Point>();
	protected HashMap<Point, Boolean> checkPositionFull = new HashMap<Point, Boolean>();
	protected int numberLines;
	protected int numberColumns;
	protected int pieceWidth;
	protected int pieceHeight;
	protected Frame frame;
	protected Server server;
	
	
	
	public ArrayList<Piece> pieces = new ArrayList<Piece>(); 
	
	
	

	
	
	public Map(int numberLines, int numberColumns, int pieceWidth, int pieceHeight,Frame frame, Server server) {
		this.numberColumns = numberColumns;
		this.numberLines = numberLines;
		this.pieceHeight = pieceHeight;
		this.pieceWidth = pieceWidth;
		this.frame = frame;
		this.server = server;
	}
	
	
	public synchronized void createPiece() {
//		System.out.println("Creating piece...");
		Point spawnPosition = generatePoint();
		Piece newPiece = null;
		if(this.frame != null) {
			newPiece = new Piece(spawnPosition.x,spawnPosition.y,pieceWidth,pieceHeight,this.frame);
			frame.spawn();
			
		}else {
			newPiece = new Piece(spawnPosition.x,spawnPosition.y,pieceWidth,pieceHeight,null);
		}
		
		
		
		piecesPosition.put(newPiece.getIdentifier(), spawnPosition);
		checkPositionFull.remove(spawnPosition);
		checkPositionFull.put(spawnPosition, true);
		
		System.out.println("Created new piece: " + newPiece.getLocation());
		
		
		
		server.broadcast(new Message(MessageType.SYNC_POSITION,newPiece.x,newPiece.y));
		
	}
	
	
	public void config() {
		for(int x = 0; x < numberColumns; x++) {
			for(int y = 0; y < numberLines; y++) {
				checkPositionFull.put(new Point(x,y), false);
			}
		}
	}
	
	
	public synchronized int getNumberPieces() {
		return this.pieces.size();
	}
	
	
	
	private synchronized Point generatePoint() {
		Point result = new Point();
		for(int columns = 0; columns < numberColumns; columns++) {
			result = new Point(columns,0);
			if(checkPositionFull.containsKey(result)) {
				 if(checkPositionFull.get(result)) {
					 return null;
				 }else {
					 return result;
				 }
			}else {
				return result;
			}
			
		}
		return result;
		
		
	}
}
