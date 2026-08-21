package Logic_building.Assignments.Assignment_4;
import java.util.Scanner;

public class PrintMultiplesOfThree_Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        for(int i=1 ; i<=num ;i++){
            if(i%3==0){
                System.out.println(i+" ");
            }
        }
        sc.close();
    }
}
