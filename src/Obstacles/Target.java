package Obstacles;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Game.Background;

public class Target extends Obstacle{
	
	private int ypos=1500,xpos=1500,w,h;
	private Image image;
	
	public Target()
	{
		ImageIcon i = new ImageIcon("target.png");
		image = i.getImage();
		w=image.getWidth(null);
		h=image.getHeight(null);
	}
	@Override
	public void move(int roundNumber) {
		 
		
	}
	public void setPos(int x,int y) {
		xpos=x;
		ypos=y;
	}

	@Override
	public Image getImage() {
		
		return image;
	}

	@Override
	public void spawn(int xStart, int yStart) {
		 
		
	}

	@Override
	public void despawn() {
		 
		xpos = 1500;
		ypos=1500;
	}

	@Override
	public void setBackground(Background b) {
		 
		
	}

	@Override
	public int getX() {
		 
		return xpos;
	}

	@Override
	public int getY() {
		 
		return ypos;
	}

	@Override
	public int getHeight() {
		 
		return h;
	}

	@Override
	public int getWidth() {
		 
		return w;
	}

	@Override
	public ObstacleType getType() {
		 
		return null;
	}

	@Override
	public Rectangle getRectangle() {
		 
		return null;
	}

}
