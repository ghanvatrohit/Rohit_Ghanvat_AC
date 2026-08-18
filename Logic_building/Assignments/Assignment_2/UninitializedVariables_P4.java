package Logic_building.Assignments.Assignment_2;

public class UninitializedVariables_P4 {
    static byte a;
    static short b;
    static int c;
    static long d;
    static float e;
    static double f;
    static char g;
    static boolean h;

    public static void main(String[] args) {
        System.out.println("Default byte value: "+ a);
        System.out.println("Default short value: "+b);
        System.out.println("Default int value:"+c);
        System.out.println("Default long value: "+d);
        System.out.println("Default float value: "+e);
        System.out.println("Default double value: "+f);
        System.out.println("Default char value: ["+g+"](Unicode:"+(int)g+")");
        System.out.println("Default boolean value: "+h);

    }
}
