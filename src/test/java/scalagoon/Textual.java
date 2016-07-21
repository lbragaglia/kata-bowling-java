package scalagoon;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Textual {

  @Parameters
  public static List<StringVal> textual() {
    return Arrays.asList(new StringVal("--", 0), new StringVal("1", 1), new StringVal("13", 4),
        new StringVal("13521", 12), new StringVal("1-5-", 6), new StringVal("1/", 10), new StringVal("1/--", 10),
        new StringVal("1/-5", 15), new StringVal("1/35-", 21), new StringVal("1/3/23", 30), new StringVal("X", 10),
        new StringVal("X--", 10), new StringVal("X--51", 16), new StringVal("X51", 22));
  }

  private final StringVal input;

  public Textual(StringVal input) {
    this.input = input;
  }

  @Test
  public void test() {
    assertEquals(input.expected, new BowlingGame(input.value).score());
  }
}
