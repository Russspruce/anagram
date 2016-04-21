import java.util.Arrays;

public class Anagram {

  public Boolean checkAnagram(String word1, String word2) {
    // word1 = word1.toLowerCase();
    // word2 = word2.toLowerCase();

    char[] word1Array = word1.toLowerCase().toCharArray();
    char[] word2Array = word2.toLowerCase().toCharArray();

    Arrays.sort(word1Array);
    Arrays.sort(word2Array);

    if (Arrays.equals(word1Array, word2Array)) {
      return true;
    } else {
      return false;
    }
  }
}
