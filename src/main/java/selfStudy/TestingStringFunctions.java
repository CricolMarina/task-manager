package selfStudy;

public class TestingStringFunctions {
	
	public static void main(String[] args) {
		MaxLentgh maxLength = new SearchMaxLength(); 
		String[] strings = new String [] {"colors","black","yellow","red","benjamin-moore"};
		maxLength.searchMaxLength(strings);
		
		TestContains test = new TestContainsImpl();
		String s1 = "I'm waiting for Saturday and Sunday, Sunday to come";
		String s2 = "Sunday";
		test.containsString(s1, s2);
		
		TestPalindrome testPalindrome = new TestPalindromeImpl();
		String word = "asddsa";
		testPalindrome.testIfPalindrome(word);
		
		TestReplace testTest = new TestReplaceImpl();
		String wordToReplace = "summmer";
		String word2 = "winter";
		String text = "Endless summer";
		testTest.replaceWord(text, wordToReplace, word);
	}
}
