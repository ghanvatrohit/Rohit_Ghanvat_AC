package Logic_building.Assignments.Assignment_4;

public class StringConcatenation {
    public static void main(String[] args) {
    String str1 = "hello";
    String str2 = "world";
    String str3 = str1+str2;
    boolean result = str1==str3;
    System.out.println("Both variables point to the same object = "+result);
    }
    
}
