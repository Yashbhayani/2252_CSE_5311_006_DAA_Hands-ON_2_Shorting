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

    public static void main(String[] args) {
        int ar[] = {12, 11, 13, 5, 6};
        Insertionsort main = new Insertionsort();

        main.Insertionsorts(ar, ar.length, 1);

        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
    }

}
