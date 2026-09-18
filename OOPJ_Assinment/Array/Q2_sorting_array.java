package Array;
public class Q2_sorting_array {

    public static void main(String[] args) {

        System.out.println("Enter size of Array: ");
        int size = ConsoleInput.getInt();

        Q2_sorting_array_logic obj = new Q2_sorting_array_logic(size);

        System.out.print("Enter " + size + " numbers: ");

        for (int iTemp = 0; iTemp < size; iTemp++) {

            obj.setNumber(iTemp, ConsoleInput.getInt());
        }

        System.out.println("\n--- Original Array ---");
        obj.displayArray();

        obj.sort();

        System.out.println("\n--- Result ---");
        obj.displayArray();
    }
}