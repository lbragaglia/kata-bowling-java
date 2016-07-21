package scalagoon;

import java.util.Arrays;
import java.util.List;

class IntListVal {

	public final List<Integer> vals;
	public final int expected;
	
	IntListVal(int expected, Integer... vals) {
		this.expected = expected;
		this.vals= Arrays.asList(vals);
	}
	
}
