package Logic_building.Assignments.Assignment_3;
import java.util.Scanner;

public class multiplication_table_P5 {
    public static void printMultiplicationTable(int num){
        
        for(int i=1 ; i<=10 ;i++ ){
            System.out.println(num +" x "+i+" = " + (num * i) );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number = ");
        int num = sc.nextInt();

        printMultiplicationTable(num);

        sc.close();
    }
}
