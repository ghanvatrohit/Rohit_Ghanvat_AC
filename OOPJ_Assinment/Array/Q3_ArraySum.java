
public class Q3_ArraySum {
	public static void main(String[] args) {
		
		System.out.print("Enter size of the array: ");
		int size = ConsoleInput.getInt();
		
	Q3_ArraySumLogic obj = new Q3_ArraySumLogic(size);
	
	System.out.println("Enter "+size+" numbers: ");
	
	for(int iTemp = 0 ; iTemp<size ; iTemp++) {
		System.out.print("Enter element "+(iTemp+1)+": ");
		obj.setNumber(iTemp,ConsoleInput.getInt());
	}
	
	System.out.println("\n--- Array ---");
	obj.displayArray();
	
	int result = obj.sum();
	
	System.out.println("\nSum of array = "+result);
	}
}
