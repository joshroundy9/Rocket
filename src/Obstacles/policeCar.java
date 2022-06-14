package Obstacles;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.ImageIcon;

import Game.Background;

public class policeCar extends Obstacle {

	private int xpos=1200;
	private int ypos=600;
	private Image image;
	private int w;
	private int h;
	private Background b;
	
	public policeCar() {
		ImageIcon i = new ImageIcon("police.png");
		image = i.getImage();
		w=image.getWidth(null);
		h=image.getHeight(null);
		
	}
	
	@Override
	public void move(int roundNumber) {
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
	public void despawn(){
		
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
		
		return xpos;
	}

	@Override
	public int getY() {
		
		return ypos;
	}

	@Override
	public ObstacleType getType() {
		
		return ObstacleType.POLICECAR;
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
	public Image getImage() {
		
		return image;
	}
public Rectangle getRectangle() {
		
		return new Rectangle(xpos+25,ypos+25,getWidth()-50,getHeight()-25);
	}

}
