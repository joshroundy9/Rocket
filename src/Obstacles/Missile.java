package Obstacles;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;

import Game.Background;

public class Missile extends Obstacle{

	private Random r = new Random();
	private int xpos=2500;
	private int ypos=-1200;
	private int tX=-200,tY;
	private final int sSlope; //set slope of the starting position to the target
	private Image image;
	private int w;
	private int h;
	private Background b;
	
	public Missile()
	{
		
		tY = r.nextInt(800);
		
		sSlope = (xpos-tX)/(ypos-tY);
		ImageIcon i = new ImageIcon("missile.png");
		image = i.getImage();
		w=image.getWidth(null);
		h=image.getHeight(null);
	}
	public int getTX()
	{
		return tX;
	}
	public int getTY()
	{
		return tY;
	}
	@Override
	public void move(int roundNumber) {
		int cSlope; // current slope of the missile to the target
		for(int i = 0; i<=13; i++)
		{
			xpos--;
		}
		if(ypos-tY!=0)
			cSlope = (xpos-tX)/(ypos-tY);
			else cSlope = (xpos-tX)/(1+(ypos-tY));
		
		while(cSlope>sSlope)
		{
			ypos++;
			if(ypos-tY!=0)
			cSlope = (xpos-tX)/(ypos-tY);
			else cSlope = (xpos-tX)/(1+(ypos-tY));
		}
		if (xpos<=-600)
			
			despawn();
		
		
	}

	@Override
	public Image getImage() {
		
		return image;
	}

	@Override
	public void spawn(int xStart, int yStart) {
		
		xpos = xStart;
		ypos = yStart;
	}

	@Override
	public void despawn() {
		
		try {
			b.despawnObstacle();
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void setBackground(Background bg) {
		
		b=bg;
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
		
		return ObstacleType.MISSILE;
	}

	@Override
	public Rectangle getRectangle() {
		
		return new Rectangle(xpos-10,ypos+10,getWidth()-75,getHeight()-75);
	}

}
