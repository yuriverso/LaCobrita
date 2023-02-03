package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PausePanel extends JPanel implements ActionListener{

	CobraGamePanel gamePanel;
	JButton goOnButton, toMenuButton, exitButton;
	
	PausePanel(CobraGamePanel gamePanel){
		this.gamePanel = gamePanel;
		
		setBounds(200, 100, 400, 400);
		setBackground(Color.CYAN);
		setVisible(false);
		setLayout(null);
		//setFocusable(false);
		
		goOnButton = new JButton("Continue");
		goOnButton.setBounds(50, 50, 300, 100);
		goOnButton.setFocusable(false);
		goOnButton.addActionListener(this);
		add(goOnButton);
		
		toMenuButton = new JButton("Main Menu");
		toMenuButton.setBounds(50, 150, 300, 100);
		toMenuButton.setFocusable(false);
		toMenuButton.addActionListener(this);
		add(toMenuButton);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(50, 250, 300, 100);
		exitButton.setFocusable(false);
		exitButton.addActionListener(this);
		add(exitButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == goOnButton) {
			gamePanel.paused = false;
		}
		if(e.getSource() == toMenuButton) {
			gamePanel.mainMenu();
			gamePanel.paused = false;
		}
		if(e.getSource() == exitButton) {
			System.exit(0);
			
		}
		
	}
	
}
