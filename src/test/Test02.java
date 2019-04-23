package test;

import java.util.ArrayList;

import hs.HighScores;
import hs.Record;

public class Test02 {
	public static void main(String[] args) {
		HighScores highscores = new HighScores("c:/tmp/highscores.txt");
		ArrayList<Record> records = highscores.load();
		
		records.clear();
		
		int scores[] = { 99, 42, 3, 17, 12 };
		String names[] = { "RGC", "JDS", "NS", "JAY", "SW" };
		
		for(int k=0; k < names.length; k++)
			records.add(new Record(names[k],scores[k]));
		
		highscores.save();
		
		System.out.println("saved:");
		System.out.println(highscores);
		System.out.println(records.size()+" records");
		
	}
}
