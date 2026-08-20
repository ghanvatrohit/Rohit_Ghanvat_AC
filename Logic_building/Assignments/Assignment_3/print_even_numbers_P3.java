package Logic_building.Assignments.Assignment_3;

public class print_even_numbers_P3 {
    public static void printEvenNumber(){
        int num=1;
        while(num<50){
            if(num%2==0){
                System.out.print(num+" ");
            }
            num++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printEvenNumber();
    }
}
