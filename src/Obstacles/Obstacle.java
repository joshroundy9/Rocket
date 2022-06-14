package Obstacles;

import java.awt.Image;
import java.awt.Rectangle;

import Game.Background;

public abstract class Obstacle {
	private int xpos;
	private int ypos;
	private Image image;
	private int sizeX;
	private int sizeY;
	
	public Obstacle() {
		
	}
	
	public abstract void move(int roundNumber);
	// moves left by a certain amount
	
	public abstract Image getImage();
	
	public abstract void spawn(int xStart, int yStart);
	// spawns obstacle before it comes on screen
	
	public abstract void despawn();
	// despawns obstacle after it goes off the screen
	
	public abstract void setBackground(Background b);
	
	public abstract int getX();
	//gets x position

	
	public abstract int getY();
	
	public abstract int getHeight();
	
	public abstract int getWidth();
	
	public abstract ObstacleType getType();
	// returns obstacle type
	public abstract Rectangle getRectangle();
	}
