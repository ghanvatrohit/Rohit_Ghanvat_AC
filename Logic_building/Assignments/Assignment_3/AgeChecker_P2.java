package Logic_building.Assignments.Assignment_3;
import java.util.Scanner;

public class AgeChecker_P2 {

    public static void checkAgeCategory(int age){
        if(age<0){
            System.out.println("Invalid Input");
        }else if(age<18){
            System.out.println("You are a minor.");
        }else if(age<65){
            System.out.println("You are a adult");
        }else{
            System.out.println("You are a senior citizen.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the age = ");
        int age = sc.nextInt();

        checkAgeCategory(age);

        sc.close();
    }
}
