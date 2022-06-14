package Sound;

import java.util.Timer;
import java.util.TimerTask;


public class Music {
	public Music()
	{
		Sound.backgroundMusic();
		Timer t = new Timer();
		t.schedule(new Replay(), 180*1000 );
	}
	class Replay extends TimerTask
	{
		public void run()
		{
			Sound.backgroundMusic();
		}
	}
}
