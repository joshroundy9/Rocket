package Game;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class Credits extends JPanel{
	private MainMenuFrame frame;
	private JLabel credit = new JLabel("All sounds used are from zapsplat.com, and all images and assets are royalty free.");
	private JButton menu = new JButton("Return to menu");
	private ImageIcon background = new ImageIcon("mainbackground.jpg");
	public Credits()
	{
		add(credit);
		add(menu);
		addListener();
	}
	public void addListener()
	{
		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				backToMenu(); 
				
			}
			
		});
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
