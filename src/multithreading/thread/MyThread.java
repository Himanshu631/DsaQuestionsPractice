package multithreading.thread;

public class MyThread extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId() + " is running " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interuppted");
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        MyThread myThread4 = new MyThread();

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();

    }
}
