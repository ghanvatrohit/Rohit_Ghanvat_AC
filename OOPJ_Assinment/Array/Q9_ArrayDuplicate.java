public class Q9_ArrayDuplicate {
	public static void main(String[] args) {
		System.out.print("Enter size of array:");
		int size = ConsoleInput.getInt();
		
		Q9_ArrayDuplicateLogic obj = new Q9_ArrayDuplicateLogic(size);
		
		System.out.println("\nEnter "+size+" numbers:");
		
		for(int iTemp=0; iTemp<size; iTemp++) {
			obj.setNumber(iTemp,ConsoleInput.getInt());
		}
		
		System.out.println("\n--- Original Array ---");
		obj.displayArray();
		
		System.out.println("\n--- Duplicate values ---");
		obj.findDuplicates();
	}
}
