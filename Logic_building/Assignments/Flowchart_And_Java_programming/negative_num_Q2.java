package Logic_building.Assignments.Flowchart_And_Java_programming;
import java.util.Scanner;

public class negative_num_Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of X :- ");

        int X=sc.nextInt();

        if(X<0){
            System.out.println("Given number "+X+" is Negative number");
        }else if(X==0){
            System.out.println("Given number is Zero");
        }else{
            System.out.println("Given number "+X+" is not Negative number.");
        }
        sc.close();
    }
}
