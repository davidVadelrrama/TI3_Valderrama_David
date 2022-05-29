package screens;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Player;

public class WinScreen extends BaseScreen {

	
	private Image image;
	private GraphicsContext gc;
	
	public WinScreen(Canvas canvas) {
		super(canvas);
		gc = canvas.getGraphicsContext2D();
		File file = new File("src/image/background (1).png");
		try {
			image = new Image(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint() {
		gc.drawImage(image, 0, 0);
		
		gc.setFont(new Font("Berlin Sans FB", 50));
		gc.setFill(Color.YELLOW);
		gc.fillText("YOU WON", 150, 50);

		gc.setFont(new Font("Berlin Sans FB", 30));
		gc.fillText("Su puntaje es", 155, 150);

		gc.setFont(new Font("Berlin Sans FB", 30));
		gc.setFill(Color.WHITE);
		gc.fillText(Integer.toString(Player.puntaje), 155, 180);
		
		gc.setFill(Color.YELLOW);
		gc.fillText("Press *esc* to exit game", 155, 210);
		
	}

	@Override
	public void onKey(KeyEvent e) {
		if (e.getCode().equals(KeyCode.ESCAPE)) {
			System.exit(0);
		}
		
	}

}
