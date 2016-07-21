package scalagoon;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NormalPlay {

  @Parameters
  public static List<StringVal> normalPlays() {
    return Arrays.asList(new StringVal("1/35XXX45", 103), new StringVal("11111111112222222222", 30),
        new StringVal("--------------------", 0), new StringVal("1-1----------------1", 3),
        new StringVal("9-9-9-9-9-9-9-9-9-9-", 90), new StringVal("5/11------------3/11", 26),
        new StringVal("9-8/--9-9-9-9-9-9-9-", 82), new StringVal("--8/1---------------", 12),
        new StringVal("--8/-1--------------", 11), new StringVal("9-X8-9-9-9-9-9-9-9-", 98),
        new StringVal("--X81--------------", 28), new StringVal("--X8-1-------------", 27));
  }

  private final StringVal input;

  public NormalPlay(StringVal input) {
    this.input = input;
  }

  @Test
  public void test() {
    assertEquals(input.expected, new BowlingGame(input.value).score());
  }
}
