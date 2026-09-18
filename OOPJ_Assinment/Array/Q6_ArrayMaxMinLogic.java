package Array;
public class Q6_ArrayMaxMinLogic {
	private int[] numbers;
	
	public Q6_ArrayMaxMinLogic(int size) {
		numbers = new int[size];
	}
	
	public void setNumber(int index, int value) {
		numbers[index] = value;
	}
	
	public int findMaximum() {
		int maximum = numbers[0];
		for(int iTemp = 1; iTemp<numbers.length; iTemp++) {
			if(numbers[iTemp]>maximum) {
				maximum = numbers[iTemp];
			}
		}
		return maximum;
	}
	
	public int findMinimum() {
		int minimum = numbers[0];
		for(int iTemp=1 ; iTemp<numbers.length; iTemp++) {
			if(numbers[iTemp]<minimum) {
				minimum = numbers[iTemp];
			}
		}
		return minimum;
	}
	
	public void displayArray() {
		for(int iTemp=0; iTemp<numbers.length; iTemp++) {
			System.out.print(numbers[iTemp]+" ");
		}
	System.out.println();
}
}
