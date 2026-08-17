package Logic_building.Assignments.Flowchart_And_Java_programming;
import java.util.Scanner;

public class positive_num_Q1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of X :- ");

        int X = sc.nextInt();

        if(X>0){
            System.out.println("Given number is a positive number.");
        }else{
            System.out.println("Given number is not a positive number.");
        }

        sc.close();
    }
}
