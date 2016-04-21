import org.junit.*;
import static org.junit.Assert.*;

public class AnagramTest {

  @Test
  public void compareCatAndAct_returnString_is() {
    Anagram testWord = new Anagram();
    assertEquals(true, testWord.checkAnagram("cat", "act"));
  }

}
