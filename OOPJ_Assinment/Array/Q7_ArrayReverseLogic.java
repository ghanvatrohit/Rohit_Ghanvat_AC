public class Q7_ArrayReverseLogic {
	private int[] numbers;
	
	public Q7_ArrayReverseLogic(int size) {
		numbers = new int[size];
	}
	
	public void setNumber(int index, int value) {
		numbers[index] = value;
	}
	
	public void displayArray() {
		for(int iTemp=0 ; iTemp<numbers.length ;iTemp++) {
			System.out.print(numbers[iTemp]+" ");
		}
		System.out.println();
	}
	
	public void diplayReverseArray() {
		for(int iTemp=numbers.length-1; iTemp>=0 ; iTemp--) {
			System.out.print(numbers[iTemp]+" ");
		}
		System.out.println();
	}
}
