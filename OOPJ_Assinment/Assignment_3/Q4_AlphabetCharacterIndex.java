package Assignment_3;

public class Q4_AlphabetCharacterIndex {

    public static void main(String[] args) {

        String str = "The quick brown fox jumps over the lazy dog.";

        str = str.toLowerCase();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            System.out.print(ch + " ");
        }

        System.out.println();
        System.out.println("============================");

        for (char ch = 'a'; ch <= 'z'; ch++) {
            System.out.print(str.indexOf(ch) + " ");
        }
    }
}