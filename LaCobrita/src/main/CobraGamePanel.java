package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CobraGamePanel extends JPanel implements Runnable{
	
	int FPS = 60;
	int speed = 5;
	final int WIDTH = 800;
	final int HEIGHT = 600;
	final int tileSize = 20;
	final int rows = WIDTH/tileSize;
	final int cols = HEIGHT/tileSize;
	final int tiles = rows*cols;
	
	int coordsX[] = new int[rows];
	int coordsY[] = new int[cols];
	
	public boolean paused = false;
	
	int score = 0;
	
	String gameMode = "free";

	//frame
	CobraFrame frame;
	
	//cobra 
	Cobra cobra;
	
	//apple
	Apple apple;
	
	//pause screen
	PausePanel pauseP;
	
	CobraKeyListener CKL;
	
	Thread gameThread;
	
	
	CobraGamePanel(CobraFrame frame){
		this.frame = frame;
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setBackground(new Color(0, 30, 0));
		this.setFocusable(true);
		setLayout(null);
		
		
		fillCoordArray();
		cobra = new Cobra(this, coordsX, coordsY);
		apple = new Apple(this, coordsX, coordsY);
		pauseP = new PausePanel(this);
		this.add(pauseP);
		
		
		CKL  = new CobraKeyListener(cobra);
		this.addKeyListener(CKL);
		
	}
	
	public void update() {
		if(paused) {
			pauseP.setVisible(true);
			
		}else {
			pauseP.setVisible(false);
			
			cobra.update();
		}
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(gameMode == "wall") {
			drawWalls(g, new Color(102, 51, 0));
		}
		if(paused) {
			apple.draw(g, new Color(80, 0, 0));
			cobra.draw(g, new Color(0, 80, 0));
			drawGrid(g, new Color(15,15,15));
			drawScore(g, new Color(60, 60, 60));
			
		}else {
			apple.draw(g, new Color(190, 0, 0));
			cobra.draw(g, new Color(0, 130, 0));
			drawGrid(g, new Color(30,30,30));
			drawScore(g, Color.white);
			
		}
		
		
		
	}
	
	public void drawGrid(Graphics g, Color color) {
		int rows = WIDTH/tileSize;
		int cols = HEIGHT/tileSize;
		
		g.setColor(color);
		for(int i = 0;i<=rows;i++) {
			g.drawLine(i*tileSize, 0, i*tileSize, HEIGHT);
		}
		for(int i = 0;i<=cols;i++) {
			g.drawLine(0, i*tileSize, WIDTH, i*tileSize);
		}
	}
	
	public void drawWalls(Graphics g, Color color) {
		g.setColor(color);
		g.fillRect(0, 0, WIDTH, tileSize);
		g.fillRect(0, 0, tileSize, HEIGHT);
		g.fillRect(WIDTH-tileSize, 0, tileSize, HEIGHT);
		g.fillRect(0, HEIGHT-tileSize, WIDTH, 20);
	}
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;

		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			
			if (delta >= 10-speed) {
				update();
				repaint();
				
				delta-=10-speed;
				cobra.timeSinceTurn++;
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
	
	public void score() {
		score += speed+1;
		apple = new Apple(this, coordsX, coordsY);
	}
	
	public void gameOver() {
		frame.gameOver();
		score = 0;
		cobra.setDefaultValues();
		setVisible(false);
		//frame.menuPanel.setVisible(true);
		gameThread.stop();	
	}
	
	public void mainMenu() {
		frame.mainMenu();
		score = 0;
		cobra.setDefaultValues();
		gameThread.stop();
	}

	public void drawScore(Graphics g, Color color) {
		g.setColor(color);
		g.setFont(new Font(getFont().getName(), Font.PLAIN, 20));
		g.drawString(String.valueOf(score), 760, 20);
	}
	
}
