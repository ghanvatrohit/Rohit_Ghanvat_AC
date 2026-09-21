package ArrayList;

import java.util.ArrayList;

public class Q3_RetrieveElement {

    public static void main(String[] args) {

        // Create an ArrayList of String
        ArrayList<String> colors = new ArrayList<>();

        // Add colors to the ArrayList
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Orange");

        // Display the ArrayList
        System.out.println("Colors: " + colors);

        // Specify the index
        int index = 2;

        // Retrieve the element at the specified index
        String color = colors.get(index);

        System.out.println("Element at index " + index + ": " + color);
    }
}


