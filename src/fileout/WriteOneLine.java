package fileout;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriteOneLine {
	public static void main(String[] args) {
		BufferedWriter writer;
		
		try {
			writer = new BufferedWriter(new FileWriter("c:/tmp/highscores.txt"));
			
			writer.write("99");
			
			writer.flush();
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
