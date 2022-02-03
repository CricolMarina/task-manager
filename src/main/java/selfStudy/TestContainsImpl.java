package selfStudy;

public class TestContainsImpl implements TestContains{

	public void containsString(String text, String word) {
		int count = 0;
		int index = text.indexOf(word);
		while(index>=0) {
			count++;
			index = text.indexOf(word, index+1);
			
		} System.out.println("The word occurs " + count + " times in this text");
	}
}
