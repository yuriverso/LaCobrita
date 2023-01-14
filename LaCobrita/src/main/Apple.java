package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Apple {
	
	CobraGamePanel gamePanel;
	
	Random random = new Random();
	
	int appleX, appleY;
	int[] coordsX, coordsY;
	
	Apple(CobraGamePanel gamePanel, int[] coordsX, int[] coordsY){
		this.gamePanel = gamePanel;
		this.coordsX = coordsX;
		this.coordsY = coordsY;
		appleX = random.nextInt(40);
		appleY = random.nextInt(30);
		
	}
	
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.drawRect(coordsX[appleX], coordsY[appleY], gamePanel.tileSize, gamePanel.tileSize);
	}
	
	
}
