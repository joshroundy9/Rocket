package Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class Statistics extends JPanel{
	
	private JLabel highScore, timePlayed, fuelCollected;
	private JButton returnToMenu = new JButton("Return to Menu");
	private MainMenuFrame frame;
	public static int numOfStats = 3;
	private int[] statistics;
	private ImageIcon background = new ImageIcon("statsbackground.jpg");
	
	
	public Statistics()
	{
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		try {
			statistics = StatisticsScanner.getStats(numOfStats);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		
		highScore = new JLabel("Your all time high score is: "+statistics[0]);
		timePlayed = new JLabel("Your highest reached wave is "+(statistics[2]+1)+".");
		fuelCollected = new JLabel("You've collected "+statistics[1]+ " total fuel cans.");
		highScore.setForeground(Color.WHITE); 
		timePlayed.setForeground(Color.WHITE); 
		fuelCollected.setForeground(Color.WHITE); 
		c.ipadx=0;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0; c.weightx = 0.5; c.weighty = 0.0; c.gridwidth = 2; c.anchor = GridBagConstraints.PAGE_END; c.insets = new Insets(100,0,55,5); c.gridx = 0; c.gridy = 0;
		this.add(highScore,c);
		c.gridy =1;
		this.add(fuelCollected,c);
		c.gridy =2;
		this.add(timePlayed,c);
		
		c.ipady = 20;
				c.weightx = 0.0;
				
				c.gridx = 0;
				c.gridy = 3;
				c.insets = new Insets(100,0,0,95);
		
		this.add(returnToMenu,c);
		this.setVisible(true);
		this.setFocusable(true);
		addListener();
	}
	public void addListener()
	{
		returnToMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				backToMenu(); 
				
			}
			
		});
	}
	public void update() throws NumberFormatException, IOException
	{
		statistics = StatisticsScanner.getStats(numOfStats);
		 highScore.setText("Your all time high score is: "+statistics[0]);
		timePlayed.setText("Your highest reached wave is "+(statistics[2]+1)+".");
		fuelCollected.setText("You've collected "+statistics[1]+ " total fuel bonus points.");
	}
	public void backToMenu()
	{
		
		frame = (MainMenuFrame) SwingUtilities.windowForComponent(this);
		frame.returnToMenu();
		
	}
	public void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(background.getImage(), 0, -25, null);
}
	

}
