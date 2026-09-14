public class Q6_ArrayMaxMin {
	public static void main(String[] argc) {
		System.out.print("Enter size of array: ");
		int size = ConsoleInput.getInt();
		
		Q6_ArrayMaxMinLogic obj = new Q6_ArrayMaxMinLogic(size);
		
		System.out.print("\nEnter "+size+" nuumbers:");
		
		for(int iTemp=0 ; iTemp<size ; iTemp++) {
			obj.setNumber(iTemp,ConsoleInput.getInt());
		}
		System.out.println("\n---- Array ----");
		obj.displayArray();
		
		int maximum = obj.findMaximum();
		int minimum = obj.findMinimum();
		
		System.out.println("\nMaximum value = "+maximum);
		System.out.println("\nMinimum value = "+minimum);
	}
	
}
