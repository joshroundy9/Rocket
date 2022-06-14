package Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Obstacles.Fuel;
import Obstacles.Heli;
import Obstacles.Missile;
import Obstacles.Obstacle;
import Obstacles.ObstacleType;
import Obstacles.PogoTwo;
import Obstacles.Target;
import Obstacles.policeCar;
import Player.Player;
import Sound.Sound;

/**The main game panel, this includes the game loop and all the game logic.
 * @author joshr
 *
 */
public class Background extends JPanel implements ActionListener
{
	/**
	 * timer for game loop
	 */
	private Timer timer; 
	/** player or rocketship
	 * 
	 */
	private Player p;
	
	private Obstacle obs[];
	private Target target;
	/** delay in ticks for game loop
	 * 
	 */
	private final int delay = 15;
	
	/** Will be defined later to restart and close the game.
	 * 
	 */
	private Execute e;
	/** Will be changed to a random number before every round that defines the incoming obstacle type.
	 * 
	 */
	private int type = 0;
	/** When the player loses or wins the game this will change to false, stopping the game loop
	 * 
	 */
	private boolean cont = true;
	/** Points go up with time or collection of fuel and are displayed on the top of the screen
	 * 
	 */
	private int points = 0; 
	/** Fuel bonus points that are used for statistics storage
	 * 
	 */
	private int fuelCollected=0;
	private JLabel ptCounter = new JLabel("Score: 0");
	private JLabel waveCounter = new JLabel("Round: 0 Wave: 0");
	private Image bckGrnd = new ImageIcon("background.jpg").getImage();
	private JButton fail = new JButton("You failed, press to restart and try again.");
	private JButton won = new JButton("You won! Press here to try again for a higher score!");
	private JButton menu = new JButton("Return to Menu");
	/** Goes up after every time an obstacle gets off of the screen
	 * 
	 */
	private int round = 0;
	/** goes up by one every 12 rounds
	 * 
	 */
	private int wave = 0;
	private MultiplesLogic logic;
	/** Determines what happens if a collision happens
	 * 
	 */
	private ObstacleType collisionType = null;
	/** There is a 50% chance that fuel will appear along with an obstacle
	 * 
	 */
	private Boolean addFuel=false;
	private Random random = new Random();
	/** Stores the values of the games maximum and increasing statistics
	 * 
	 */
	private int[] statistics;
	
	
	private Graphics2D g2d;
	
	/**Initializes all of the variables, starts the game loop and adds all the components to the screen
	 * 
	 */
	public Background()
	{
		addKeyListener(new TAdapter());
		setFocusable(true);
		logic = new MultiplesLogic();
		p = new Player();
		target = new Target();
		//array with all of the obstacles
		obs = new Obstacle[] {logic.getPC(),logic.getH(),logic.getPogo(),logic.getFuel(), logic.getMissile()}; 
		//adds this to every obstacle so they can use methods in this class
		for(int i =0;i<obs.length;i++)
		{
			obs[i].setBackground(this);
		}
		timer = new Timer(delay, this);
		timer.start();
		this.add(ptCounter); // adds point counter to frame
		this.add(waveCounter); // adds wave and round counter to frame
	}
	
	 /** 
	  * Draws the obstacles, background image and the player to the screen
	 */
	@Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        
	        g2d = (Graphics2D) g;

	        g2d.drawImage(bckGrnd, 0,0,this); // draws background image
	        
	        g2d.drawImage(p.getImage(), p.getX(), 
		            p.getY(), this);
	        
	        g2d.drawImage(target.getImage(), target.getX(), 
	        		target.getY(), this);
	        for(int i =0;i<obs.length;i++)
	        {
	        	g2d.drawImage(obs[i].getImage(), obs[i].getX(), 
			            obs[i].getY(), this);
	        }
	        
