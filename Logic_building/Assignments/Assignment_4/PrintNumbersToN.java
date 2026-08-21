package Logic_building.Assignments.Assignment_4;
import java.util.Scanner;

public class PrintNumbersToN {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int n = sc.nextInt();

        for(int i=1 ; i<=n ; i++){
            System.out.print(i+" ");
        }
        sc.close();
    }
}
