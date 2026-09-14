public class Q5_ArrayCopyLogic {

    private int[] numbers;
    private int[] copiedNumbers;

    public Q5_ArrayCopyLogic(int size) {
        numbers = new int[size];
        copiedNumbers = new int[size];
    }

    public void setNumber(int index, int value) {
        numbers[index] = value;
    }

    public void copyArray() {
        for (int iTemp = 0; iTemp < numbers.length; iTemp++) {
            copiedNumbers[iTemp] = numbers[iTemp];
        }
    }

    public void displayOriginalArray() {
        for (int iTemp = 0; iTemp < numbers.length; iTemp++) {
            System.out.print(numbers[iTemp] + " ");
        }

        System.out.println();
    }

    public void displayCopiedArray() {
        for (int iTemp = 0; iTemp < numbers.length; iTemp++) {
            System.out.print(copiedNumbers[iTemp] + " ");
        }

        System.out.println();
    }
}