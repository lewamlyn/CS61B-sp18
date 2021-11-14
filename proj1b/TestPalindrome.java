import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne one = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("1"));
        assertFalse(palindrome.isPalindrome("Aaa"));
        assertTrue(palindrome.isPalindrome("aAa"));
        assertTrue(palindrome.isPalindrome("AaaA"));
        assertTrue(palindrome.isPalindrome("racecar"));
    }

    @Test
    public void testPalindrome() {
        assertTrue(palindrome.isPalindrome("", one));
        assertTrue(palindrome.isPalindrome("1", one));
        assertTrue(palindrome.isPalindrome("flake", one));
        assertTrue(palindrome.isPalindrome("flke", one));
        assertFalse(palindrome.isPalindrome("AsA", one));
    }
}
