import java.io.*;

public class FileDecoder {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Prompt user for input and output file names
            System.out.print("Enter the input file name (encrypted file): ");
            String inputFileName = reader.readLine();
            System.out.print("Enter the output file name (decrypted file): ");
            String outputFileName = reader.readLine();

            decodeFile(inputFileName, outputFileName);

            System.out.println("File decrypted successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while processing the files: " + e.getMessage());
        }
    }

    public static void decodeFile(String inputFileName, String outputFileName) throws IOException {
        try (FileInputStream inputFile = new FileInputStream(inputFileName);
             FileOutputStream outputFile = new FileOutputStream(outputFileName)) {

            int data;
            while ((data = inputFile.read()) != -1) {
                // Subtract 5 from each byte and write to the output file
                outputFile.write(data - 5);
            }
        }
    }
}
