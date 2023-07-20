import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise1621 extends Application {
    private TextField timeField;
    private Text countdownText;
    private MediaPlayer mediaPlayer;
    private int remainingSeconds;

    @Override
    public void start(Stage primaryStage) {
        timeField = new TextField();
        timeField.setOnAction(e -> startCountdown());

        countdownText = new Text();
        countdownText.setFont(new Font(24));

        Button startButton = new Button("Start");
        startButton.setOnAction(e -> startCountdown());

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(timeField, countdownText, startButton);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Countdown Stopwatch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startCountdown() {
        try {
            int inputSeconds = Integer.parseInt(timeField.getText());
            if (inputSeconds > 0) {
                remainingSeconds = inputSeconds;
                countdownText.setText(String.valueOf(remainingSeconds));
                timeField.clear();

                Thread countdownThread = new Thread(() -> {
                    while (remainingSeconds > 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        remainingSeconds--;
                        countdownText.setText(String.valueOf(remainingSeconds));
                    }

                    Media media = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
                    mediaPlayer = new MediaPlayer(media);
                    mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.play());
                    mediaPlayer.play();
                });
                countdownThread.setDaemon(true);
                countdownThread.start();
            }
        } catch (NumberFormatException e) {
            // Invalid input, handle accordingly
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

