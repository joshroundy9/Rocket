package Obstacles;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;

import Game.Background;

public class Fuel extends Obstacle{
	private Random r = new Random();
	private int xpos=1200;
	private int ypos=300;
	private Image image;
	private int w;
	private int h;
	private Background b;
	private boolean hidden = false;
	
	public Fuel() {
		ImageIcon i = new ImageIcon("fuelcan.png");
		image = i.getImage();
		w=image.getWidth(null);
		h=image.getHeight(null);
		ypos = r.nextInt(500);
	}
	
	@Override
	public void move(int roundNumber){
		xpos--;
		xpos--;
		xpos--;
		xpos--;
		xpos--;
		xpos--;
		xpos--;
		for(int i = 0; i<=(roundNumber/3); i++)
		{
			xpos--;
		}
		if (xpos<=-600)
			try {
				despawn();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public void spawn(int xPos, int yPos)
	{
		xpos = xPos;
		ypos = yPos;
		
	}
	@Override
	public void despawn() {
		// TODO Auto-generated method stub
		try {
			b.despawnObstacle();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setBackground(Background background)
	{
		b = background;
	}
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return xpos;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return ypos;
	}

	@Override
	public ObstacleType getType() {
		// TODO Auto-generated method stub
		return ObstacleType.FUEL;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return h;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return w;
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return image;
	}

	@Override
	public Rectangle getRectangle() {
		if(hidden == false)
		return new Rectangle(xpos,ypos,getWidth(),getHeight());
		else return new Rectangle();
	}
	public void hide()
	{
		image = null;
		hidden = true;
		Sound.Sound.fuelUp();
	}
	
}
