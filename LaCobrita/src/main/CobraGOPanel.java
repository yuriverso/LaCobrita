package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CobraGOPanel extends JPanel implements ActionListener{
	
	CobraFrame frame;
	JButton restartButton;
	
	CobraGOPanel(CobraFrame frame){
		this.frame = frame;
		setPreferredSize(new Dimension(800, 600));
		setBounds(0,0,800,600);
		setBackground(Color.black);
		setLayout(null);
		
		restartButton = new JButton("Restart");
		restartButton.setBounds(250,150,300,300);
		restartButton.addActionListener(this);
		add(restartButton);
		
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
		
	}
	

}
