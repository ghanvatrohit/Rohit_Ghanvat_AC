package OOPJ_Assinment.ForLoop;

public class Q6_NumberPattern {
    public static void main(String[] args) {

        int number = 1;

        for (int iTemp = 1; iTemp <= 4; iTemp++) {

            for (int jTemp = 1; jTemp <= iTemp; jTemp++) {

                System.out.print(number + " ");
                number++;
            }

            System.out.println();
        }
    }
}
