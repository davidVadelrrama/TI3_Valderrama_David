package screens;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import model.Bullet;
import model.Enemy;
import model.Player;

public class GameScreen extends BaseScreen {

	private int enemyNum = 15;
	private Player player;
	private ArrayList<Bullet> bullets;
	private ArrayList<Enemy> enemies;
	private Image image;

	public GameScreen(Canvas canvas) {
		super(canvas);
		player = new Player(canvas);
		bullets = new ArrayList<>();
		enemies = new ArrayList<>();
		int posX = 20;
		int posY = 20;
		for (int i = 1; i < enemyNum + 1; i++) {

			Enemy alien = new Enemy(canvas, posX, posY);
			posX += 100;
			alien.start();
			enemies.add(alien);
			if (i % 5 == 0) {
				posY += 80;
				posX = 20;
			}
		}
		File file = new File("src/image/background (1).png");
		try {
			image = new Image(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paint() {
		gc.drawImage(image, 0, 0);

		player.paint();

		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).paint();

			if (bullets.get(i).getX() > canvas.getWidth()) {
				bullets.remove(i);
				i--;
			}
		}

		for (int i = 0; i < enemies.size(); i++) {
			int enemySelect = 1;
			if (i % 2 == 0) {
				enemySelect = 1;
			} else {
				enemySelect = 2;
			}
			enemies.get(i).paint(enemySelect);
		}

		// Calcular distancia
		for (int i = 0; i < enemies.size(); i++) {
			for (int j = 0; j < bullets.size(); j++) {

				// Comparar
				Enemy b = enemies.get(i);
				Bullet p = bullets.get(j);
				double D = Math.sqrt(Math.pow(b.getX() - p.getX(), 2) + Math.pow(b.getY() - p.getY(), 2));

				if (D <= 40) {
					Enemy deadEnemy = enemies.remove(i);
					deadEnemy.setAlive(false);
					bullets.remove(j);
					return;
				}
			}
		}
		// Calcular distancia
		for (int i = 0; i < enemies.size(); i++) {

			// Comparar
			Enemy b = enemies.get(i);

			double prox = Math.sqrt(Math.pow(b.getX() - player.getX(), 2) + Math.pow(b.getY() - player.getY(), 2));
			if (prox <= 40) {
				return;	
			}
		}

	}

	@Override
	public void onKey(KeyEvent e) {
		if (e.getCode().equals(KeyCode.A)) {
			player.moveXBy(-10);
		} else if (e.getCode().equals(KeyCode.D)) {
			player.moveXBy(10);
		} else if (e.getCode().equals(KeyCode.SPACE)) {
			bullets.add(new Bullet(canvas, player.getX() + 55, player.getY()));
			player.setState(1);
		}

	}

}
