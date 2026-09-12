class Employee {

    String name;
    int yearOfJoining;
    double salary;
    String address;

    // Constructor
    Employee(String n, int year, double s, String addr) {
        name = n;
        yearOfJoining = year;
        salary = s;
        address = addr;
    }

    public static void main(String[] args) {

        // Creating three employee objects
        Employee e1 = new Employee(
            "Robert", 1994, 50000, "64C- WallsStreet"
        );

        Employee e2 = new Employee(
            "Sam", 2000, 60000, "68D- WallsStreet"
        );

        Employee e3 = new Employee(
            "John", 1999, 55000, "26B- WallsStreet"
        );

        // Printing information
        System.out.println("Name\t\tYear of Joining\t\tAddress");

        System.out.println(
            e1.name + "\t\t" +
            e1.yearOfJoining + "\t\t\t" +
            e1.address
        );

        System.out.println(
            e2.name + "\t\t" +
            e2.yearOfJoining + "\t\t\t" +
            e2.address
        );

        System.out.println(
            e3.name + "\t\t" +
            e3.yearOfJoining + "\t\t\t" +
            e3.address
        );
    }
}