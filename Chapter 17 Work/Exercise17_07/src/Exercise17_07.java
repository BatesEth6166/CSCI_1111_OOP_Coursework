import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"))) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } catch (IOException ex) {
            System.out.println("File could not be opened");
        }

        // Call the outputData function to read Loan objects from the file and display total loan amount
        outputData();
    }

    public static void outputData() {
        String fileName = "Exercise17_07.dat";
        double totalLoanAmount = 0.0;

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
            // Use EOFException to end the loop when no more objects can be read
            while (true) {
                Loan loan = (Loan) input.readObject();
                totalLoanAmount += loan.getLoanAmount();
            }
        } catch (EOFException e) {
            // End of file reached, no more objects to read
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error occurred while reading the file: " + ex.getMessage());
        }

        System.out.println("Total loan amount: " + totalLoanAmount);
    }
}
