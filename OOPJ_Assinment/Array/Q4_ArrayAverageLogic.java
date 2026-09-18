package Array;
public class Q4_ArrayAverageLogic {
	private int[] numbers;
	
	//constructor
	public Q4_ArrayAverageLogic(int size) {
		numbers = new int[size];
		
	}
	
	//setter
	public void setNumber(int index , int value) {
		numbers[index] = value;
	}
	
	//calculate averag
	public double calculateAverage() {
		int total = 0 ;
		
		for(int iTemp = 0 ; iTemp < numbers.length; iTemp++) {
			total = total + numbers[iTemp];
		}
		return (double)total/numbers.length;
	}
	
	//Display Array
	public void displayArray() {
		for(int iTemp=0 ; iTemp<numbers.length;iTemp++) {
			System.out.print(numbers[iTemp]+" ");
		}
		System.out.println();
	}
}
