package Array;
public class Q7_ArrayReverse {
	public static void main(String[] args) {
		System.out.println("Enter size of array:");
		int size = ConsoleInput.getInt();
		
		Q7_ArrayReverseLogic obj = new Q7_ArrayReverseLogic(size);
		
		System.out.println("\nEnter "+size+" numbers:");
		
		for(int iTemp= 0 ; iTemp<size ; iTemp++) {
			obj.setNumber(iTemp,ConsoleInput.getInt());
		}
		
		System.out.println("\n--- original Array ---");
		obj.displayArray();
		
		System.out.println("\n--- Revese Array ---");
		obj.diplayReverseArray();
	}
}
