package Logic_building.Assignments.Assignment_3;
import java.util.Scanner;

public class SumOfTwoNumbers_P1 {
    public static int sumOfTwoNumbers(int num1, int num2){
        return num1 + num2;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the first number = ");
        int firstNum = sc.nextInt();

        System.out.print("Enter the second number = ");
        int secondNum = sc.nextInt();

        int result = sumOfTwoNumbers(firstNum, secondNum);

        System.out.println("The sum of "+firstNum+" and "+secondNum+" is "+ result +".");

        sc.close();
    }
}
