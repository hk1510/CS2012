package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class Main extends Application {
	BorderPane root = new BorderPane();
	GridPane mainMenu = new GridPane();
	AttackMonitor monitor = new AttackMonitor();
	@Override
	public void start(Stage primaryStage) {
		
		Button document = new Button("Document a new attack");
		Button getinfo = new Button("Get information on all of the attacks");
	    Button output = new Button("Output data to a CSV file");
		Button read = new Button("Read data from a CSV file");
	    Button damage = new Button("Get total and mean damage");
		Button attacks = new Button("Get number of attacks by different monsters");
		Button earliest = new Button("Get information on the earliest attack");
		Button quit = new Button("Quit");
		
		try {
			
			Label title = new Label("Attack Monitor");
			title.setFont(new Font("Arial", 20));
			mainMenu.add(title, 0, 0);
			mainMenu.add(document, 0, 1);
			mainMenu.add(getinfo, 0, 2);
			mainMenu.add(output, 0, 3);
			mainMenu.add(read, 0, 4);
			mainMenu.add(damage, 0, 5);
			mainMenu.add(attacks, 0, 6);
			mainMenu.add(earliest, 0, 7);
			mainMenu.add(quit, 0, 8);
			mainMenu.setAlignment(Pos.CENTER);
			
			mainMenu.setVgap(10);
			for(int i = 0; i < mainMenu.getChildren().size(); i++) {
				GridPane.setHalignment(mainMenu.getChildren().get(i), HPos.CENTER);
			}
			for(int i = 1; i < mainMenu.getChildren().size(); i++) {
				((Button)mainMenu.getChildren().get(i)).setMinWidth(350);
			}
			
			
			document.setOnAction(e -> reportAttacks());
			getinfo.setOnAction(e -> showAttacks());
			output.setOnAction(e -> writeToCSV());
			read.setOnAction(e ->  readFromCSV());
			damage.setOnAction(e -> showDamages());
			attacks.setOnAction(e -> showMonsters());
			earliest.setOnAction(e -> findEarliestAttack());
			quit.setOnAction(e -> System.exit(0));
			
			root.setCenter(mainMenu);
			Scene scene = new Scene(root,800,400);
			primaryStage.setTitle("Attack Monitor");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reportAttacks() {

		Label namelb = new Label("Name of Monster: ");
		TextField nametf = new TextField();
		Label citylb = new Label("City the attack took place in: ");
		TextField citytf = new TextField();
		Label damagelb = new Label("Damage in Millions (USD): ");
		TextField damagetf = new TextField();
		Label datelb = new Label("Date of Attack (MM/DD/YYYY): ");
		TextField datetf = new TextField("MM/DD/YYYY");
		Button reportbt = new Button("Record Attack");
		GridPane.setHalignment(reportbt, HPos.CENTER);
		Button back = new Button("Back to Main Menu");
		GridPane.setHalignment(back, HPos.CENTER);
		
		GridPane reportgp = new GridPane();
		reportgp.add(namelb, 0, 0);
		reportgp.add(nametf, 1, 0);
		reportgp.add(citylb, 0, 1);
		reportgp.add(citytf, 1, 1);
		reportgp.add(damagelb, 0, 2);
		reportgp.add(damagetf, 1, 2);
		reportgp.add(datelb, 0, 3);
		reportgp.add(datetf, 1, 3);
		reportgp.add(reportbt, 0, 4, 2, 1);
		reportgp.add(back, 0, 5, 2, 1);
		
		back.setOnAction(e -> {
			root.setCenter(mainMenu);
		});
		
		reportbt.setOnAction(e -> {
			try {
				monitor.reportAttacks(nametf, citytf, damagetf, datetf);
				GridPane successgp = new GridPane();
				Label successlb = new Label("Attack was recorded!");
				Button successbt = new Button("Continue");
				GridPane.setHalignment(successbt, HPos.CENTER);
				successgp.add(successlb, 0, 0);
				successgp.add(successbt, 0, 1);
				successgp.setAlignment(Pos.CENTER);
				successgp.setVgap(10);
				successgp.setPadding(new Insets(10));
				successbt.setOnAction(g -> {
					root.setCenter(mainMenu);
				});
				root.setCenter(successgp);
			} catch (Exception f) {
				GridPane errorgp = new GridPane();
				Label errorlb = new Label("Invalid Input, try again.");
				Button errorbt = new Button("Try again");
				GridPane.setHalignment(errorbt, HPos.CENTER);
				errorgp.add(errorlb, 0, 0);
				errorgp.add(errorbt, 0, 1);
				errorgp.setAlignment(Pos.CENTER);
				errorgp.setVgap(10);
				errorgp.setPadding(new Insets(10));
				errorbt.setOnAction(g -> {
					root.setCenter(reportgp);
				});
				root.setCenter(errorgp);
			}
		});
		
		reportgp.setAlignment(Pos.CENTER);
		reportgp.setVgap(10);
		reportgp.setPadding(new Insets(10));
		
		root.setCenter(reportgp);
		
	}

	public void showAttacks() {
		Label attacklb = new Label("Attacks");
		attacklb.setFont(new Font("Arial", 15));
		TextArea attacks = new TextArea();
		attacks.setFont(Font.font("monospaced"));
		attacks.setEditable(false);
		attacks.setMinHeight(200);
		attacks.setMinWidth(500);
		attacks.setText(monitor.showAttacks());
		
		Button back = new Button("Back to Main Menu");
		back.setOnAction(e -> {
			root.setCenter(mainMenu);
		});
		
		GridPane attackgp = new GridPane();
		
		attackgp.add(attacklb, 0, 0);
		attackgp.add(attacks, 0, 1);
		attackgp.add(back, 0, 2);
		
		attackgp.setAlignment(Pos.CENTER);
		attackgp.setVgap(10);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setHalignment(attacklb, HPos.CENTER);
		root.setCenter(attackgp);
	}
	
	public void showDamages() {
		Label damagelb = new Label("Damages");
		damagelb.setFont(new Font("Arial", 15));
		
		TextArea damages = new TextArea();
		damages.setText(monitor.showDamages());
		damages.setFont(Font.font("monospaced"));
		damages.setEditable(false);
		damages.setMinHeight(200);
		damages.setMinWidth(500);
		
		Button back = new Button("Back to Main Menu");
		back.setOnAction(e -> {
			root.setCenter(mainMenu);
		});
		
		GridPane damagegp = new GridPane();
		
		damagegp.add(damagelb, 0, 0);
		damagegp.add(damages, 0, 1);
		damagegp.add(back, 0, 2);
		
		damagegp.setAlignment(Pos.CENTER);
		damagegp.setVgap(10);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setHalignment(damagelb, HPos.CENTER);
		
		root.setCenter(damagegp);
	}
	
	public void showMonsters() {
		Label monsterlb = new Label("Attacks by different monsters");
		monsterlb.setFont(new Font("Arial", 15));
		
		TextArea monsters = new TextArea();
		monsters.setText(monitor.showMonsters());
		monsters.setFont(Font.font("monospaced"));
		monsters.setEditable(false);
		monsters.setMinHeight(200);
		monsters.setMinWidth(500);
		
		Button back = new Button("Back to Main Menu");
		back.setOnAction(e -> {
			root.setCenter(mainMenu);
		});
		
		GridPane monstergp = new GridPane();
		
		monstergp.add(monsterlb, 0, 0);
		monstergp.add(monsters, 0, 1);
		monstergp.add(back, 0, 2);
		
		monstergp.setAlignment(Pos.CENTER);
		monstergp.setVgap(10);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setHalignment(monsterlb, HPos.CENTER);
		
		root.setCenter(monstergp);
	}
	
	public void findEarliestAttack() {
		Label earliestlb = new Label("Earliest Attack");
		earliestlb.setFont(new Font("Arial", 15));
		
		TextArea earliest = new TextArea();
		earliest.setText(monitor.findEarliestAttack());
		earliest.setFont(Font.font("monospaced"));
		earliest.setEditable(false);
		earliest.setMinHeight(200);
		earliest.setMinWidth(500);
		
		Button back = new Button("Back to Main Menu");
		back.setOnAction(e -> {
			root.setCenter(mainMenu);
		});
		
		GridPane earliestgp = new GridPane();
		
		earliestgp.add(earliestlb, 0, 0);
		earliestgp.add(earliest, 0, 1);
		earliestgp.add(back, 0, 2);
		
		earliestgp.setAlignment(Pos.CENTER);
		earliestgp.setVgap(10);
		GridPane.setHalignment(back, HPos.CENTER);
		GridPane.setHalignment(earliestlb, HPos.CENTER);
		
		root.setCenter(earliestgp);
	}

	public void writeToCSV() {

		Label instruct = new Label("Enter the name of the output file (Ex: attacks.csv) if you want your file to be stored in the current working directory. \r\n" + 
				"Enter the entire filepath of the output file if you want your file to be stored in a different location.");
		Label filelb = new Label("Filepath: ");
		TextField filetf = new TextField();
		Button writebt = new Button("Write to CSV");
		GridPane.setHalignment(writebt, HPos.CENTER);
		Button back = new Button("Back to Main Menu");
		GridPane.setHalignment(back, HPos.CENTER);
		
		GridPane gp = new GridPane();
		gp.add(instruct, 0, 0, 2, 1);
		gp.add(filelb, 0, 1);
		gp.add(filetf, 1, 1);
		gp.add(writebt, 0, 2, 2, 1);
		gp.add(back, 0, 3, 2, 1);
		
		back.setOnAction(e -> {
			root.setCenter(mainMenu);
		});
		
		writebt.setOnAction(e -> {
			try {
				GridPane successgp = new GridPane();
				Label successlb = new Label(monitor.writeToCSV(filetf));
				Button successbt = new Button("Continue");
				GridPane.setHalignment(successbt, HPos.CENTER);
				successgp.add(successlb, 0, 0);
				successgp.add(successbt, 0, 1);
				successgp.setAlignment(Pos.CENTER);
				successgp.setVgap(10);
				successgp.setPadding(new Insets(10));
				successbt.setOnAction(g -> {
					root.setCenter(mainMenu);
				});
				root.setCenter(successgp);
			} catch (Exception f) {
				GridPane errorgp = new GridPane();
				Label errorlb = new Label("Invalid File Location");
				Button errorbt = new Button("Try again");
				GridPane.setHalignment(errorbt, HPos.CENTER);
				errorgp.add(errorlb, 0, 0);
				errorgp.add(errorbt, 0, 1);
				errorgp.setAlignment(Pos.CENTER);
				errorgp.setVgap(10);
				errorgp.setPadding(new Insets(10));
				errorbt.setOnAction(g -> {
					root.setCenter(gp);
				});
				root.setCenter(errorgp);
			}
		});
		
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(10);
		gp.setPadding(new Insets(10));
		
		root.setCenter(gp);
		
	}
	
	public void readFromCSV() {

		Label instruct = new Label("Enter the name of the file you want to read (Ex: attacks.csv) if your file is in the current working directory. \n"
				+ "Enter the entire filepath if the file is in a different location.");
		Label filelb = new Label("Filepath: ");
		TextField filetf = new TextField();
		Button writebt = new Button("Read from CSV");
		GridPane.setHalignment(writebt, HPos.CENTER);
		Button back = new Button("Back to Main Menu");
		GridPane.setHalignment(back, HPos.CENTER);
		
		GridPane gp = new GridPane();
		gp.add(instruct, 0, 0, 2, 1);
		gp.add(filelb, 0, 1);
		gp.add(filetf, 1, 1);
		gp.add(writebt, 0, 2, 2, 1);
		gp.add(back, 0, 3, 2, 1);
		
		back.setOnAction(e -> {
			root.setCenter(mainMenu);
		});
		
		writebt.setOnAction(e -> {
			try {
				monitor.readFromCSV(filetf);
				GridPane successgp = new GridPane();
				Label successlb = new Label("Successfully read from file!");
				Button successbt = new Button("Continue");
				GridPane.setHalignment(successbt, HPos.CENTER);
				successgp.add(successlb, 0, 0);
				successgp.add(successbt, 0, 1);
				successgp.setAlignment(Pos.CENTER);
				successgp.setVgap(10);
				successgp.setPadding(new Insets(10));
				successbt.setOnAction(g -> {
					root.setCenter(mainMenu);
				});
				root.setCenter(successgp);
			} catch (Exception f) {
				GridPane errorgp = new GridPane();
				Label errorlb = new Label("Invalid File Location");
				Button errorbt = new Button("Try again");
				GridPane.setHalignment(errorbt, HPos.CENTER);
				errorgp.add(errorlb, 0, 0);
				errorgp.add(errorbt, 0, 1);
				errorgp.setAlignment(Pos.CENTER);
				errorgp.setVgap(10);
				errorgp.setPadding(new Insets(10));
				errorbt.setOnAction(g -> {
					root.setCenter(gp);
				});
				root.setCenter(errorgp);
			}
		});
		
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(10);
		gp.setPadding(new Insets(10));
		
		root.setCenter(gp);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
