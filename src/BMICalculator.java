import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;


public class BMICalculator extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label labelWeight =  new Label("Weight");
        Label labelHeight =  new Label("Height");

        TextField textFieldWeight = new TextField();
        textFieldWeight.setPromptText("Weight in pounds");
        TextField textFieldHeight = new TextField();
        textFieldHeight.setPromptText("Height in inches");

        Label labelResult = new Label("Result: ");

        Button buttonCalculate = new Button("Calculate");
        buttonCalculate.setOnAction(e -> {
            try{
                double weight = Double.parseDouble(textFieldWeight.getText().replaceAll(",", "."));
                double height = Double.parseDouble(textFieldHeight.getText().replaceAll(",", "."));

                double bmi = (weight * 703)/(height * height);
                labelResult.setText(String.format("Your BMI IS: %.2f", bmi));
            }catch (NumberFormatException ex){
                labelResult.setText("Please enter a valid number for weight and height");
            }

        });

        VBox layout = new VBox(10, labelWeight, textFieldWeight, labelHeight, textFieldHeight, buttonCalculate, labelResult);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.setTitle("BMI calculator");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
