public class Q10_CommonElements {

    public static void main(String[] args) {

        System.out.print("Enter size of first array: ");
        int size1 = ConsoleInput.getInt();

        System.out.print("Enter size of second array: ");
        int size2 = ConsoleInput.getInt();

        Q10_CommonElementsLogic obj =
                new Q10_CommonElementsLogic(size1, size2);

        System.out.println("\nEnter elements of first array:");

        for (int iTemp = 0; iTemp < size1; iTemp++) {

            System.out.print("Enter element " + (iTemp + 1) + ": ");

            obj.setFirstArrayNumber(iTemp, ConsoleInput.getInt());
        }

        System.out.println("\nEnter elements of second array:");

        for (int iTemp = 0; iTemp < size2; iTemp++) {

            System.out.print("Enter element " + (iTemp + 1) + ": ");

            obj.setSecondArrayNumber(iTemp, ConsoleInput.getInt());
        }

        System.out.println("\n--- First Array ---");
        obj.displayFirstArray();

        System.out.println("\n--- Second Array ---");
        obj.displaySecondArray();

        System.out.println("\n--- Common Elements ---");
        obj.findCommonElements();
    }
}