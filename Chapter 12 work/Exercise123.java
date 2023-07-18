import java.util.Random;
import java.util.Scanner;

public class Exercise123 {
    public static void main(String[] args) {
        int[] array = new int[100];
        Random random = new Random();

        // Populate the array with random integers
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }

        // Prompt the user to enter the index
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the array: ");
        int index = scanner.nextInt();

        // Check if the index is within valid bounds
        if (index >= 0 && index < array.length) {
            int value = array[index];
            System.out.println("Element value at index " + index + ": " + value);
        } else {
            System.out.println("Out of Bounds");
        }
    }
}
