package multithreading.questions;

// You are given an integer n. There are three threads:

//Thread A prints 0
//Thread B prints even numbers (2, 4, 6, ...)
//Thread C prints odd numbers (1, 3, 5, ...)


import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {

    private final int n;
    private final Semaphore zero = new Semaphore(1);
    private final Semaphore odd = new Semaphore(0);
    private final Semaphore even = new Semaphore(0);

    public PrintZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n ; i++) {
            zero.acquire();
            printNumber.accept(0);

            if (i%2==0) {
                even.release();
            } else {
                odd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <=n ; i+=2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <=n ; i+=2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public static void main(String[] args) {
        PrintZeroEvenOdd printZeroEvenOdd = new PrintZeroEvenOdd(5);
        Thread t1 = new Thread(() -> {
            try {
                printZeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                printZeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        Thread t3 = new Thread(() -> {
            try {
                printZeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
