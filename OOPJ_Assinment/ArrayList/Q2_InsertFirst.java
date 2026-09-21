package ArrayList;


import java.util.ArrayList;

public class Q2_InsertFirst {

    public static void main(String[] args) {

        // Create an ArrayList of String
        ArrayList<String> colors = new ArrayList<>();

        // Add colors to the ArrayList
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Orange");

        System.out.println("Before inserting: " + colors);

        // Insert an element at the first position
        colors.add(0, "Purple");

        System.out.println("After inserting: " + colors);
    }
}
