package OOPJ_Assinment.Assignment_2;

class Parent {

    void parentMethod() {
        System.out.println("This is parent class");
    }
}

class Child extends Parent {

    void childMethod() {
        System.out.println("This is child class");
    }
}

public class Q1_Inheritance {

    public static void main(String[] args) {

        // 1. Method of parent class by object of parent class
        Parent p = new Parent();
        p.parentMethod();

        // 2. Method of child class by object of child class
        Child c = new Child();
        c.childMethod();

        // 3. Method of parent class by object of child class
        c.parentMethod();
    }
}