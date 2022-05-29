package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import screens.BaseScreen;
import screens.FinishScreen;
import screens.GameScreen;
import screens.WinScreen;



public class MainWindowControl implements Initializable{
	@FXML
	private Canvas canvas;
	private GraphicsContext gc;
	
	public static int SCREEN = 0;
	public static long FRAMES = 0;
	
	private ArrayList<BaseScreen> screens;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		screens = new ArrayList<>();
		
		screens.add(new GameScreen(canvas));
		screens.add(new FinishScreen(canvas));
		screens.add(new WinScreen(canvas));
	
	
		gc = canvas.getGraphicsContext2D();
		canvas.setFocusTraversable(true);
		
		new Thread(() -> {
			while (true) {
				Platform.runLater(()->{
					paint();
				});
				pause(50);
				FRAMES++;
			}
		}).start();
		
		
		
		initEvents();
	}
	
	private void paint() {
		screens.get(SCREEN).paint();
	}

	public void initEvents() {
		
		canvas.setOnKeyPressed(e -> {
			screens.get(SCREEN).onKey(e);	
		});
		
	}

	private void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
