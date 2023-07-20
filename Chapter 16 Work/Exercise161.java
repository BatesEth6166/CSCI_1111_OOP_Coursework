import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise161 extends Application {
    private VBox pane;
    private Text message;
    private Button btnLeft;
    private Button btnRight;
    private RadioButton rbRed;
    private RadioButton rbGreen;
    private RadioButton rbBlue;

    @Override
    public void start(Stage primaryStage) {
        pane = new VBox(10);
        pane.setPadding(new Insets(10));
        pane.setPrefSize(400, 200);

        message = new Text("Hello, JavaFX!");
        message.setFont(new Font(24));

        btnLeft = new Button("<");
        btnLeft.setOnAction(e -> moveLeft());

        btnRight = new Button(">");
        btnRight.setOnAction(e -> moveRight());

        ToggleGroup colorGroup = new ToggleGroup();

        rbRed = new RadioButton("Red");
        rbRed.setToggleGroup(colorGroup);
        rbRed.setOnAction(e -> changeColor(Color.RED));

        rbGreen = new RadioButton("Green");
        rbGreen.setToggleGroup(colorGroup);
        rbGreen.setOnAction(e -> changeColor(Color.GREEN));

        rbBlue = new RadioButton("Blue");
        rbBlue.setToggleGroup(colorGroup);
        rbBlue.setOnAction(e -> changeColor(Color.BLUE));

        HBox colorBox = new HBox(10, rbRed, rbGreen, rbBlue);
        HBox buttonBox = new HBox(10, btnLeft, btnRight);

        pane.getChildren().addAll(colorBox, message, buttonBox);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise 161");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void moveLeft() {
        double newX = message.getTranslateX() - 10;
        message.setTranslateX(newX);
    }

    private void moveRight() {
        double newX = message.getTranslateX() + 10;
        message.setTranslateX(newX);
    }

    private void changeColor(Color color) {
        message.setFill(color);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
