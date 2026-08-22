package Logic_building.Assignments.Assignment_4;
import java.util.Scanner;

public class OddNumberPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Value : ");
        int n= sc.nextInt();

        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=i ; j++){
                System.out.print(2*j-1);
                if(j<i){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
