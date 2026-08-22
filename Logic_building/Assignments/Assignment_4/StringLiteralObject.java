package Logic_building.Assignments.Assignment_4;
public class StringLiteralObject {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        boolean result = str1==str2;
        System.out.println("Both variables point to the same object = "+result);
    }
}
