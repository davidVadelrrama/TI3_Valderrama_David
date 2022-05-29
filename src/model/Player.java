package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Player {

	private Canvas canvas;
	private GraphicsContext gc;
	
	private int x=250;
	private int y=550;
	private Image image;
	
	private ArrayList<Image> runImages;
	private ArrayList<Image> attackImages;
	
	private int state=0;
	private int frame=0;
	
	public static int puntaje;
	
	public Player(Canvas canvas) {
		this.canvas = canvas;
		puntaje = 0;
		gc = canvas.getGraphicsContext2D();
		File file = new File("src/image/playerShip (1).png");
		try {
			image = new Image(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public void paint(){
		gc.drawImage(image, x, y);
	}
	

	public void moveXBy(int i) {
		this.x += i;
	}
	
	public void moveYBy(int i) {
		this.y += i;	
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		this.frame=0;
	}


	public int getPuntaje() {
		return puntaje;
	}


	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	
	
}
