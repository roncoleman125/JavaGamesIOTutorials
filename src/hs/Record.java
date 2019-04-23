package hs;

public class Record implements Comparable<Record> {
	protected String name;
	protected int score;
	
	public Record(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}

	@Override
	public int compareTo(Record record) {	
		return record.score - this.score;
	}
	
	@Override
	public String toString() {
		return name + " " + score;
	}
}
