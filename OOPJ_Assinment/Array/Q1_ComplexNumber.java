public class Q1_ComplexNumber {
    public static void main(String[] args) {
        Q1_ComplexNumberLogic[] list = new Q1_ComplexNumberLogic[5];

        for (int iTemp = 0; iTemp < list.length; iTemp++) {
            list[iTemp] = new Q1_ComplexNumberLogic();

            System.out.println("--- Element " + (iTemp + 1) + " ---");

            System.out.print("Enter number1: ");
            list[iTemp].setNumber1(ConsoleInput.getInt());

            System.out.print("Enter number2: ");
            list[iTemp].setNumber2(ConsoleInput.getInt());
        }

        System.out.println("\n--- Result ---");
        for (int iTemp = 0; iTemp < list.length; iTemp++) {
            int result = list[iTemp].computeComplexNumber();
            System.out.println("Result for element " + (iTemp + 1) + " (" + list[iTemp].getNumber1() + " * " + list[iTemp].getNumber2() + ") = " + result);
        }
    }
}