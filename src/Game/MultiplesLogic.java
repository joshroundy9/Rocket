package Game;
import java.awt.Rectangle;

import Obstacles.*;
public class MultiplesLogic {
	private Fuel fuel;
	private Heli heli;
	private policeCar pC;
	private PogoTwo pogo;
	private Missile missile;
	private Obstacle[] list = new Obstacle[5];
	private ObstacleType ot;
	
	
	public MultiplesLogic()
	{
		fuel = new Fuel();
		heli = new Heli();
		pC=new policeCar();
		pogo=new PogoTwo();
		missile = new Missile();
		
		list[0] = (Obstacle)pC;
		list[1] = (Obstacle)fuel;
		list[2] = (Obstacle)heli;
		list[3] = (Obstacle)pogo;
		list[4] = (Obstacle)missile;
		
		
	}
	public ObstacleType getCollisionType()
	{
		return ot;
	}
	public policeCar getPC()
	{
		
		return pC;
	}
	public Missile getMissile()
	{
		return missile;
	}
	public PogoTwo getPogo()
	{
		return pogo;
	}
	public Heli getH()
	{
		return heli;
	}
	public Fuel getFuel()
	{
		return fuel;
	}
	public void setPC(policeCar c)
	{
		list[0]= c;
	}
	public void setPogo(PogoTwo p)
	{
		list[3]=p;
	}
	public void setHeli(Heli h)
	{
		list[2]=h;
	}
	public void setMissile(Missile m)
	{
		list[4] =m;
	}
	public void setFuel(Fuel f)
	{
		list[1]=f;
	}
	public ObstacleType setPlayerRectangle(Rectangle x)
	{
		
		for(int i =0; i< list.length; i++)
		{
			
			if (x.intersects(list[i].getRectangle()))
			{
				
					ot=list[i].getType();
				return ot;
				
			}
		}
		return null;
	}
}
