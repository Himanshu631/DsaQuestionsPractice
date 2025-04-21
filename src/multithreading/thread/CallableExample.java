package multithreading.thread;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<String> callable1 = new MyCallable("Task 1");
        Callable<String> callable2 = new MyCallable("Task 2");

        try {
            Future<String> future1 = executorService.submit(callable1);
            Future<String> future2 = executorService.submit(callable2);

            System.out.println(future1.get());
            System.out.println(future2.get());

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }
}
