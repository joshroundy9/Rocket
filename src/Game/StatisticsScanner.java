package Game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StatisticsScanner {

	public static int[] getStats(int numOfStats) 
		{
		int[] inventory = new int[numOfStats];
		BufferedReader b;
		try {
			b = new BufferedReader(new FileReader("statistics.txt"));
			
			for(int i =0; i<numOfStats; i++)
			{
				
					inventory[i] = Integer.parseInt(b.readLine());
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return inventory;
		}
	
	public static void setStats(int[] statistics) 
	{
		File f = new File("statistics.txt");
		
		BufferedWriter b;
		try {
			b = new BufferedWriter(new FileWriter("statistics.txt"));
			for(int i = 0; i<statistics.length; i++)
			{
				b.write(""+statistics[i]);
				b.newLine();
			}
			b.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
