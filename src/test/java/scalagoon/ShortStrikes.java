package scalagoon;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ShortStrikes {

  @Parameters
  public static List<IntListVal> shortStikes() {
    return Arrays.asList(new IntListVal(10, 10), new IntListVal(10, 10, 0, 0), new IntListVal(16, 10, 0, 0, 5, 1),
        new IntListVal(22, 10, 5, 1));
  }

  private final IntListVal input;

  public ShortStrikes(IntListVal input) {
    this.input = input;
  }

  @Test
  public void test() {
    assertEquals(input.expected, new BowlingGame(input.vals).score());
  }
}
