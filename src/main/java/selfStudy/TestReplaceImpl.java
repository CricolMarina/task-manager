package selfStudy;

public class TestReplaceImpl implements TestReplace{
	
	public void replaceWord(String text, String word, String word2) {
		String newText = text.replace(word, word2);
		System.out.println(newText);
	}
}
