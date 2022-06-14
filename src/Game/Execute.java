package Game;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;

import Sound.Sound;

public class Execute extends JFrame {
	
	Background b;
	Execute ex;
	private int[] statistics;
	private int numOfStats =3;
	public Execute() 
	{
		b = new Background();
		add(b);
		setTitle("Rocket");
		this.setSize(1000,800);
		this.setBackground(Color.BLUE);
		
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void restart()
	{
		this.remove(b);
		this.dispose();
		Sound.buttonPress();
		startGame(null);
	}
	public void stop()
	{
		
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	
	public void returnToMenu() 
	{
		dispose();
		Sound.buttonPress();
		try {
			MainMenuFrame m = new MainMenuFrame(true);
			m.setVisible(true);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public static void startGame(String[] args) 
{
	EventQueue.invokeLater(() ->{
		Execute ex = new Execute();
		ex.setVisible(true);
	});
}

}
