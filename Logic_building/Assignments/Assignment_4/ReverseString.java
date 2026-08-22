package Logic_building.Assignments.Assignment_4;
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.nextLine();

        for(int i=str.length()-1 ; i>=0 ; i--){
            System.out.print(str.charAt(i));
        }
        sc.close();
    }
}
