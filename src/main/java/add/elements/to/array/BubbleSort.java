package add.elements.to.array;

public class BubbleSort {
	
	public static void bubbleSort(int[] array){
		for (int i=0; i<array.length; i++) {
			for (int j=0; j<array.length-1; j++) {
				if(array[j]>array[j+1]) {
					int max = array[j];
					array[j]=array[j+1];
					array[j+1] = max;
				}
			}
		} 
	}
	
	public static void main(String[] args) {
		int array []  = {57,91,1,0,3,5,1,8,11,17,33};
		bubbleSort(array);
		System.out.println("Sorted list : " );
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i] + " ");
		}
		
	}
}
