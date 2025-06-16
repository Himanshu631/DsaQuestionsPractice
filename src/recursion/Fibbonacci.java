package recursion;

public class Fibbonacci {

    public static int getFibbonacci(int n) {
        if (n<=1){
            return n;
        }

        int last = getFibbonacci(n-1);
        int seclast = getFibbonacci(n-2);
        return last + seclast;

    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(getFibbonacci(n));
    }
}
