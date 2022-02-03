package selfStudy;

public class TestPalindromeImpl implements TestPalindrome {

	public boolean testIfPalindrome(String word) {
		boolean ifPalindrome = true;
		int j = word.length();
		for (int i=0; i<(j/2); i++) {
			if((word.charAt(i)) != (word.charAt(j-1-i))) {
				ifPalindrome = false;
			} 
		}
		if(ifPalindrome) {
			System.out.println("This word is a palindrome");
		} else {
			System.out.println("This word is not a palindrome");
		}
		return ifPalindrome;
	}
}
