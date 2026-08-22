package Logic_building.Assignments.Assignment_4;

import java.util.Scanner;

public class CountVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.nextLine();

        str = str.toLowerCase();
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if(str.charAt(i)=='a' || str.charAt(i)=='e' ||str.charAt(i)=='i' ||str.charAt(i)=='o' ||str.charAt(i)=='u' ){
                count++;
            }
        }
        System.out.print("The number of vowels in "+str+" is : "+count);
        sc.close();
    }
}
