import java.io.*;
import java.util.*;

public class Exercise1215 {
    public static void main(String[] args) {
        String filename = "Exercise12_15.txt";
        File file = new File(filename);

        try {
            // Create the file if it does not exist
            if (!file.exists()) {
                file.createNewFile();
            }

            // Write 100 randomly generated integers to the file
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                int randomNumber = random.nextInt(1000);
                bufferedWriter.write(randomNumber + " ");
            }

            // Close the writer
            bufferedWriter.close();

            // Read the data back from the file and display it in increasing order
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<Integer> numbers = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (String token : tokens) {
                    int number = Integer.parseInt(token);
                    numbers.add(number);
                }
            }

            // Sort the numbers in increasing order
            Collections.sort(numbers);

            // Display the sorted numbers
            System.out.println("Numbers in increasing order:");
            for (int number : numbers) {
                System.out.print(number + " ");
            }

            // Close the reader
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}