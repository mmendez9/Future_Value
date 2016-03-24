package p1;

/*
 * Created by mmendez9 on 3/22/2016.
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Future_Value extends Application {
    TextField txAmount = new TextField();
    TextField txYears = new TextField();
    TextField txAnnualRate = new TextField();
    TextField txFutureValue = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.addRow(0, new Label("Investment Amount: "), txAmount);
        pane.addRow(1, new Label("Number of Years: "), txYears);
        pane.addRow(2, new Label("Annual Interest Rate: "), txAnnualRate);
        pane.addRow(3, new Label("Future Value: "), txFutureValue);

        Button btCalculate = new Button("Calculate");
        pane.add(btCalculate, 1, 4);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        pane.setAlignment(Pos.CENTER);
        txAmount.setAlignment(Pos.BOTTOM_RIGHT);
        txYears.setAlignment(Pos.BOTTOM_RIGHT);
        txAnnualRate.setAlignment(Pos.BOTTOM_RIGHT);

        txFutureValue.setEditable(false);
        txFutureValue.setAlignment(Pos.BASELINE_RIGHT);
        btCalculate.setOnAction(new calculateFutureValue());

        Scene scene = new Scene(pane, 275, 150);
        primaryStage.setTitle("Investment-Value");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class calculateFutureValue implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            double annualRate = Double.parseDouble(txAnnualRate.getText());
            int year = Integer.parseInt(txYears.getText());
            double amount = Double.parseDouble(txAmount.getText());

            double monthlyRate = annualRate / 1200;
            double value = (amount * (Math.pow((1 + monthlyRate), (year * 12))));

            txFutureValue.setText(String.format("$%.2f", value));
        }
    }
}
