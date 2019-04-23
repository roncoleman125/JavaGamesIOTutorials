package test;

import java.util.ArrayList;

import hs.HighScores;
import hs.Record;

public class Test00 {
	public static void main(String[] args) {
		HighScores highscores = new HighScores("c:/tmp/highscores.txt");
		ArrayList<Record> records = highscores.load();
		
		System.out.println("loaded:");
		System.out.println(highscores);
		System.out.println(records.size()+" records");
	}
}
