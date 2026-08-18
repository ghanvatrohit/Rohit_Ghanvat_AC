package Logic_building.Assignments.Assignment_2;
import java.util.Scanner;

public class grade_evaluation_P1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Maths marks = ");
        float maths = sc.nextInt();
        System.out.print("Enter the Science marks = ");
        float science = sc.nextInt();
        System.out.print("Enter the History marks = ");
        float History = sc.nextInt();

        float average = (maths+science+History)/3.0f;
        System.out.println("Average marks = "+ (int) average);

        if(average>=90.0f){
            System.out.println("Grade = A");
        }else if(average>=70.0f && average<=89.0f){
            System.out.println("Grade = B");
        }else if(average>=50.0f && average<=69.0f){
            System.out.println("Grade = C");
        }else if(average>=30.0f && average<=49.0f){
            System.out.println("Grade = D");
        }else{
            System.out.println("Fail");
        }
        sc.close();
    }
}
