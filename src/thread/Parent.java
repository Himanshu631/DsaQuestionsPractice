package thread;

@FunctionalInterface
public interface Parent {
    public void greet();
    default void sayHello(){
        System.out.println("Hey, Wishing you Hello from thread.Parent");
    };
    public static void sayBye(){
        System.out.println("Hey Wishing BYE from thread.Parent");
    };
}
