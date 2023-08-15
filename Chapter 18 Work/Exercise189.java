public class Exercise189 {
    public static void main(String[] args) {
        String input = "Hello, World!";
        reverseDisplay(input);
    }
    
    // Recursive method to display string reversely
    public static void reverseDisplay(String value) {
        if (value.length() == 0) {
            return;
        } else {
            System.out.print(value.charAt(value.length() - 1));
            reverseDisplay(value.substring(0, value.length() - 1));
        }
    }
}
