package Logic_building.Assignments.Flowchart_And_Java_programming;
import java.util.Scanner;
public class good_morning_Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter time in 24-hour format (e.g., 5 to 24): ");
        int time = sc.nextInt();

        if(time<=0 && time>=24){
            if(time>=5 && time<12){
                System.out.println("Good Morning");
            }else{
                System.out.println("Not Morning");
            }
        }else{
            System.out.println("Enter time in 24-hour format:");
        }
        sc.close();
    }
}
