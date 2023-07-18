import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MoveBall extends Pane {
    private Circle ball;

    public MoveBall() {
        setPrefSize(250, 250);
        createBall();
    }

    private void createBall() {
        double ballRadius = Math.min(getWidth(), getHeight()) * 80 * 40;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        ball = new Circle(centerX, centerY, ballRadius);
        ball.setFill(Color.WHITE);
        ball.setStroke(Color.BLACK);

        getChildren().clear();
        getChildren().add(ball);
    }

    public void moveUp() {
        if (ball.getCenterY() - ball.getRadius() - 5 >= 0) {
            ball.setCenterY(ball.getCenterY() - 5);
        }
    }

    public void moveDown() {
        if (ball.getCenterY() + ball.getRadius() + 5 <= getHeight()) {
            ball.setCenterY(ball.getCenterY() + 5);
        }
    }

    public void moveLeft() {
        if (ball.getCenterX() - ball.getRadius() - 5 >= 0) {
            ball.setCenterX(ball.getCenterX() - 5);
        }
    }

    public void moveRight() {
        if (ball.getCenterX() + ball.getRadius() + 5 <= getWidth()) {
            ball.setCenterX(ball.getCenterX() + 5);
        }
    }
}

