import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class DisplayBall extends Application {
    private MoveBall ballPane;

    @Override
    public void start(Stage primaryStage) {
        ballPane = new MoveBall();

        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");

        btUp.setOnAction(e -> ballPane.moveUp());
        btDown.setOnAction(e -> ballPane.moveDown());
        btLeft.setOnAction(e -> ballPane.moveLeft());
        btRight.setOnAction(e -> ballPane.moveRight());

        HBox buttonPane = new HBox(10);
        buttonPane.setAlignment(Pos.BOTTOM_CENTER);
        buttonPane.getChildren().addAll(btUp, btDown, btLeft, btRight);

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setBottom(buttonPane);

        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("MoveBall");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
