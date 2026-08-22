package Logic_building.Assignments.Assignment_4;

import java.util.Scanner;

public class StringPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.nextLine();

        String reverse = "";
        for(int i=str.length()-1 ; i>=0 ; i--){
            reverse = reverse + str.charAt(i);
        }

        if(str.equals(reverse)){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
        sc.close();
    }
}
