package Logic_building.Assignments.Assignment_4;

public class StringNewKeyword {
    public static void main(String[] args) {

        String str1 =new String("hello");
        String str2 =new String("hello");

        boolean result = str1 == str2;
        boolean result2 = str1.equals(str2);
        
        System.out.println("using == : " + result);
        System.out.println("using .equals : " + result2);
    }

}
