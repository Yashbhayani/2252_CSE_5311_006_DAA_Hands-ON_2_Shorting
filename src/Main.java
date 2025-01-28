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

    public static void Loop (int ar[]){
        System.out.print("Array " + ar.length + " Output:- ");

        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }

        System.out.print("\n");
    }

    public static void main(String[] args) {
        int ar[] = { 12, 11, 13, 5, 6 };
        int ar2[] = { 12, 11, 13, 5, 6, 122, 1, 18, 15, 16 };
        int ar3[] = { 12, 11, 13, 5, 6, 122, 1, 18, 15, 16, 75, 19, 180, 145, 106 };

        Main main = new Main();

        main.Insertionsort(ar, ar.length, 1);
        main.Insertionsort(ar2, ar2.length, 1);
        main.Insertionsort(ar3, ar3.length, 1);

        Loop(ar);
        Loop(ar2);
        Loop(ar3);
    }
}