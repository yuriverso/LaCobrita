package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CobraGOPanel extends JPanel implements ActionListener{
	
	CobraFrame frame;
	JLabel gameOverLabel, scoreLabel;
	JButton restartButton, mainMenuButton, exitButton;
	
	CobraGOPanel(CobraFrame frame){
		this.frame = frame;
		setPreferredSize(new Dimension(800, 600));
		setBounds(0,0,800,600);
		setBackground(new Color(0, 30, 0));
		setLayout(null);
		
		createButtons();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == restartButton) {
			setVisible(false);
			frame.remove(frame.gamePanel);
			frame.add(frame.gamePanel);
			frame.gamePanel.setVisible(true);
			frame.gamePanel.requestFocus();
			frame.gamePanel.startGameThread();
		}
		if(e.getSource() == mainMenuButton) {
			frame.mainMenu();
		}
		if(e.getSource() == exitButton) {
			System.exit(0);
		}
	}
	
	public void createButtons() {
		gameOverLabel = new JLabel("Game Over!");
		Font font = new Font(gameOverLabel.getFont().getName(), Font.BOLD, 32);
		Font font2 = new Font(gameOverLabel.getFont().getName(), Font.BOLD, 52);
		gameOverLabel.setFont(font2);
		gameOverLabel.setForeground(Color.white);
		gameOverLabel.setHorizontalAlignment(JLabel.CENTER);
		gameOverLabel.setBounds(150,30, 500, 100);
		add(gameOverLabel);
		
		scoreLabel = new JLabel();
		scoreLabel.setFont(font2);
		scoreLabel.setForeground(Color.white);
		scoreLabel.setHorizontalAlignment(JLabel.CENTER);
		scoreLabel.setBounds(150,180, 500, 100);
		add(scoreLabel);
		
		restartButton = new JButton("Restart");
		restartButton.setFont(font);
		restartButton.setForeground(Color.white);
		restartButton.setBackground(new Color(0, 51, 0, 255));
		restartButton.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0)));
		restartButton.setBounds(80,420,200,150);
		restartButton.setFocusable(false);
		restartButton.addActionListener(this);
		add(restartButton);
		
		mainMenuButton = new JButton("Main Menu");
		mainMenuButton.setFont(font);
		mainMenuButton.setForeground(Color.white);
		mainMenuButton.setBackground(new Color(0, 51, 0, 255));
		mainMenuButton.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0)));
		mainMenuButton.setBounds(300,420,200,150);
		mainMenuButton.setFocusable(false);
		mainMenuButton.addActionListener(this);
		add(mainMenuButton);
		
		exitButton = new JButton("Exit");
		exitButton.setFont(font);
		exitButton.setForeground(Color.white);
		exitButton.setBackground(new Color(0, 51, 0, 255));
		exitButton.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0)));
		exitButton.setBounds(520,420,200,150);
		exitButton.setFocusable(false);
		exitButton.addActionListener(this);
		add(exitButton);
	}
	

}
