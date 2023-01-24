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
	JButton startButton, button1, button2, button3;
	

	
	CobraMenuPanel(CobraFrame frame){
		this.frame = frame;
		setPreferredSize(new Dimension(800, 600));
		setBackground(Color.black);
		//setFocusable(false);
		setLayout(null);
		
		startButton = new JButton("Start");
		startButton.setBounds(50,100, 700, 400);
		startButton.addActionListener(this);
		add(startButton);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			setVisible(false);
			frame.remove(frame.gamePanel);
			frame.gamePanel = new CobraGamePanel(frame);
			frame.add(frame.gamePanel);
			frame.gamePanel.setVisible(true);
			frame.gamePanel.requestFocus();
			frame.gamePanel.startGameThread();
		}
		
	}
	
}
