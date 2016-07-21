package scalagoon;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SimplePins {

  @Parameters
  public static List<IntListVal> simplePins() {
    return Arrays.asList(new IntListVal(0, 0, 0), new IntListVal(1, 1), new IntListVal(4, 1, 3),
        new IntListVal(12, 1, 3, 5, 2, 1), new IntListVal(6, 1, 0, 5, 0));
  }

  private final IntListVal input;

  public SimplePins(IntListVal input) {
    this.input = input;
  }

  @Test
  public void test() {
    System.out.println(input.vals);
    assertEquals(input.expected, new BowlingGame(input.vals).score());
  }
}
