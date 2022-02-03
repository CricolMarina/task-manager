package selfStudy;

public class SearchMaxLength implements MaxLentgh {

	public void searchMaxLength(String[] strings) {
		int maxLength = 0;
		for(int i=0; i<strings.length-1; i++) {
			for (int j=1; j<strings.length; j++) {
				if((strings[i].length())<(strings[j].length())) {
					maxLength=strings[j].length();
				}
			}
		} 
		System.out.println("The max lenght in this array is : " + maxLength);
	}
}
