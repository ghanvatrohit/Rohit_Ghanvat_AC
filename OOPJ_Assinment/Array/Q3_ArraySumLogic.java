package Array;
public class Q3_ArraySumLogic {
	private int[] numbers;
	
	//constructor
	public Q3_ArraySumLogic(int size) {
		numbers = new int[size];
	}
	
	//setter
	public void setNumber(int index, int value) {
		numbers[index] = value;
	}
	
	//sum
	public int sum() {
		int total = 0;
		
		for(int iTemp=0 ; iTemp<numbers.length ; iTemp++) {
			total = total + numbers[iTemp];
		}
		
		return total;
	}
	
	//display
	public void displayArray() {
		for(int iTemp=0 ; iTemp<numbers.length ; iTemp++) {
			System.out.print(numbers[iTemp]+" ");
		}
		System.out.println();
	}
}
