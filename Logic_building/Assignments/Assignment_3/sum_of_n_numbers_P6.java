package Logic_building.Assignments.Assignment_3;
import java.util.Scanner;

public class sum_of_n_numbers_P6 {
    public static void calculateSum(int n){
        int sum = 0;
        for(int i=1 ; i<=n ; i++){
            sum = i + sum;
        }
        System.out.println("The sum of number from 1 to "+n+" is : "+sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the 'N' = ");
        int n = sc.nextInt();
        
        calculateSum(n);
        sc.close();
    }
}
