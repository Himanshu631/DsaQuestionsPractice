package strings;

public class ReverseString {

    public static void main(String[] args) {
        String input = "Himanshu";
        StringBuilder reversed = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            reversed.insert(0, input.charAt(i));
        }

        String answer =  reversed.toString();
        System.out.println(answer);
    }
}
