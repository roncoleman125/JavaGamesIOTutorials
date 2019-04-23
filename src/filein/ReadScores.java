package filein;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadScores {
	public static void main(String[] args) {
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader("c:/tmp/highscores.txt"));
			
			String line = reader.readLine();
			
			while(line != null) {				
				int score = Integer.parseInt(line);
				
				System.out.println(score);
				
				line = reader.readLine();
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
