public class Q9_ArrayDuplicateLogic {
	private int[] numbers;
	
	public Q9_ArrayDuplicateLogic(int size) {
		numbers = new int[size];
	}
	
	public void setNumber(int index, int value) {
		numbers[index]=value;
	}
	
	public void findDuplicates() {
		for(int iTemp=0; iTemp<numbers.length-1; iTemp++) {
			for(int jTemp=iTemp+1; jTemp<numbers.length; jTemp++) {
				if(numbers[iTemp]==numbers[jTemp]) {
					System.out.println("Duplicate value = "+numbers[iTemp]);
					break;
				}
			}
		}
	}
	public void displayArray() {
		for(int iTemp=0; iTemp<numbers.length; iTemp++) {
			System.out.print(numbers[iTemp]+" ");
		}
		System.out.println();
	}
}
