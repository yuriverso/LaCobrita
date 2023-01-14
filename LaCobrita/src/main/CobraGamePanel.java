package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class CobraGamePanel extends JPanel implements Runnable{
	
	int FPS = 60;
	int speed = 4;
	
	final int WIDTH = 800;
	final int HEIGHT = 600;
	final int tileSize = 20;
	
	final int rows = WIDTH/tileSize;
	final int cols = HEIGHT/tileSize;
	final int tiles = rows*cols;
	
	int coordsX[] = new int[rows];
	int coordsY[] = new int[cols];
	
	//cobra 
	Cobra cobra;
	
	//apple
	Apple apple;
	
	CobraKeyListener CKL;
	
	
	Thread gameThread;
	
	
	CobraGamePanel(){
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		
		
		fillCoordArray();
		cobra = new Cobra(this, coordsX, coordsY);
		apple = new Apple(this, coordsX, coordsY);
		
		CKL  = new CobraKeyListener(cobra);
		this.addKeyListener(CKL);
		
	}
	
	public void update() {
		cobra.update();
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawGrid(g);
		
		apple.draw(g);
		cobra.draw(g);
		
	}
	
	public void drawGrid(Graphics g) {
		int rows = WIDTH/tileSize;
		int cols = HEIGHT/tileSize;
		
		g.setColor(new Color(30,30,30));
		for(int i = 0;i<=rows;i++) {
			g.drawLine(i*tileSize, 0, i*tileSize, HEIGHT);
		}
		for(int i = 0;i<=cols;i++) {
			g.drawLine(0, i*tileSize, WIDTH, i*tileSize);
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
			
			if (delta >= 10-speed) {
				update();
				repaint();
				
				delta-=10-speed;
				drawCount++;
			}
			
			if(timer >= 1000000000) {
				//System.out.println("FPS: "+drawCount);
				drawCount = 0;
				timer = 0;
			}

		}
		
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void fillCoordArray() {
		
		for(int i = 0; i<rows; i++) {
			coordsX[i] = i*tileSize;
		}
		
		for(int i = 0; i<cols; i++) {
			coordsY[i] = i*tileSize;
		}
		
	}
	
	public void printC() {
		for(int i : coordsX) {
			
		}
	}
	
}
