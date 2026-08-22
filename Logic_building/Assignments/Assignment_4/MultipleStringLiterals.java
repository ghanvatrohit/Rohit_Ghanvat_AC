package Logic_building.Assignments.Assignment_4;

public class MultipleStringLiterals {
    public static void main(String[] args) {
        String str1 = "java";
        String str2 = "java";
        String str3 = "java";

        boolean result = (str1 == str2) && (str2 == str3);
        System.out.println("All string to the sam object? " + result);

    }
}
