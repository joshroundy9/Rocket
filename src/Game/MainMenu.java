package Game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class MainMenu extends JPanel {
	
	private MainMenuFrame e;
	
	
	private JButton play = new JButton("Start Game");
	private JButton statistics = new JButton("Stastics");
	private JButton credits = new JButton("Credits");
	private JButton quit = new JButton("Quit to Desktop");
	private JLabel instructions = new JLabel("Avoid incoming attackers, collect extra fuel for bonus points, make it through all 36 rounds to win.");
	private ImageIcon background = new ImageIcon("mainbackground.jpg");

	
	public MainMenu()
	{
		this.setLayout(new GridLayout(25,7,5,5));
		setFocusable(true);
		instructions.setFont(new Font("SansSerif", Font.PLAIN,18));
		
		this.add(play);
		this.add(statistics);
		this.add(credits);
		this.add(quit);
		this.add(instructions);
		addListener();
		
	}
	
	private void addListener()
	{
		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				startGame(); // restarts game on button press
				
			}
			
		});
		statistics.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * TODO ADD STATISTICS MENU WITH ALL TIME BEST SCORE, AVERAGE SCORE AND TOTAL FUEL COLLECTED
				 */
				
				try {
					openStats();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		credits.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * TODO ADD STATISTICS MENU WITH ALL TIME BEST SCORE, AVERAGE SCORE AND TOTAL FUEL COLLECTED
				 */
				
				try {
					openCredits();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				quitGame(); // quits game on button press
				
			}
			
		});
	}
	private void quitGame()
	{
		e = (MainMenuFrame) SwingUtilities.windowForComponent(this);
    	e.stop();
    	
	}
	private void openStats() throws IOException
	{
		e = (MainMenuFrame) SwingUtilities.windowForComponent(this);
    	e.openStatistics();
	}
	private void openCredits() throws IOException
	{
		e = (MainMenuFrame) SwingUtilities.windowForComponent(this);
    	e.openCredits();
	}
	private void startGame()
	{
		e = (MainMenuFrame) SwingUtilities.windowForComponent(this);
		e.startGame();
	}
	/**
	 * draws background
	 */
	public void paintComponent(Graphics g) {

		    super.paintComponent(g);
		        g.drawImage(background.getImage(), 0, -25, null);
	}
	
	
}
