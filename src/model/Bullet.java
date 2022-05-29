package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Bullet {

	private Canvas canvas;
	private GraphicsContext gc;

	private int x, y;
	private int size;
	private int speed;
	private Image image;

	public Bullet(Canvas canvas, int x, int y) {
		this.canvas = canvas;
		this.gc = canvas.getGraphicsContext2D();
		this.x = x;
		this.y = y;
		this.size = 5;
		this.speed = -6;
		File shot = new File("src/image/playerShot (1).png");
		try {
			image = new Image(new FileInputStream(shot));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void paint() {
		gc.drawImage(image, x, y);
		y += speed;
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
}
