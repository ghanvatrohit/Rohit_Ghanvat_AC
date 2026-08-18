package Logic_building.Assignments.Assignment_2;
import java.util.Scanner;
public class days_of_week_P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the day number 1 to 7 = ");
        int day = sc.nextInt();

        switch(day){
            case 1:
            System.out.println("The day is Monday.");
            break;
            case 2:
            System.out.println("The day is Tuesday.");
            break;
            case 3:
            System.out.println("The day is Wednesday.");
            break;
            case 4:
            System.out.println("The day is Thursday.");
            break;
            case 5:
            System.out.println("The day is Friday.");
            break;
            case 6:
            System.out.println("The day is Saturday.");
            break;
            case 7:
            System.out.println("The day is Sunday.");
            break;
            default:
            System.out.println("Invalid day number");
            break;
        }
        sc.close();
    }
}
