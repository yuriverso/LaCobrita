package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PausePanel extends JPanel implements ActionListener{

	CobraGamePanel gamePanel;
	JButton goOnButton, toMenuButton, exitButton;
	
	PausePanel(CobraGamePanel gamePanel){
		this.gamePanel = gamePanel;
		
		setBounds(200, 100, 400, 400);
		setBackground(new Color(0,0,0,0));
		setVisible(false);
		setLayout(null);
		setOpaque(false);

		createButtons();
		
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
	
	public void createButtons() {
		goOnButton = new JButton("Continue");
		Font font = new Font(goOnButton.getFont().getName(), Font.BOLD, 32);
		goOnButton.setFont(font);
		goOnButton.setForeground(Color.white);
		goOnButton.setBackground(new Color(0, 51, 0, 255));
		goOnButton.setHorizontalAlignment(JLabel.CENTER);
		goOnButton.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0)));
		goOnButton.setBounds(50, 50, 300, 100);
		goOnButton.setFocusable(false);
		goOnButton.addActionListener(this);
		add(goOnButton);
		
		toMenuButton = new JButton("Main Menu");
		toMenuButton.setFont(font);
		toMenuButton.setForeground(Color.white);
		toMenuButton.setBackground(new Color(0, 51, 0, 255));
		toMenuButton.setHorizontalAlignment(JLabel.CENTER);
		toMenuButton.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0)));
		toMenuButton.setBounds(50, 150, 300, 100);
		toMenuButton.setFocusable(false);
		toMenuButton.addActionListener(this);
		add(toMenuButton);
		
		exitButton = new JButton("Exit");
		exitButton.setFont(font);
		exitButton.setForeground(Color.white);
		exitButton.setBackground(new Color(0, 51, 0, 255));
		exitButton.setHorizontalAlignment(JLabel.CENTER);
		exitButton.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0)));
		exitButton.setBounds(50, 250, 300, 100);
		exitButton.setFocusable(false);
		exitButton.addActionListener(this);
		add(exitButton);
	}
	
}
