package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Enemy extends Thread{

	private Canvas canvas;
	private GraphicsContext gc;
	
	private int x;
	private int y;
	private Image image;
	private Image image2;
	private boolean isAlive=true;
	
	@Override
	public void run() {
		while(isAlive) {
			y += 1.5;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Enemy(Canvas canvas, int x, int y) {
		this.canvas = canvas;
		this.gc = canvas.getGraphicsContext2D();
		this.x = x;
		this.y = y;
		
		File file = new File("src/image/enemigoDefinitivo (2).png");
		File file2 = new File("src/image/enemigoDefinitivo2 (1).png ");
		
		try {
			image = new Image(new FileInputStream(file));
			image2 =new Image(new FileInputStream(file2));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void paint(int enemySelect) {
		if(enemySelect == 1) {
			gc.drawImage(image, x, y);
		}else if(enemySelect == 2) {
			gc.drawImage(image2, x, y);
		}
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean getAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
