package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CobraMenuPanel extends JPanel implements ActionListener{

	CobraFrame frame;
	JButton startButton, optionsButton, exitButton;
	

	
	CobraMenuPanel(CobraFrame frame){
		this.frame = frame;
		setPreferredSize(new Dimension(800, 600));
		setBackground(new Color(0, 30, 0));
		//setFocusable(false);
		setLayout(null);
		
		createLabelsAndButtons();

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			frame.gamePanel.pauseP.setVisible(false);
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
	
	public void createLabelsAndButtons() {
		startButton = new JButton("Start");
		Font font = new Font(startButton.getFont().getName(), Font.BOLD, 32);
		startButton.setFont(font);
		startButton.setForeground(Color.white);
		startButton.setBackground(new Color(0, 51, 0, 255));
		startButton.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0)));
		startButton.setBounds(150,100, 500, 100);
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		add(startButton);
		
		optionsButton = new JButton("Options");
		optionsButton.setFont(font);
		optionsButton.setForeground(Color.white);
		optionsButton.setBackground(new Color(0, 51, 0, 255));
		optionsButton.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0)));
		optionsButton.setBounds(150,250, 500, 100);
		optionsButton.setFocusable(false);
		optionsButton.addActionListener(this);
		add(optionsButton);
		
		exitButton = new JButton("Exit");
		exitButton.setFont(font);
		exitButton.setForeground(Color.white);
		exitButton.setBackground(new Color(0, 51, 0, 255));
		exitButton.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0)));
		exitButton.setBounds(150,400, 500, 100);
		exitButton.setFocusable(false);
		exitButton.addActionListener(this);
		add(exitButton);
	}
	
}
