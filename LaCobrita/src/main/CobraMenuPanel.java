package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CobraMenuPanel extends JPanel implements ActionListener{

	CobraFrame frame;
	JButton startButton, optionsButton, exitButton;
	

	
	CobraMenuPanel(CobraFrame frame){
		this.frame = frame;
		setPreferredSize(new Dimension(800, 600));
		setBackground(Color.black);
		//setFocusable(false);
		setLayout(null);
		
		startButton = new JButton("Start");
		startButton.setBounds(50,100, 700, 100);
		startButton.addActionListener(this);
		add(startButton);
		
		optionsButton = new JButton("Options");
		optionsButton.setBounds(50,250, 700, 100);
		optionsButton.addActionListener(this);
		add(optionsButton);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(50,400, 700, 100);
		exitButton.addActionListener(this);
		add(exitButton);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			setVisible(false);
			frame.add(frame.gamePanel);
			frame.gamePanel.setVisible(true);
			frame.gamePanel.requestFocus();
			frame.gamePanel.startGameThread();
		}
		if(e.getSource() == optionsButton) {
			setVisible(false);
			frame.remove(frame.opsPanel);
			frame.add(frame.opsPanel);
			frame.opsPanel.setVisible(true);
		}
		if(e.getSource() == exitButton) {
			System.exit(0);
		}
		
	}
	
}
