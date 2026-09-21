package ArrayList;

import java.util.ArrayList;

public class Q6_SearchElement {

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

        // Element to search
        String searchColor = "Green";

        // Search for the element
        if (colors.contains(searchColor)) {
            System.out.println(searchColor + " is present in the ArrayList.");
        } else {
            System.out.println(searchColor + " is not present in the ArrayList.");
        }
    }
}
