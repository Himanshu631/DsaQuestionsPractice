package multithreading.thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {

    private final String name;

    public MyCallable(String name) {
        this.name = name;
    }


    @Override
    public String call() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            stringBuilder.append("Callable ").append(name)
                    .append(" is running ").append(i).append("\n");
            Thread.sleep(500);
        }
        return stringBuilder.toString();
    }
}
