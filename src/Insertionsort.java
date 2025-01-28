public class Insertionsort {
    void shiftElements(int ar[], int nno, int key) {
        if (nno < 0 || ar[nno] <= key) {
            ar[nno + 1] = key;
            return;
        }

        ar[nno + 1] = ar[nno];

        shiftElements(ar, nno - 1, key);
    }

    void Insertionsorts(int ar[], int length, int nno) {
        if (nno == length) {
            return;
        }

        int key = ar[nno];

        shiftElements(ar, nno - 1, key);

        Insertionsorts(ar, length, nno + 1);
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

        Insertionsort main = new Insertionsort();

        main.Insertionsorts(ar, ar.length, 1);
        main.Insertionsorts(ar2, ar2.length, 1);
        main.Insertionsorts(ar3, ar3.length, 1);

        Loop(ar);
        Loop(ar2);
        Loop(ar3);
    }

}
