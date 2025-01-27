public class Selectionsort {
    void Selectionsorts(int ar[], int length, int sn, int nl, int mind) {
        if (sn == length - 1) {
            return;
        }

        if (nl == length) {
            int key = ar[sn];
            ar[sn] = ar[mind];
            ar[mind] = key;

            Selectionsorts(ar, length, sn + 1, sn + 2, sn + 1);
        } else {
            if (ar[nl] < ar[mind]) {
                mind = nl;
            }
            Selectionsorts(ar, length, sn, nl + 1, mind);
        }
    }

    public static void main(String[] args) {
        int ar[] = { 12, 11, 13, 5, 6 };
        Selectionsort main = new Selectionsort();

        main.Selectionsorts(ar, ar.length, 0, 1, 0);

        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
    }
}
