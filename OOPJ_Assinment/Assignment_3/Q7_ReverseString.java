package Assignment_3;

public class Q7_ReverseString {

    public static void main(String[] args) {

        String str = "The quick brown fox jumps";

        System.out.println("The given string is: " + str);

        String reverse = new StringBuilder(str).reverse().toString();

        System.out.println("The string in reverse order is:");
        System.out.println(reverse);
    }
}