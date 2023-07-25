import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Exercise17_01 {
    public static void main(String[] args) {
        String fileName = "Exercise17_01.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Append data to the file if it already exists
            // Write 100 random integers separated by a space
            for (int i = 0; i < 100; i++) {
                int randomInt = getRandomInteger();
                writer.write(String.valueOf(randomInt));
                if (i < 99) {
                    writer.write(" ");
                }
            }
            System.out.println("Data written to the file successfully.");
        } catch (IOException e) {
            System.err.println("Error occurred while writing to the file: " + e.getMessage());
        }
    }

    private static int getRandomInteger() {
        Random random = new Random();
        return random.nextInt();
    }
}
