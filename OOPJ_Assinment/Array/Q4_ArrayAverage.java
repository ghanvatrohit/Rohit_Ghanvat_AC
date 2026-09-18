package Array;
public class Q4_ArrayAverage {
	public static void main(String[] args) {
		System.out.println("Enter size of array: ");
		int size = ConsoleInput.getInt();
		
		Q4_ArrayAverageLogic obj = new Q4_ArrayAverageLogic(size);
		
		System.out.println("Enter "+size+" numbers:");
		
		for(int iTemp=0 ; iTemp<size ; iTemp++) {
			obj.setNumber(iTemp,ConsoleInput.getInt());
		}
		
		System.out.println("\n--- Array ----");
		obj.displayArray();
		
		double result = obj.calculateAverage();
		
		System.out.println("\nAverage of array = "+ result);
	}
}
