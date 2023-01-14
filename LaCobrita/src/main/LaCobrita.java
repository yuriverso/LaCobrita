package main;

import javax.swing.JFrame;

public class LaCobrita {

	
	public static void main(String[] args) {
		JFrame frame = new JFrame("La Cobrita");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		CobraGamePanel gamePanel = new CobraGamePanel();
		frame.add(gamePanel);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		gamePanel.startGameThread();
	}
	
}
