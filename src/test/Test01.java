package test;

import java.util.ArrayList;

import hs.HighScores;
import hs.Record;

public class Test01 {
	public static void main(String[] args) {
		HighScores highscores = new HighScores("c:/tmp/highscores.txt");
		ArrayList<Record> records = highscores.load();
		
		records.clear();
		
		records.add(new Record("RGC",1000));
		
		highscores.save();
		
		System.out.println("saved:");
		System.out.println(highscores);
		System.out.println(records.size()+" records");
		
	}
}
