package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CobraKeyListener implements KeyListener{
	
	CobraGamePanel gamePanel;
	
	CobraKeyListener(CobraGamePanel gamePanel){
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		System.out.println(c);
		if(c == 'w') {
			if(gamePanel.direction != "down") {
				gamePanel.direction = "up";
			}
		}
		if(c == 'a') {
			if(gamePanel.direction != "right") {
				gamePanel.direction = "left";
			}
		}
		if(c == 's') {
			if(gamePanel.direction != "up") {
				gamePanel.direction = "down";
			}
		}
		if(c == 'd') {
			if(gamePanel.direction != "left") {
				gamePanel.direction = "right";
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
