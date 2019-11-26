package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Main extends Application {
	TextField[][] randomGrid = new TextField[10][10];
	GridPane random = new GridPane();
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Button button = new Button("Randomize");
			button.setOnAction(e -> buttonClick());
			root.setTop(button);
			root.setCenter(random);
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void buttonClick() {
		for (int i = 0; i < 10; i++) {
			for(int j = 0; j < 10 ; j++) {
				randomGrid[i][j] = new TextField(Integer.toString((int) Math.round(Math.random())));
				randomGrid[i][j].setEditable(false);
				random.add(randomGrid[i][j], j, i);
			}
		}
	}
	
}