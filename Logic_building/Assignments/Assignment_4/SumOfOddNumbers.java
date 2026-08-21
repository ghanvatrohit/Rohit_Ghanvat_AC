package Logic_building.Assignments.Assignment_4;
import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int sum=0;
        for(int i=1; i<=num ; i++){
            if(i%2!=0){
                sum += i;
            }
        }
        System.out.print("The sum of odd numbers from 1 to "+num+" is: "+sum);
        sc.close();
    }
}
