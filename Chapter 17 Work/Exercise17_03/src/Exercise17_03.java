import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class Exercise17_03 {

    // Method to create a binary data file and write 100 random integers to it
    public static void writeRandomIntegersToFile() {
        String fileName = "Exercise17_03.dat";

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fileName, true))) {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                int randomInt = random.nextInt();
                dataOutputStream.writeInt(randomInt);
            }
            System.out.println("Data written to the file successfully.");
        } catch (IOException e) {
            System.err.println("Error occurred while writing to the file: " + e.getMessage());
        }
    }

    // Method to read integers from the file and find their sum
    public static int findSumOfIntegersInFile() {
        String fileName = "Exercise17_03.dat";
        int sum = 0;

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(fileName))) {
            while (dataInputStream.available() > 0) {
                int num = dataInputStream.readInt();
                sum += num;
            }
        } catch (IOException e) {
            System.err.println("Error occurred while reading the file: " + e.getMessage());
        }

        return sum;
    }

    public static void main(String[] args) {
        // Write 100 random integers to the file
        writeRandomIntegersToFile();

        // Read the integers from the file and find their sum
        int sum = findSumOfIntegersInFile();
        System.out.println("Sum of the integers in the file: " + sum);
    }
}
