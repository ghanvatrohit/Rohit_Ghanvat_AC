public class Q2_sorting_array_logic {

    private int[] numbers;

    // Constructor
    public Q2_sorting_array_logic(int size) {

        numbers = new int[size];
    }

    // Setter
    public void setNumber(int index, int value) {

        numbers[index] = value;
    }

    // Bubble Sort
    public void sort() {

        for (int iTemp = 0; iTemp < numbers.length - 1; iTemp++) {

            for (int jTemp = 0; jTemp < numbers.length - 1 - iTemp; jTemp++) {

                if (numbers[jTemp] > numbers[jTemp + 1]) {

                    int temp = numbers[jTemp];

                    numbers[jTemp] = numbers[jTemp + 1];

                    numbers[jTemp + 1] = temp;
                }
            }
        }
    }

    // Display Array
    public void displayArray() {

        for (int iTemp = 0; iTemp < numbers.length; iTemp++) {

            System.out.print(numbers[iTemp] + " ");
        }

        System.out.println();
    }
}