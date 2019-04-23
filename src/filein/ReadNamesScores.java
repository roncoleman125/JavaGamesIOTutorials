package filein;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadNamesScores {
	public static void main(String[] args) {
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader("c:/tmp/highscores.txt"));
			
			String line = reader.readLine();
			
			while(line != null) {
				line = reader.readLine();
				
				String[] fields = line.split(" +");
				
				if(fields.length == 2) {
					String name = fields[0];
					
					int score = Integer.parseInt(fields[1]);
					
					System.out.println("name: "+name+" score ="+score);
				}
			}
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
