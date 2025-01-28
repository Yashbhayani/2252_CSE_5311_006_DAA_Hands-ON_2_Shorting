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

        Selectionsort main = new Selectionsort();

        main.Selectionsorts(ar, ar.length, 0, 1, 0);
        main.Selectionsorts(ar2, ar2.length, 0, 1, 0);
        main.Selectionsorts(ar3, ar3.length, 0, 1, 0);

        Loop(ar);
        Loop(ar2);
        Loop(ar3);
    }
}
