public class Bubblesort {

    void Bubblesorts(int ar[], int length, int sn, int nl) {
        if (sn == length - 1) {
            return;
        }

        if (nl < length - sn - 1) {
            if (ar[nl] > ar[nl + 1]) {
                int key = ar[nl];
                ar[nl] = ar[nl + 1];
                ar[nl + 1] = key;
            }
            Bubblesorts(ar, length, sn, nl + 1);
        } else {
            Bubblesorts(ar, length, sn + 1, 0);
        }
    }

    public static void main(String[] args) {
        int ar[] = { 12, 11, 13, 5, 6 };

        Bubblesort main = new Bubblesort();

        main.Bubblesorts(ar, ar.length, 0, 0);

        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
    }

}
