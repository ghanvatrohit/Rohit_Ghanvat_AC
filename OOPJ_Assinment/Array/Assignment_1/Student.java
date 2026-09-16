class Student {
    String name;
    int roll_no;
    String phone_no;
    String address;

    public static void main(String[] args) {

        // Part (a)
        Student s1 = new Student();

        s1.roll_no = 2;
        s1.name = "John";

        System.out.println("Part A:");
        System.out.println("Name: " + s1.name);
        System.out.println("Roll No: " + s1.roll_no);

        // Part (b)
        Student sam = new Student();

        sam.name = "Sam";
        sam.roll_no = 1;
        sam.phone_no = "9876543210";
        sam.address = "Mumbai";

        Student john = new Student();

        john.name = "John";
        john.roll_no = 2;
        john.phone_no = "9123456780";
        john.address = "Pune";

        System.out.println("\nPart B:");

        System.out.println("Sam Details:");
        System.out.println("Roll No: " + sam.roll_no);
        System.out.println("Phone No: " + sam.phone_no);
        System.out.println("Address: " + sam.address);

        System.out.println("\nJohn Details:");
        System.out.println("Roll No: " + john.roll_no);
        System.out.println("Phone No: " + john.phone_no);
        System.out.println("Address: " + john.address);
    }
}