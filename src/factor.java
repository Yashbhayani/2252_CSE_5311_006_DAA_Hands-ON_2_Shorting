public class factor {
    public static int factors(int mul, int totalcount, int totaltime) {
        int tm = mul * totalcount;
        if (totaltime == 1) {
            return tm;
        }
        return factors(tm,totalcount - 1, totaltime - 1);
    }

    public static void main(String[] args) {
        int multiplication = factors(1, 6, 2);
        System.out.println(multiplication);
    }
}
