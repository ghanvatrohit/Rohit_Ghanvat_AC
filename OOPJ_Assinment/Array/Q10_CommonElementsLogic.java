
public class Q10_CommonElementsLogic {
	private int[] firstArray;
	private int[] secondArray;
	
	public Q10_CommonElementsLogic(int size1, int size2) {
		firstArray = new int[size1];
		secondArray = new int[size2];
	}
	
	public void setFirstArrayNumber(int index,int value) {
		firstArray[index]=value;
	}
	
	public void setSecondArrayNumber(int index, int value) {
		secondArray[index]=value;
	}
	
	public void displayFirstArray() {
		for(int iTemp = 0 ; iTemp<firstArray.length; iTemp++) {
			System.out.print(firstArray[iTemp]+" ");
		}
		System.out.println();
	}
	public void displaySecondArray() {

        for (int iTemp = 0; iTemp < secondArray.length; iTemp++) {

            System.out.print(secondArray[iTemp] + " ");
        }

        System.out.println();
    }
	
	public void findCommonElements() {
		for(int iTemp =0 ; iTemp<firstArray.length; iTemp++) {
			for(int jTemp=0 ; jTemp<secondArray.length; jTemp++) {
				if(firstArray[iTemp]==secondArray[jTemp]) {
					System.out.println(firstArray[iTemp]);
					break;
				}
			}
		}
	}
}
