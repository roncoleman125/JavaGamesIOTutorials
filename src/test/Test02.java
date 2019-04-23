/*
 Copyright 2014 Ron Coleman

 Permission is hereby granted, free of charge, to any person obtaining
 a copy of this software and associated documentation files (the
 "Software"), to deal in the Software without restriction, including
 without limitation the rights to use, copy, modify, merge, publish,
 distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to
 the following conditions:

 The above copyright notice and this permission notice shall be
 included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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
		
		int count = highscores.save();
		
		System.out.println("saved:");
		System.out.println(highscores);
		System.out.println(count+" records");

		String allSaved = count == records.size() ? "YES" : "no";
		System.out.println("all saved: "+allSaved);
		
	}
}
