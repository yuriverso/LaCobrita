package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jdbc.CobraConnection;

public class CobraMenuPanel extends JPanel implements ActionListener{

	CobraFrame frame;
	JButton startButton, optionsButton, exitButton, connectionButton;
	JLabel connectionLabel, playerLabel;
	ConnectionPanel connectionPanel;
	JTextField playerField;
	
	
	CobraMenuPanel(CobraFrame frame){
		this.frame = frame;
		setPreferredSize(new Dimension(800, 600));
		setBackground(new Color(0, 30, 0));
		//setFocusable(false);
		setLayout(null);
		
		createLabelsAndButtons();

		refreshConnection();
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
		if(e.getSource() == connectionButton) {
			connectionPanel.setVisible(true);
			disableComponents();
			
		}
		if(e.getSource() == connectionPanel.closeButton) {
			connectionPanel.setVisible(false);
			enableComponents();
		}
		if(e.getSource() == connectionPanel.connectButton) {
			String url = connectionPanel.urlField.getText();
			String user = connectionPanel.userField.getText();
			String pass = connectionPanel.passField.getText();
			frame.cobraJDBC.setCon(CobraConnection.getConnection(url, user, pass));
			refreshConnection();
		}
		
	}
	
	public void createLabelsAndButtons() {
		
		connectionPanel = new ConnectionPanel(this);
		
		playerLabel = new JLabel("Player:");
		playerLabel.setBounds(290, 10, 80, 50);
		playerLabel.setFont(new Font("Arial", Font.BOLD, 20));
		playerLabel.setForeground(Color.white);
		add(playerLabel);
		
		playerField = new JTextField("alguém");
		playerField.setBounds(370, 10, 130, 50);
		playerField.setBackground(new Color(0, 51, 0, 255));
		playerField.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0)));
		playerField.setForeground(Color.white);
		playerField.setFont(new Font("Arial", Font.BOLD, 20));
		add(playerField);
		
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
		
		connectionButton = new JButton("Connection");
		connectionButton.setForeground(Color.white);
		connectionButton.setBackground(new Color(0, 51, 0, 255));
		connectionButton.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0)));
		connectionButton.setBounds(10, 10, 100, 20);
		connectionButton.setFocusable(false);
		connectionButton.addActionListener(this);
		add(connectionButton);
		
		connectionLabel = new JLabel();
		connectionLabel.setText(null);
		connectionLabel.setBounds(120, 10, 20, 20);
		connectionLabel.setBorder(BorderFactory.createLineBorder(new Color(102, 51, 0)));
		connectionLabel.setOpaque(true);
		add(connectionLabel);
		
	}
	
	public void refreshConnection() {
		if(frame.cobraJDBC.getCon() == null) connectionLabel.setBackground(Color.red);
		else connectionLabel.setBackground(Color.green);
	}
	
	public void disableComponents() {
		for(Component c : getComponents()) {
			c.setEnabled(false);
		}
	}
	
	public void enableComponents() {
		for(Component c : getComponents()) {
			c.setEnabled(true);
		}
	}
}
