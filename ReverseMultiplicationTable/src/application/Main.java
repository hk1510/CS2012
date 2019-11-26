package application;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	private Button btfind = new Button("Find Problems");
	private TextField tfanswer = new TextField();
	private Label lbprompt = new Label("Enter Answer");
	private Label[][] textGrid = new Label[11][11];
	GridPane qgrid = new GridPane();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setAlignment(Pos.CENTER);
			
			HBox top = new HBox(10);
			top.getChildren().addAll(lbprompt, tfanswer, btfind);
			top.setAlignment(Pos.CENTER);
			top.setPadding(new Insets(10));
			root.add(top, 0, 0);
			
			initializeQuestions(textGrid);
			addToGrid(textGrid, qgrid);
			root.add(qgrid, 0, 1);
			qgrid.setAlignment(Pos.CENTER);
			qgrid.setPadding(new Insets(10));
			qgrid.setHgap(20);
			qgrid.setVgap(10);
			
			btfind.setOnAction(e -> findQuestion());
			
			Scene scene = new Scene(root, 800, 500);
			
			primaryStage.setResizable(false);
			primaryStage.setTitle("JavaFx Reverse Multiplication Table");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void findQuestion() {
		int enteredValue = Integer.parseInt(tfanswer.getText());
		for(int i = 1; i < 11; i++) {
			for(int j = 1; j < 11; j++) {
				((Label) qgrid.getChildren().get(11*i+j)).setTextFill(Color.BLACK);
				qgrid.getChildren().get(11*i+j).setStyle("-fx-background-color: transparent;");
				if(i*j == enteredValue) {
					qgrid.getChildren().get(11*i+j).setStyle("-fx-background-color: red;");
					((Label) qgrid.getChildren().get(11*i+j)).setTextFill(Color.YELLOW);
				}
			}
		}
	}
	
	private void initializeQuestions(Label[][] textGrid) {
		for(int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (i == 0) {
					textGrid[i][j] = new Label(Integer.toString(j));
				}
				else if (j == 0) {
					textGrid[i][j] = new Label(Integer.toString(i));
				}
				else {
					textGrid[i][j] = new Label(j + " * " + i);
				}
			}
		}
	}
	
	private void addToGrid(Label[][] textGrid, GridPane grid) {
		for(int i = 0; i < 11; i++) {
			for(int j = 0; j < 11; j++) {
				grid.add(textGrid[i][j], j, i);
				GridPane.setHalignment(qgrid.getChildren().get(11*i+j), HPos.CENTER);
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
