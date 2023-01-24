package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PausePanel extends JPanel implements ActionListener{

	CobraGamePanel gamePanel;
	JButton goOn, toMenu;
	
	PausePanel(CobraGamePanel gamePanel){
		this.gamePanel = gamePanel;
		
		setBounds(200, 100, 400, 400);
		setBackground(Color.CYAN);
		setVisible(false);
		setLayout(null);
		//setFocusable(false);
		
		goOn = new JButton("Continue");
		goOn.setBounds(50, 50, 300, 100);
		goOn.setFocusable(false);
		goOn.addActionListener(this);
		add(goOn);
		
		toMenu = new JButton("Main Menu");
		toMenu.setBounds(50, 150, 300, 100);
		toMenu.setFocusable(false);
		toMenu.addActionListener(this);
		add(toMenu);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == goOn) {
			gamePanel.paused = false;
		}
		if(e.getSource() == toMenu) {
			gamePanel.mainMenu();
			
		}
		
	}
	
}
