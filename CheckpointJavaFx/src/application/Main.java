package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	TextField tfloanAmount = new TextField();
	TextField tfnumYears = new TextField();
	TextArea tfpaymentinfo = new TextArea();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane pane = new GridPane();
			pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
			pane.setHgap(20);
			pane.setVgap(20);
			
			pane.add(new Label("Loan Amount"), 0, 0);
			pane.add(tfloanAmount, 1, 0);
			pane.add(new Label("Number of Years"), 2, 0);
			pane.add(tfnumYears, 3, 0);
			Button button = new Button("Show Table");
			pane.add(button, 4 , 0); 
			
			ScrollPane paymentinfo = new ScrollPane(tfpaymentinfo);
			tfpaymentinfo.setEditable(false);
			
			button.setOnAction(e -> calculateLoanPayments());
			pane.add(paymentinfo, 0, 1, 5, 5);
			
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void calculateLoanPayments() {
		double loanAmount = Double.parseDouble(tfloanAmount.getText());
		int numYears = Integer.parseInt(tfnumYears.getText());
		String paymentString = new String();
		paymentString = String.format("%-27s %-20s %-24s\n", "Interest Rate", "Monthly Payment", "Total Payment");
		for (int i = 0; i <= (8-5)/(1/8.0); i++) {
			paymentString = paymentString + String.format("%-30.3f %-30.2f %-30.2f \n", 5 + i*(1/8.0), getMonthlyPayment(loanAmount, 5 + i*(1/8.0), numYears), getTotalPayment(getMonthlyPayment(loanAmount, 5 + i*(1/8.0), numYears), numYears));
		}
		tfpaymentinfo.clear();
		tfpaymentinfo.appendText(paymentString);
		
	}
	
	public static double getMonthlyPayment(double amount, double rate, int years) {
        double monthlyPayment = 0;
        double monthlyRate = rate / 1200;
        monthlyPayment = amount * monthlyRate/(1 -1 / Math.pow((1+monthlyRate), years * 12));
        return monthlyPayment;
    }

    public static double getTotalPayment(double monthlyPayment, int years) {
        return monthlyPayment * years * 12;
    }
}
