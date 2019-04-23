package fileout;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteScores {
	public static void main(String[] args) {
		int scores[] = { 99, 42, 3, 17, 12 };
		String names[] = { "RGC", "JDS", "NS", "JAY", "SW" };
		
		BufferedWriter writer;
		
		try {
			writer = new BufferedWriter(new FileWriter("c:/tmp/highscores.txt"));
			
			for(int i=0; i < scores.length; i++)
				writer.write(names[i]+" "+scores[i]);
			
			writer.flush();
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
