package scalagoon;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ShortSpares {

  @Parameters
  public static List<IntListVal> shortSpares() {
    return Arrays.asList(new IntListVal(10, 1, 9), new IntListVal(10, 1, 9, 0, 0), new IntListVal(15, 1, 9, 0, 5),
        new IntListVal(21, 1, 9, 3, 5, 0), new IntListVal(30, 1, 9, 3, 7, 2, 3));
  }

  private final IntListVal input;

  public ShortSpares(IntListVal input) {
    this.input = input;
  }

  @Test
  public void test() {
    assertEquals(input.expected, new BowlingGame(input.vals).score());
  }
}
