import java.util.Scanner;

public class moveAllZero{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        
        System.out.println("Enter the "+size+" values: ");
        for(int i = 0 ; i<size ; i++){
            arr[i] =sc.nextInt();
        }

        int index = 0;
        for(int i = 0 ; i<size ; i++){
            if(arr[i] != 0 ){
                arr[index] = arr[i];
                index++;
            }
        }

        while(index<size){
            arr[index] = 0;
            index++;
        }

        System.out.println("Move All Zeros to the End");
        for(int i=0 ; i<size ; i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}