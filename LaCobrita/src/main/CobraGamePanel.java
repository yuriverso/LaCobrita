package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CobraGamePanel extends JPanel implements Runnable{
	
	int WIDTH = 800;
	int HEIGHT = 600;
	int cobraX, cobraY, cobraWidth, cobraHeight;
	int FPS = 60;
	String direction;
	
	CobraKeyListener CKL = new CobraKeyListener(this);
	Thread gameThread;
	
	
	CobraGamePanel(){
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(CKL);

		setDefaultValues();
		
	}
	public void update() {
		switch(direction) {
		case "up":
			cobraY -= 3;
			if(cobraY <= 0 - cobraHeight) {
				cobraY = HEIGHT;
			}
			break;
		case "down":
			cobraY += 3;
			if(cobraY >= HEIGHT + cobraHeight) {
				cobraY = -cobraHeight;
			}
			break;
		case "left":
			cobraX -= 3;
			if(cobraX <= 0 - cobraWidth) {
				cobraX = WIDTH + cobraWidth;
			}
			break;
		case "right":
			cobraX += 3;
			if(cobraX >= WIDTH + cobraWidth) {
				cobraX = -cobraWidth;
			}
			break;
		}
	}
	
	public void setDefaultValues() {
		cobraWidth = 40;
		cobraHeight = 40;
		cobraX = cobraWidth * 3;
		cobraY = cobraHeight * 3;
		direction = "down";
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(30,30,30));
		drawGrid(g);
		g.setColor(Color.green);
		g.drawRect(cobraX, cobraY, cobraWidth, cobraHeight);
	}
	
	public void drawGrid(Graphics g) {
		int rows = WIDTH/cobraWidth;
		int cols = HEIGHT/cobraHeight;
		
		for(int i = 0;i<=rows;i++) {
			g.drawLine(i*cobraWidth, 0, i*cobraWidth, HEIGHT);
		}
		for(int i = 0;i<=cols;i++) {
			g.drawLine(0, i*cobraHeight, WIDTH, i*cobraHeight);
		}
	}
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		//show fps
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if (delta >= 1) {
				update();
				repaint();
				
				delta--;
				drawCount++;
			}
			
			if(timer >= 1000000000) {
				System.out.println("FPS: "+drawCount);
				drawCount = 0;
				timer = 0;
			}

		}
		
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
}
