package main;

import java.awt.Color;
import java.awt.Graphics;

public class Cobra {
	
	CobraGamePanel gamePanel;
	int[] coordsX, coordsY;
	
	int x, y;
	int cobraX, cobraY;
	public String direction;
	CobraKeyListener CKL;

	Cobra(CobraGamePanel gamePanel, int[] coordsX, int[] coordsY){
		
		this.gamePanel = gamePanel;
		this.coordsX = coordsX;
		this.coordsY = coordsY;
		setDefaultValues();
		
	}
	
	public void setDefaultValues() {
		direction = "down";
		x = 0;
		y = 0;
		cobraX = coordsX[x];
		cobraY = coordsY[y];
	}
	
	public void update() {
		switch(direction) {
		case "up":
			y--;
			if(y<0) {
				y = 29;
			}
			break;
		case "down":
			y++;
			if(y>29) {
				y=0;
			}
			break;
		case "left":
			x--;
			if(x<0) {
				x=39;
			}
			break;
		case "right":
			x++;
			if(x > 39) {
				x=0;
			}
			break;
		}
		cobraX = coordsX[x];
		cobraY = coordsY[y];
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.drawRect(cobraX, cobraY, gamePanel.tileSize, gamePanel.tileSize);
	}
	
}
