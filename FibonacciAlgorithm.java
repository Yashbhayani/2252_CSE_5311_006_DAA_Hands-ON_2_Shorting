import java.util.Scanner;

public class Main
{
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        return fib(n - 1) + fib(n - 2);
    }

    public static int fibImproved(int n) {
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        int a = 0;
        int b = 1;
        
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int n = scanner.nextInt();

        System.out.println("\n1. Fibonacci Number by Given Algorithm");
        long startTime = System.nanoTime();
        System.out.println("Fibonacci Number at index " + n + " is: " + fib(n) + 
                           " and taken time is " + (System.nanoTime() - startTime) / 1000.0 + " microseconds\n");

        System.out.println("2. Fibonacci Number by Improved Algorithm");
        startTime = System.nanoTime();
        System.out.println("Fibonacci Number at index " + n + " is: " + fibImproved(n) + 
                           " and taken time is " + (System.nanoTime() - startTime) / 1000.0 + " microseconds\n");

        scanner.close();
    }

}
