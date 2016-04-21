import java.util.Arrays;

public class Anagram {

  public Boolean checkAnagram(String word1, String word2) {

    char[] word1Array = word1.toLowerCase().toCharArray();
    char[] word2Array = word2.toLowerCase().toCharArray();
    
    Arrays.sort(word1Array);
    Arrays.sort(word2Array);

    return Arrays.equals(word1Array, word2Array);
  }
}
