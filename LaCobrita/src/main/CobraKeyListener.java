package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CobraKeyListener implements KeyListener{
	
	Cobra cobra;
	
	CobraKeyListener(Cobra cobra){
		this.cobra = cobra;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		System.out.println(c);
		if(c == 'w') {
			if(cobra.direction != "down") {
				cobra.direction = "up";
			}
		}
		if(c == 'a') {
			if(cobra.direction != "right") {
				cobra.direction = "left";
			}
		}
		if(c == 's') {
			if(cobra.direction != "up") {
				cobra.direction = "down";
			}
		}
		if(c == 'd') {
			if(cobra.direction != "left") {
				cobra.direction = "right";
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
