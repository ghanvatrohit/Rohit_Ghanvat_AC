package Array;
public class Q8_ArrayDuplicate {
	public static void main(String[] args) {
		System.out.println("Enter size of array: ");
		int size = ConsoleInput.getInt();
		
		Q8_ArrayDuplicateLogic obj = new Q8_ArrayDuplicateLogic(size);
		
		System.out.println("\nEnter "+size+" numbers:");
		
		for(int iTemp = 0 ; iTemp<size; iTemp++) {
			obj.setNumber(iTemp,ConsoleInput.getInt());
		}
		
		System.out.println("\n--- original Array ---");
		obj.displayArray();
		
		System.out.println("\n--- Duplicate Values ---");
		obj.findDuplicates();
	}
}
