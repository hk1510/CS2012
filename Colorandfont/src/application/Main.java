package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Text[] javafxtext = new Text[5];
			GridPane root = new GridPane();
			root.setAlignment(Pos.CENTER);
			for (int i = 0; i< javafxtext.length; i++) {
				javafxtext[i] = new Text("JavaFx");
				javafxtext[i].setRotate(90);
				javafxtext[i].setStroke(new Color(Math.random(), Math.random(), Math.random(), Math.random()));
				javafxtext[i].setFont(Font.font("Times New Roman", 50));
				root.add(javafxtext[i], i, 0);
			}	
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
