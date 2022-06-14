
	package Obstacles;

	import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;

import Game.Background;

	public class Heli extends Obstacle {
		private Random r = new Random();
		private int xpos=1200;
		private int ypos=200;
		private Image image;
		private int w;
		private int h;
		private Background b;
		
		public Heli() {
			ypos = 200+r.nextInt(400);
			ImageIcon i = new ImageIcon("heli.png");
			image = i.getImage();
			w=image.getWidth(null);
			h=image.getHeight(null);
		}
		

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
				
					despawn();
				
			
		}
		public void seekPlayer(int playerY)
		{
			if (playerY > ypos) //makes the heli seek the players potition
			{
				ypos+=2;
			} else 
			{
			ypos-=2;	
			}
		}

		public void spawn(int xPos, int yPos)
		{
			xpos = xPos;
			ypos = yPos;
			
		}
		@Override
		public void despawn() {
			
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
			
			return ObstacleType.HELI;
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
			
			return new Rectangle(xpos,ypos-10,getWidth()-25,getHeight()-25);
		}

	}


