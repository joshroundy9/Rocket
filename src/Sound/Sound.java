package Sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Sound {
	
	private final static String failSound = "failsound.wav", wonSound = "wongame.wav", carCrash = "carcrash.wav", 
			buttonSound = "button.wav", missileWarningSound="missile1.wav", pogoBounce = "pogobounce.wav"
			,backgroundMusic = "backgroundmusic.wav",fuelUp = "fuel.wav";
	
	
	public static synchronized void backgroundMusic()
	{
		playSound(backgroundMusic);
	}
	
	public static synchronized void lostGame()
	{
		playSound(failSound);
	}
	
	public static synchronized void carCrash()
	{
		playSound(carCrash);
	}
	public static synchronized void wonGame()
	{
		playSound(wonSound);
	}
	public static synchronized void buttonPress()
	{
		playSound(buttonSound);
	}
	public static synchronized void missileWarning()
	{
		playSound(missileWarningSound);
	}
	public static synchronized void pogoBounce()
	{
		playSound(pogoBounce);
	}
	public static synchronized void fuelUp()
	{
		playSound(fuelUp);
	}
	public static synchronized void playSound(String filepath)
	{
		AudioInputStream audioInputStream;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
