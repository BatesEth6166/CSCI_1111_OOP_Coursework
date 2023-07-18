import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15 extends Application {
    private PathTransition pathTransition;
    private Rectangle rectangle;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 400, 400);

        // Create a pentagon path
        Path pentagonPath = createPentagonPath(pane);

        // Create a rectangle
        rectangle = new Rectangle(0, 0, 100, 50); // Modified to elongate the sides
        rectangle.setFill(Color.BLUE);

        // Create a path transition for the rectangle
        pathTransition = new PathTransition(Duration.seconds(5), pentagonPath, rectangle);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.setAutoReverse(false);

        // Add rectangle and pentagon to the pane
        pane.getChildren().addAll(rectangle, pentagonPath);

        // Add mouse event handlers
        pane.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                if (pathTransition.getStatus() == PathTransition.Status.PAUSED) {
                    pathTransition.play();
                } else {
                    pathTransition.pause();
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Pentagon Animation");
        primaryStage.show();

        // Start the animation
        pathTransition.playFromStart();

        // Start a timeline to update opacity during the animation
        Duration duration = pathTransition.getCycleDuration();
        double maxOpacity = 1.0;
        double minOpacity = 0.2; // Change the minimum opacity as desired
        pathTransition.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            double t = newValue.toMillis() % duration.toMillis() / duration.toMillis();
            double opacity = maxOpacity - (maxOpacity - minOpacity) * t;
            rectangle.setOpacity(opacity);
        });
    }

    private Path createPentagonPath(Pane pane) {
        double centerX = pane.getWidth() / 2;
        double centerY = pane.getHeight() / 2;
        double radius = Math.min(pane.getWidth(), pane.getHeight()) * 0.4;

        Path path = new Path();
        path.setStroke(Color.BLACK);
        path.setStrokeWidth(2.0);

        path.getElements().add(new MoveTo(centerX + radius, centerY));
        for (int i = 1; i <= 5; i++) {
            double angle = i * 2 * Math.PI / 5;
            double x = centerX + radius * Math.cos(angle);
            double y = centerY - radius * Math.sin(angle);
            path.getElements().add(new LineTo(x, y));
        }

        return path;
    }
}
