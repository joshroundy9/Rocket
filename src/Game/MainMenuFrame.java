package Game;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Sound.Music;
import Sound.Sound;


public class MainMenuFrame extends JFrame {
	
	private MainMenu m;
	private Statistics s;
	private Credits credits;
	private int[] statistics;
	private int numOfStats = Statistics.numOfStats;
	private JPanel card;
	private CardLayout c;
	public MainMenuFrame() throws NumberFormatException, IOException 
	{
		s = new Statistics();
		m = new MainMenu();
		credits = new Credits();
		card = new JPanel(new CardLayout());
		card.add(m,"main");
		card.add(s,"stats");
		card.add(credits,"credits");
		add(card);
		c = (CardLayout) card.getLayout();
		c.show(card,"main");
		
		setTitle("Rocket");
		this.setSize(1000,700);
		this.setBackground(Color.BLUE);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setStats();
		new Music();
	}
	public MainMenuFrame(boolean first) throws NumberFormatException, IOException 
	{
		s = new Statistics();
		m = new MainMenu();
		credits = new Credits();
		card = new JPanel(new CardLayout());
		card.add(m,"main");
		card.add(s,"stats");
		card.add(credits,"credits");
		add(card);
		c = (CardLayout) card.getLayout();
		c.show(card,"main");
		
		setTitle("Rocket");
		this.setIconImage((new ImageIcon("edp.jpg")).getImage());
		this.setSize(1000,700);
		this.setBackground(Color.BLUE);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setStats();
		
	}
	private void setStats() throws NumberFormatException, IOException
	{
		File f = new File("statistics.txt");
		if (f.exists() == true)
		{
		 statistics = StatisticsScanner.getStats(numOfStats);
		} else
		{
			f.createNewFile();
			statistics = new int[] {0,0,0};
			StatisticsScanner.setStats(statistics);
		}
	}
	public void stop()
	{
		
		setVisible(false);
		dispose();
		System.exit(0);
	}
	public void startGame()
	{
		this.dispose();
		Execute.startGame(null);
		Sound.buttonPress();
		
	}
	public void openStatistics() throws IOException
	{
		s.update();
		c.show(card, "stats");
		Sound.buttonPress();
		
	}
	public void openCredits() throws IOException
	{
		s.update();
		c.show(card, "credits");
		Sound.buttonPress();
		
	}
	public void returnToMenu() 
	{
		c.show(card, "main");
		Sound.buttonPress();
	}
	
	
public static void main(String[] args) 
{
	EventQueue.invokeLater(() ->{
		MainMenuFrame ex;
		try {
			ex = new MainMenuFrame();
			ex.setVisible(true);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	});
}
}
