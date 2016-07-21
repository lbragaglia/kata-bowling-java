package scalagoon;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FinalFrameTest {

  @Parameters
  public static List<StringVal> finalFrame() {
    return Arrays.asList(new StringVal("1/35XXX458/X3/23", 160), new StringVal("1/35XXX458/X3/XX6", 189),
        new StringVal("1/35XXX458/X35", 149), new StringVal("1/35XXX458/X3/X", 173), new StringVal("XXXXXXXXXXXX", 300),
        new StringVal("XXXXXXXXXX12", 274), new StringVal("1/35XXX458/X3/", 153),
        new StringVal("5/5/5/5/5/5/5/5/5/5/5", 150), new StringVal("9-8/--9-9-9-9-9-9-9/1", 84),
        new StringVal("9-X8-9-9-9-9-9-9-X23", 104));
  }

  private final StringVal input;

  public FinalFrameTest(StringVal input) {
    this.input = input;
  }

  @Test
  public void test() {
    assertEquals(input.expected, new BowlingGame(input.value).score());
  }
}
