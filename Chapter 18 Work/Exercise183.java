import java.util.Scanner;

public class Exercise183 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();
        
        int gcdResult = gcd(num1, num2);
        System.out.println("The GCD of " + num1 + " and " + num2 + " is " + gcdResult);
        
        scanner.close();
    }
    
    // Recursive method to calculate GCD
    public static int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        } else {
            return gcd(n, m % n);
        }
    }
}
