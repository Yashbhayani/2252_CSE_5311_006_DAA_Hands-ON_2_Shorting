public class Main
{
    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low - 1;
        int j = high + 1;
        
        while (true) {
            do {
                i++;
            } while (array[i] < pivot);
            
            do {
                j--;
            } while (array[j] > pivot);
            
            if (i >= j) {
                return j;
            }
            
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static int quickSelect(int[] array, int low, int high, int k) {
        if (low <= high) {
            int pivot = partition(array, low, high);
            
            if (pivot == k) {
                return array[pivot];
            } else if (pivot > k) {
                return quickSelect(array, low, pivot, k);
            } else {
                return quickSelect(array, pivot + 1, high, k);
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 2, 7, 1, 3};
        int i = 4;
        int result = quickSelect(arr, 0, arr.length - 1, i);
        System.out.println("The " + i + "th smallest element is: " + result);
    }

}