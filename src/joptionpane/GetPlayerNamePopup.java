package joptionpane;

import javax.swing.JOptionPane;

public class GetPlayerNamePopup {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("Enter your name");
		System.out.println(name);
	}
}
