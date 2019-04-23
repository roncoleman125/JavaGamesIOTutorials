package hs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HighScores {
	public String path = null;
	
	private ArrayList<Record> records = new ArrayList<>();
	
	public HighScores(String path) {
		this.path = path;
	}
	
	public ArrayList<Record> load() {
		records.clear();
		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(path));
			
			String line = reader.readLine();
			
			while(line != null) {				
				String[] fields = line.split(" +");
				
				if(fields.length == 2) {
					String name = fields[0];
					
					int score = Integer.parseInt(fields[1]);
					
					records.add(new Record(name, score));
				}
				
				line = reader.readLine();
			}
			
			reader.close();
		}
		catch(FileNotFoundException e) {
			
		}
		catch (IOException e) {
			e.printStackTrace();
			records = null;
		}

		return records;
	}
	
	public ArrayList<Record> getRecords() {
		return records;
	}
	
	public void save() {
		Collections.sort(records);
		
		BufferedWriter writer;
		
		try {
			writer = new BufferedWriter(new FileWriter(path));
			
			for(Record record: records) {
				writer.write(record.getName()+" "+record.getScore());
				writer.newLine();
			}
			
			writer.flush();
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public void clear() {
		records.clear();
	}
	
	public String toString() {
		String s = "";
		for(Record record: records)
			s += record + "\n";
		
		return s;
	}
}
