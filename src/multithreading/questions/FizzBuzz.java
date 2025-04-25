package multithreading.questions;

// You’re given an integer n. Print numbers from 1 to n, but:

// If a number is divisible by 3 and not 5, print "fizz"
// If divisible by 5 and not 3, print "buzz"
// If divisible by both 3 and 5, print "fizzbuzz"
// Else, print the number

// You must do this using four threads:

// One for fizz()
// One for buzz()
// One for fizzbuzz()
// One for number()

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {

    private final int n;
    private int current = 1;
    private final Semaphore number = new Semaphore(1);
    private final Semaphore fizz = new Semaphore(0);
    private final Semaphore buzz = new Semaphore(0);
    private final Semaphore fizzbuzz = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            fizz.acquire();
            if (current > n) {
                break;
            }
            printFizz.run();
            number.release();
        }
    }

    public void buzz(Runnable printFizz) throws InterruptedException {
        while (true) {
            buzz.acquire();
            if (current > n) {
                break;
            }
            printFizz.run();
            number.release();
        }
    }


    public void fizzbuzz(Runnable printFizz) throws InterruptedException {
        while (true) {
            fizzbuzz.acquire();
            if (current > n) {
                break;
            }
            printFizz.run();
            number.release();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            number.acquire();
            if (current > n) {
                // Allow other threads to exit
                fizz.release();
                buzz.release();
                fizzbuzz.release();
                break;
            }

            if (current % 3 == 0 && current % 5 == 0) {
                fizzbuzz.release();
            } else if (current % 3 == 0) {
                fizz.release();
            } else if (current % 5 == 0) {
                buzz.release();
            } else {
                printNumber.accept(current);
                number.release();
            }

            current++;
        }
    }

    public static void main(String[] args) {
        FizzBuzz fb = new FizzBuzz(15);

        new Thread(() -> {
            try {
                fb.fizz(() -> System.out.print("fizz "));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                fb.buzz(() -> System.out.print("buzz "));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                fb.fizzbuzz(() -> System.out.print("fizzbuzz "));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        new Thread(() -> {
            try {
                fb.number(num -> System.out.print(num + " "));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
