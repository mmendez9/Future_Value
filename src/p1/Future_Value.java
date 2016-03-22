package p1;

/*
 * Created by mmendez9 on 3/22/2016.
 */


import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Future_Value extends Application {
    TextField txAmount = new TextField();
    TextField txYears = new TextField();
    TextField txAnnualRate = new TextField();
    TextField txFutureValue = new TextField();

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10 ,10));
        pane.setHgap(5);
        pane.setVgap(5);
        pane.addRow(0, new Label("Investment Amount: "), txAmount);
        pane.addRow(1, new Label("Number of Years: "), txYears);
        pane.addRow(2, new Label("Annual Interest Rate: "), txAnnualRate);
        pane.addRow(3, new Label("Future Value: "), txFutureValue);

        Button btCalculate = new Button("Calculate");
        pane.add(btCalculate, 1, 4);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        Scene scene = new Scene(pane, 275, 150);
        primaryStage.setTitle("Future Value");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
