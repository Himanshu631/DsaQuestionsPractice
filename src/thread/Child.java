package thread;

public class Child implements Parent{
    @Override
    public void greet() {
        System.out.println("Good Morning, from thread.Child");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello from thread.Child");
    }
}
