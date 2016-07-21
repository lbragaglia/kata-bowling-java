package scalagoon;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.summingInt;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	static class Frame {

		static final int TEN = 10;
		final List<Integer> rolls = new ArrayList<>();

		public void addRoll(Integer i) {
			rolls.add(i);
		}

		public boolean isOver() {
			return isStrike() || rolls.size() >= 2;
		}

		public boolean requiresMoreRolls() {
			if (isStrike() && rolls.size() < 3) {
				return true;
			}
			if (isSpare() && rolls.size() < 3) {
				return true;
			}
			return !isOver();
		}

		private boolean isSpare() {
			return rolls.size() > 1 && rolls.get(0) + rolls.get(1) == TEN;
		}

		private boolean isStrike() {
			return rolls.size() > 0 && rolls.get(0) == TEN;
		}

		public Integer getScore() {
			return rolls.stream().mapToInt(Integer::intValue).sum();
		}

	}

	List<Frame> frames = new ArrayList<>();

	public BowlingGame(List<Integer> rolls) {
		addRolls(rolls);
	}

	public BowlingGame(String textRolls) {
		addRolls(fromText(textRolls));
	}

	private List<Integer> fromText(String value) {
		final List<Integer> vals = new ArrayList<>();
		asList(value.split("")).stream().forEach(c -> {
			switch (c) {
			case "X":
				vals.add(10);
				break;
			case "-":
				vals.add(0);
				break;
			case "/":
				vals.add(10 - vals.get(vals.size() - 1));
				break;
			default:
				vals.add(Integer.valueOf(c));
				break;
			}
		});
		return vals;
	}

	private void addRolls(List<Integer> vals) {
		vals.stream().forEach(i -> addRoll(i));
	}

	private void addRoll(Integer i) {
		nextTurnIfRequired();

		frames.stream().forEach((f) -> {
			if (f.requiresMoreRolls()) {
				f.addRoll(i);
			}
		});
	}

	private void nextTurnIfRequired() {
		if (currentFrame().isOver() && frames.size() < 10) {
			nextTurn();
		}
	}

	private void nextTurn() {
		frames.add(new Frame());
	}

	private Frame currentFrame() {
		if (frames.isEmpty()) {
			nextTurn();
		}
		return frames.get(frames.size() - 1);
	}

	public int score() {
		return frames.stream().collect(summingInt(f -> f.getScore()));
	}

}
