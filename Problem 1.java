import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of arrays (k): ");
        int k = sc.nextInt();
        
        System.out.print("Enter the size of array (n): ");
        int n = sc.nextInt();
        
        int[][] arr = new int[k][n];
        
        for (int i = 0; i < k; i++) {
            System.out.println("Enter the elements of array " + (i + 1) + " (space-separated):");
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        int[] index = new int[k];
        
        List<Integer> result = new ArrayList<>();
        
        while (result.size() != n * k) {
            int min = Integer.MAX_VALUE;
            int ind = 0;
            
            for (int i = 0; i < k; i++) {
                if (index[i] < n && arr[i][index[i]] < min) {
                    min = arr[i][index[i]];
                    ind = i;
                }
            }
            
            result.add(min);
            index[ind]++;
        }
        
        System.out.println("Merged array in sorted order is: " + result);
    }

}
