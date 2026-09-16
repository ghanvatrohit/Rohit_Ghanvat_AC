package OOPJ_Assinment.Assignment_2;

class Member {

    private String name;
    private int age;
    private String phoneNumber;
    private String address;
    private float salary;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void printSalary() {
        System.out.println("Salary: " + salary);
    }
}

class PrimeMembers extends Member {

    private int joiningYear;
    private float joiningFees;
    private boolean isActive;

    // Getters and Setters
    public int getJoiningYear() {
        return joiningYear;
    }

    public void setJoiningYear(int joiningYear) {
        this.joiningYear = joiningYear;
    }

    public float getJoiningFees() {
        return joiningFees;
    }

    public void setJoiningFees(float joiningFees) {
        this.joiningFees = joiningFees;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void display() {

        System.out.println("\n----- Member Details -----");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Address: " + getAddress());
        System.out.println("Salary: " + getSalary());

        System.out.println("\n----- Prime Member Details -----");
        System.out.println("Joining Year: " + getJoiningYear());
        System.out.println("Joining Fees: " + getJoiningFees());
        System.out.println("Active: " + isActive());
    }
}

public class Q2_Member {

    public static void main(String[] args) {

        PrimeMembers member = new PrimeMembers();

        System.out.print("Enter Name: ");
        member.setName(ConsoleInput.getString());

        System.out.print("Enter Age: ");
        member.setAge(ConsoleInput.getInt());

        System.out.print("Enter Phone Number: ");
        member.setPhoneNumber(ConsoleInput.getString());

        System.out.print("Enter Address: ");
        member.setAddress(ConsoleInput.getString());

        System.out.print("Enter Salary: ");
        member.setSalary(ConsoleInput.getFloat());

        System.out.print("Enter Joining Year: ");
        member.setJoiningYear(ConsoleInput.getInt());

        System.out.print("Enter Joining Fees: ");
        member.setJoiningFees(ConsoleInput.getFloat());

        System.out.print("Is Active (true/false): ");
        member.setActive(Boolean.parseBoolean(ConsoleInput.getString()));

        member.display();

        member.printSalary();
    }
}
