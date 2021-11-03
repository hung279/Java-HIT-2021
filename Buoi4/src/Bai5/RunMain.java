package Bai5;

public class RunMain {
    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0)
                return false;
        }
        return n > 1;
    }

    public static boolean isPrime(long n) {
        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0)
                return false;
        }
        return n > 1;
    }

    public static boolean isPrime(float n) {
        if (n == (int)n) {
            for (int i = 2; i * i <= n; i++) {
                if(n % i == 0)
                    return false;
            }
            return n > 1;
        } else {
            return false;
        }
    }

    public static boolean isPrime(double n) {
        if (n == (int)n) {
            for (int i = 2; i * i <= n; i++) {
                if(n % i == 0)
                    return false;
            }
            return n > 1;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("so 11: " + isPrime(11));
        System.out.println("so 9: " + isPrime(9));
        System.out.println("so 32261: " + isPrime(32261L));
        System.out.println("so 100L: " + isPrime(100L));
        System.out.println("so 11.0f: " + isPrime(11.0f));
        System.out.println("so 7.9f: " + isPrime(7.9f));
        System.out.println("so 7.0d: " + isPrime(7.0d));
        System.out.println("so 2.4d: " + isPrime(2.4d));
    }
}
