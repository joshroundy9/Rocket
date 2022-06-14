package Obstacles;

	import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;

import Game.Background;
import Sound.Sound;

	public class PogoTwo extends Obstacle {
		private Random r = new Random();
		private int xpos=1200;
		private int ypos;
		private int groundLevel = 450;
		private int dy = 0;
		private Image image;
		private int w;
		private int h;
		private Background b;
		
		public PogoTwo() {
			ypos = groundLevel;
			ImageIcon i = new ImageIcon("pogo.png");
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
			for(int i = 0; i<=roundNumber/5; i++) // as the rounds increase the objects move faster
			{
				xpos--;
			}
			
			
			if (xpos<=-600) despawn();
			if(ypos==groundLevel) 
				{
				Sound.pogoBounce();
				dy=28;// jumps when it hits the ground
				}
			
			if (ypos<(groundLevel)) // control randomized jumping
			{
			ypos -= dy;
			dy--;
			} else if(dy <0)
			{
				dy=0;
				ypos=groundLevel;
			} else {
				ypos-=dy;
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
			
			return ObstacleType.POGO;
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
			
			return new Rectangle(xpos,ypos,getWidth()-40,getHeight()-25);
		}


		

	}


