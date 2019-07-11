package Shared;

import java.io.Serializable;

public class Message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2751160818154758843L;
	private MessageType messageType;
	private int width;
	private int height;
	private int identifier;
	private int x;
	private int y;
	private int numberColumns;
	private int numberLines;

	
	
	
	public Message(MessageType messageType) {
		this.messageType = messageType;
	}
	
	public Message(MessageType messageType, int width, int height, 
			int x, int y, int numberLines, int numberColumns) {
		this.width = width;
		this.height = height;
		this.messageType = messageType;
		this.x = x;
		this.y = y;
//		this.identifier = identifier;
		this.numberLines = numberLines;
		this.numberColumns = numberColumns;
	}
	
	public Message(MessageType messageType, int x, int y) {
		this.messageType = messageType;
		this.x = x;
		this.y = y;
	}
	
	
	public MessageType getType() {
		return this.messageType;
	}
	
	public int getWith() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	
	public int getIdentifier() {
		return this.identifier;
	}
	
	public int getNumberLines() {
		return this.numberLines;
	}
	
	public int getNumberColumns() {
		return this.numberColumns;
	}
	
}
