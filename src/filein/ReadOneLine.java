package filein;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadOneLine {
	public static void main(String[] args) {
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader("c:/tmp/highscores.txt"));
			
			String line = reader.readLine();
			
			if (line != null)
				System.out.println(line);
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
