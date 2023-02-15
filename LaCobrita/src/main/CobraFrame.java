package main;

import javax.swing.JFrame;

import jdbc.CobraConnection;
import jdbc.CobraJDBC;

public class CobraFrame extends JFrame{
	
	CobraGamePanel gamePanel;
	CobraMenuPanel menuPanel;
	CobraOptionsPanel opsPanel;
	CobraGOPanel goPanel;
	CobraJDBC cobraJDBC;

	CobraFrame(){
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("La Cobrita");
		
		cobraJDBC = new CobraJDBC(CobraConnection.getConnection());
		
		menuPanel = new CobraMenuPanel(this);
		goPanel = new CobraGOPanel(this);
		gamePanel = new CobraGamePanel(this);
		opsPanel = new CobraOptionsPanel(this);
		
		add(menuPanel);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public void gameOver() {
		menuPanel.setVisible(false);
		goPanel.setVisible(true);
		goPanel.scoreLabel.setText("Score: "+gamePanel.score);
		remove(goPanel);
		add(goPanel);
	}
	
	public void mainMenu() {
		menuPanel.setVisible(true);
		goPanel.setVisible(false);
		gamePanel.setVisible(false);
		add(menuPanel);
	}
	
}
