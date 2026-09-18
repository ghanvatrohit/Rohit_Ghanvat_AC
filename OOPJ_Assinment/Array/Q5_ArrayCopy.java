package Array;
public class Q5_ArrayCopy {

    public static void main(String[] args) {

        System.out.print("Enter size of array: ");
        int size = ConsoleInput.getInt();

        Q5_ArrayCopyLogic obj = new Q5_ArrayCopyLogic(size);

        System.out.println("\nEnter " + size + " numbers:");

        for (int iTemp = 0; iTemp < size; iTemp++) {

            System.out.print("Enter element " + (iTemp + 1) + ": ");

            obj.setNumber(iTemp, ConsoleInput.getInt());
        }

        System.out.println("\n--- Original Array ---");
        obj.displayOriginalArray();

        obj.copyArray();

        System.out.println("\n--- Copied Array ---");
        obj.displayCopiedArray();
    }
}