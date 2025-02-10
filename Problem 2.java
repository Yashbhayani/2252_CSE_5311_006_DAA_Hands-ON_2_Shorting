import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements of array (space-separated):");
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        int[] array = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            array[i] = Integer.parseInt(inputArray[i]);
        }

        int index = 0;
        while (index < array.length - 1) {
            if (array[index] == array[index + 1]) {
                for (int i = index + 1; i < array.length - 1; i++) {
                    array[i] = array[i + 1];
                }
                array = Arrays.copyOf(array, array.length - 1);
            } else {
                index++;
            }
        }

        System.out.print("Duplicate removed array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
