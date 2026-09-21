package ArrayList;


import java.util.ArrayList;

public class Q5_RemoveThirdElement {

    public static void main(String[] args) {

        // Create an ArrayList of String
        ArrayList<String> colors = new ArrayList<>();

        // Add colors to the ArrayList
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Orange");

        // Display the original ArrayList
        System.out.println("Before removing: " + colors);

        // Remove the third element
        colors.remove(2);

        // Display the updated ArrayList
        System.out.println("After removing third element: " + colors);
    }
}

