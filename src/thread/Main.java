package thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        thread.Parent p = () -> System.out.println("Hello from functional interface");
//        p.greet();

//        Runnable runnable = () -> {
//            for (int i=0;i<=5;i++){
//                System.out.println("Running " + i);
//            }
//        };
//
//        Thread thread = new Thread(runnable);
//        runnable.run();
//        for (int i=0;i<=5;i++){
//            System.out.println("thread.Main " + i);
//        }
        
        List<Integer> list = new ArrayList<>();

        list.add(45);
        list.add(12);
        list.add(13);
        list.add(56);
        list.add(76);

        Collections.sort(list, (a,b) -> b -a);

        System.out.println(list);

    }
}