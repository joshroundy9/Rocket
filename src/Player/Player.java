package Player;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player 
{
	private int x;
	private int y;
	private int w;
	private int h;
	private int dy;
	private Image image;
	
	public Player()
	{
		ImageIcon i = new ImageIcon("rocketship.png");
		
		image = i.getImage();
	
		
		w=image.getWidth(null);
		h=image.getHeight(null);
	}
	
	public Image getImage() 
	{
		return image;
	}
	public int getY() 
	{
		return y;
	}
	public int getX() 
	{
		return x;
	}
	public int getWidth()
	{
		return w;
	}
	public int getHeight()
	{
		return h;
	}
	/*
	 * put in the game loop, creates "ground level" at y=450 and gravity
	 */
	public void move() 
	{
		if (y<(425)) 
		{
		y -= dy;
		dy--;
		} else if(dy <0)
		{
			dy=0;
			y=425;
		} else {
			y-=dy;
		}
	}
	
	 public void keyPressed(KeyEvent e) {

	        int key = e.getKeyCode();
/*
 * makes it so you can only jump when on the ground
 * 
 */
	        if (key == KeyEvent.VK_SPACE&&y>-300) { //-300 for normal -5000 for debug
	        	
	            dy = 30;
	        }


	    }

	    public void keyReleased(KeyEvent e) {
	        
	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_SPACE) {
	            dy = 0;
	        }
	        

	    }

}
