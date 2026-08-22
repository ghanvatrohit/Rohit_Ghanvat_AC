package Logic_building.Assignments.Assignment_4;
import java.util.Scanner;

public class NumberPattern {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter the value : ");
        int n = sc.nextInt();

        for(int i=1 ; i<=n ; i++){
            
            for(int j=1 ; j<=i ; j++){
                System.out.print(i);
                if(j<i){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        for(int i=n ; i>=2 ; i--){
            
            for(int j=1 ; j<=i ; j++){
                System.out.print(i);
                if(j<i){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        
        sc.close();
    }
}
