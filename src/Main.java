public class Main {
    void Insertionsort(int ar[], int length, int sn) {
        if (sn == length) {
            return;
        }

        int key = ar[sn];
        int nn = sn - 1;

        while (nn >= 0 && ar[nn] > key) {
            ar[nn + 1] = ar[nn];
            nn = nn - 1;
        }
        ar[nn + 1] = key;

        Insertionsort(ar, length, sn + 1);
    }

    public static void main(String[] args) {
        int ar[] = { 12, 11, 13, 5, 6 };
        Main main = new Main();

        main.Insertionsort(ar, ar.length, 1);

        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
    }}