	        Toolkit.getDefaultToolkit().sync();
	        
	    }

	        
	    
	    /** The main game loop, all of the obstacles under the obs array are
	     *  0: police car
	     *  1: Heli
	     *  2: pogo
	     *  3: fuel
	     *
	     */
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	repaint();
	    	if (cont == true) {
	    		
	    	p.move();
	        
	        repaint(p.getX(), p.getY(), 
	                p.getWidth(), p.getHeight());    
	        
	        switch(wave)
	        {
	        case 0:
	        switch (type)
	        {
	        case 0:
	        	if(addFuel == true) {
						obs[3].move(round);
					
			        
			        repaint(obs[3].getX(), obs[3].getY(), 
			        		obs[3].getWidth(), obs[3].getHeight());  
	        	}
	        	
					obs[0].move(round);
				
		        repaint(obs[0].getX(), obs[0].getY(), 
		        		obs[0].getWidth(), obs[0].getHeight());  
		        break;
		      
	        case 1:
	        	
	        		obs[3].move(round);
				
		        
		        repaint(obs[3].getX(), obs[3].getY(), 
		        		obs[3].getWidth(), obs[3].getHeight());  
		        break;
		        
	        case 2:
	        	
					obs[1].move(round);
				
	        	((Heli)obs[1]).seekPlayer(p.getY());
	        	if(addFuel == true) {
	        		
	        			obs[3].move(round);
					
			        
			        repaint(obs[3].getX(), obs[3].getY(), 
			        		obs[3].getWidth(), obs[3].getHeight());  
	        	}
		        
		        repaint(obs[1].getX(), obs[1].getY(), 
		        		obs[1].getWidth(), obs[1].getHeight());  
		        break;
	        }
	        break;
	        case 1:
	        	switch (type)
		        {
		        case 0:
		        	
						obs[2].move(round);
					
			        repaint(obs[2].getX(), obs[2].getY(), 
			        		obs[2].getWidth(), obs[2].getHeight());  
			        break;
			      
		        case 1:
		        	
		        		obs[3].move(round);
					
			        
			        repaint(obs[3].getX(), obs[3].getY(), 
			        		obs[3].getWidth(), obs[3].getHeight());  
			        break;
			        
		        case 2:
		        	
		        	obs[1].move(round);
					
		        	((Heli)obs[1]).seekPlayer(p.getY());
		        	if(addFuel == true) {
		        		
		        			obs[3].move(round);
						
				        
				        repaint(obs[3].getX(), obs[3].getY(), 
				        		obs[3].getWidth(), obs[3].getHeight());  
		        	}
			        
			        repaint(obs[1].getX(), obs[1].getY(), 
			        		obs[1].getWidth(), obs[1].getHeight());  
			        break;
		        }
	        	break;
	        case 2:
	        	
	        	switch (type)
		        {
		        case 0:
		        	
						obs[2].move(round);
					
			        repaint(obs[2].getX(), obs[2].getY(), 
			        		obs[2].getWidth(), obs[2].getHeight());  
			        break;
			      
		        case 1:
		        	
		        		obs[4].move(round);
					
			        
			        repaint(obs[4].getX(), obs[4].getY(), 
			        		obs[4].getWidth(), obs[4].getHeight());  
			        repaint(target.getX(), target.getY(), 
			        		target.getWidth(), target.getHeight());  
			        
			        break;
			        
		        case 2:
		        	
		        	obs[1].move(round);
					
		        	((Heli)obs[1]).seekPlayer(p.getY());
		        	if(addFuel == true) {
		        		
		        			obs[0].move(round);
						
				        
				        repaint(obs[0].getX(), obs[0].getY(), 
				        		obs[0].getWidth(), obs[0].getHeight());  
		        	}
			        
			        repaint(obs[1].getX(), obs[1].getY(), 
			        		obs[1].getWidth(), obs[1].getHeight());  
			        break;
		        }
	        	break;
	        }
	        
	        
	        
	        
				collision();
			
	        points++;
	        
	        ptCounter.setText("Score: "+points);
	        waveCounter.setText("Round: "+ (round+1+wave*12) +" Wave: "+(wave+1));
	        
	        
	    	}
	        
	    }
	    /**
	     * On every repetition of the game loop this runs to find if the player collided with any
	     * obstacles and takes action based on the type
	     */
	    private void collision() 
	    {
	    	Rectangle rt = new Rectangle(p.getX(),p.getY(),p.getWidth()-15,p.getHeight()-10);
	    	/*
	    	 * uses the logic object to find if a collision with the player 
	    	 * occurred and what type of object it collided with 
	    	 */
	    	collisionType = logic.setPlayerRectangle(rt); 
	    	if (collisionType!= null) 
	    	{
	    		switch (logic.getCollisionType()) 
	    		{
	    		case POLICECAR:
	    			Sound.carCrash();
	    			try {
						endGame();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			break;
	    			
	    		case HELI,POGO,MISSILE:
	    			try {
						endGame();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			break;
	    			
	    		case FUEL:
	    			points+=300;
	    			
	    			fuelCollected+=1;
	    			((Fuel)obs[3]).hide();
	    			break;
	    		}
	    		
	    	} 

	    }
	    private void rest() // restarts game by creating new jframe and panel on the press of the button above
	    {
	    	e = (Execute) SwingUtilities.windowForComponent(this);
	    	
	    	e.restart();
	    }
	    private void returnToMenu()
	    {
	    	e = (Execute) SwingUtilities.windowForComponent(this);
	    	e.returnToMenu();
	    }
	    
	    private void endGame() throws NumberFormatException, IOException 
	    {
	    	e = (Execute) SwingUtilities.windowForComponent(this);
    		
    		this.add(fail);
    		fail.setVisible(true);
    		this.add(menu);
    		menu.setVisible(true);
    		cont = false; //stops the game loop
    		Sound.lostGame();
    		fail.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				
    				rest(); // restarts game on button press
    				
    			}
    			
    		});
    		menu.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				
    				returnToMenu(); // returns to menu on button press
    				
    			}
    			
    		});
    		setStatistics();
    
	    }
	    private void wonGame() throws NumberFormatException, IOException 
	    {
	    	e = (Execute) SwingUtilities.windowForComponent(this);
    		
    		
    		this.add(won);
    		won.setVisible(true);
    		this.add(menu);
    		menu.setVisible(true);
    		Sound.wonGame();
    		cont = false; //stops the game loop
    		won.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				
    				rest(); // restarts game on button press
    				
    			}
    			
    		});
    		menu.addActionListener(new ActionListener() {

    			@Override
    			public void actionPerformed(ActionEvent e) {
    				
    				returnToMenu(); // returns to menu on button press
    				
    			}
    			
    		});
    		setStatistics();
    
	    }
	    private void setStatistics() throws NumberFormatException, IOException
	    {
	    	statistics = StatisticsScanner.getStats(3);
	    	for (int i =0; i<statistics.length; i++)
	    	{
	    		int temp = statistics[i];
	    		switch(i)
	    		{
	    		case 0:
	    			if(points>temp) statistics[i] = points;
	    			break;
	    		case 1:  statistics[i]+=fuelCollected;
	    		break;
	    		case 2: if(wave>statistics[i]) statistics[i] = wave;
	    		}
	    		StatisticsScanner.setStats(statistics);
	    	}
	    }
	    public class TAdapter extends KeyAdapter {

	        @Override
	        public void keyReleased(KeyEvent e) {
	            p.keyReleased(e);
	        }

	        @Override
	        public void keyPressed(KeyEvent e) {
	            p.keyPressed(e);
	        }
	    }
	    public Player getPlayer() {
	    	return p;
	    }
	    public void despawnObstacle() throws NumberFormatException, IOException
	    {
	    	addFuel = random.nextBoolean();
	    	type = random.nextInt(3);
	    	
	    	if (round ==12 || round == 13)
	    	{
	    		wave++;
	    		round=0;
	    	}
	    	round++;
	    	
	    	
	    		switch(wave)
	    		{
	    		case 0:
	    	switch (type)
	        {
	    	
	        case 0:
	        	if(addFuel == true) {
	        		obs[3] = new Fuel();
	        		logic.setFuel((Fuel)obs[3]);
	        		obs[3].setBackground(this);
	        	}
	        	obs[0] = new policeCar();
	        	logic.setPC((policeCar)obs[0]);
	        	obs[0].setBackground(this);
		    	
		        break;
		      
	        case 1:
	        	obs[3]=new Fuel();
	        	logic.setFuel((Fuel)obs[3]);
	        	obs[3].setBackground(this);
	    		
		        break;
		        
	        case 2:
	        	obs[1]=new Heli();
	        	if(addFuel == true) {
	        		obs[3] = new Fuel();
	        		obs[3].setBackground(this);
	        		logic.setFuel((Fuel) obs[3]);
	        	}
	        	
	        	logic.setHeli((Heli)obs[1]);
	        	obs[1].setBackground(this);
	    		break;
	    		
	        }
	    	break;
	    		case 1:
	    	
	    		switch (type)
		        {
		        case 0:
		        	obs[2] = new PogoTwo();
		        	logic.setPogo((PogoTwo)obs[2]);
		        	obs[2].setBackground(this);
			    	
			        break;
			      
		        case 1:
		        	obs[3]=new Fuel();
		        	logic.setFuel((Fuel)obs[3]);
		        	obs[3].setBackground(this);
		    		
			        break;
			        
		        case 2:
		        	obs[1]=new Heli();
		        	if(addFuel == true) {
		        		obs[3] = new Fuel();
		        		logic.setFuel((Fuel)obs[3]);
		        		obs[3].setBackground(this);
		        	}
		        	logic.setHeli((Heli) obs[1]);
		        	obs[1].setBackground(this);
		    		
		    		break;
		        }
	    		break;
	    		case 2:
	    			switch (type)
			        {
			        case 0:
			        	target.despawn();
			        	obs[2] = new PogoTwo();
			        	logic.setPogo((PogoTwo)obs[2]);
			        	obs[2].setBackground(this);
				    	
				    	if(addFuel == true) {
				    		obs[0] = new policeCar();
			        		logic.setPC((policeCar)obs[0]);
			        		obs[0].setBackground(this);
			        	}
				        break;
				      
			        case 1:
			        	obs[4]=new Missile();
			        	logic.setMissile((Missile)obs[4]);
			        	target.setPos(0, ((Missile)obs[4]).getTY());
			        	obs[4].setBackground(this);
			        	
			    		Sound.missileWarning();
				        break;
				        
			        case 2:
			        	target.despawn();
			        	obs[1]=new Heli();
			        	if(addFuel == true) {
			        		obs[0] = new policeCar();
			        		logic.setPC((policeCar)obs[0]);
			        		obs[0].setBackground(this);
			        	}
			        	logic.setHeli((Heli)obs[1]);
			        	obs[1].setBackground(this);
			    		
			    		break;
			        }
	    			break;
	    		case 3:
	    			wonGame();
	    			
	    	}
	    	
	    }
	}