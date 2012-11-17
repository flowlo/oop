import java.util.Iterator;
import java.util.NoSuchElementException;

public class Test {
	public static void main(String[] args) {

		boolean[] testCorrect = new boolean[4];
		test1(testCorrect);
		test2(testCorrect);
	}

	private static void test1(boolean[] testCorrect) {
		System.out.println("Test1 started");
		testCorrect[0] = true;

		OrderedSet<Description> descriptionSet = new OrderedSet<Description>();
		descriptionSet.insert(new Description("1\n2\n3\n4\n5"));
		descriptionSet.insert(new Description("1\n2"));
		descriptionSet.insert(new Description("1\n2\n3\n4"));
		descriptionSet.insert(new Description("1\n2\n3"));

		int i = 2;
		for (Description item : descriptionSet) {
			if (item.getLines() == i) {
				System.out.println("    Correct: " + item.getLines());
			} else {
				testCorrect[0] = false;
				System.out.println("    WRONG: " + item.getLines());
			}
			i += 1;
		}

		if (i == 6) {
			System.out.println("  Correct: " + (i - 2) + " entries");
		} else {
			testCorrect[0] = false;
			System.out.println("  WRONG: " + (i - 2) + " entries");
		}

		descriptionSet.insert(new Description("1"));

		i = 1;
		for (Description item : descriptionSet) {
			if (item.getLines() == i) {
				System.out.println("    Correct: " + item.getLines());
			} else {
				testCorrect[0] = true;
				System.out.println("    WRONG: " + item.getLines());
			}
			i += 1;
		}

		if (i == 6) {
			System.out.println("  Correct: " + (i - 1) + " entries");
		} else {
			testCorrect[0] = false;
			System.out.println("  WRONG: " + (i - 1) + " entries");
		}

		descriptionSet.insert(new Description("1\n2\n3\n4\n5\n6"));

		i = 1;
		for (Description item : descriptionSet) {
			if (item.getLines() == i) {
				System.out.println("    Correct: " + item.getLines());
			} else {
				testCorrect[0] = false;
				System.out.println("    WRONG: " + item.getLines());
			}
			i += 1;
		}

		if (i == 7) {
			System.out.println("  Correct: " + (i - 1) + " entries");
		} else {
			testCorrect[0] = false;
			System.out.println("  WRONG: " + (i - 1) + " entries");
		}

		if (testCorrect[0]) {
			System.out.println("Test1 correct");
		} else {
			System.out.println("Test1 FAILED");
		}
	}

	private static OrderedMap<MeanElapsedTime, CompositeTime> test2(boolean[] testCorrect) {
		System.out.println("Test2 started");
		testCorrect[1] = true;

		OrderedMap<MeanElapsedTime, CompositeTime> timeMap = new OrderedMap<MeanElapsedTime, CompositeTime>();
		MeanElapsedTime met1 = new MeanElapsedTime();
		met1.add(2.5);
		met1.add(4.5);
		met1.add(3.5);
		MeanElapsedTime met2 = new MeanElapsedTime();
		met2.add(4.5);
		met2.add(6.5);
		met2.add(5.5);
		MeanElapsedTime met3 = new MeanElapsedTime();
		met3.add(3.5);
		met3.add(5.5);
		met3.add(4.5);
		timeMap.insert(met1);
		timeMap.insert(met2);
		timeMap.insert(met3);

		Iterator<MeanElapsedTime> it = timeMap.iterator();
		try {
			if (it.next().getMax() != 4.5) {
				testCorrect[1] = false;
				System.out.println("  WRONG: Max should be 4.5");
			} else {
				System.out.println("  Correct: Max is 4.5");
			}
			if (it.next().getMax() != 5.5) {
				testCorrect[1] = false;
				System.out.println("  WRONG: Max should be 5.5");
			} else {
				System.out.println("  Correct: Max is 5.5");
			}
			if (it.next().getMax() != 6.5) {
				testCorrect[1] = false;
				System.out.println("  WRONG: Max should be 6.5");
			} else {
				System.out.println("  Correct: Max is 6.5");
			}
			try {
				it.next();
				testCorrect[1] = false;
				System.out.println("  WRONG: Too many entries in OrderedMap");
			} catch (NoSuchElementException e) {
				System.out.println("  Correct: Three entries in OrderedMap");
			}
		} catch (NoSuchElementException e) {
			testCorrect[1] = false;
			System.out.println("  WRONG: Too less entries in OrderedMap");
		}

		MeanElapsedTime met4 = new MeanElapsedTime();
		met4.add(5.0);
		met4.add(5.4);
		timeMap.insert(met4);

		it = timeMap.iterator();
		try {
			if (it.next().getMax() != 4.5) {
				testCorrect[1] = false;
				System.out.println("  WRONG: Max should be 4.5");
			} else {
				System.out.println("  Correct: Max is 4.5");
			}
			if (it.next().getMax() != 5.5) {
				testCorrect[1] = false;
				System.out.println("  WRONG: Max should be 5.5");
			} else {
				System.out.println("  Correct: Max is 5.5");
			}
			if (it.next().getMax() != 5.4) {
				testCorrect[1] = false;
				System.out.println("  WRONG: Max should be 5.4");
			} else {
				System.out.println("  Correct: Max is 5.4");
			}
			if (it.next().getMax() != 6.5) {
				testCorrect[1] = false;
				System.out.println("  WRONG: Max should be 6.5");
			} else {
				System.out.println("  Correct: Max is 6.5");
			}
			try {
				it.next();
				testCorrect[1] = false;
				System.out.println("  WRONG: Too many entries in OrderedMap");
			} catch (NoSuchElementException e) {
				System.out.println("  Correct: Four entries in OrderedMap");
			}
		} catch (NoSuchElementException e) {
			testCorrect[1] = false;
			System.out.println("  WRONG: Too less entries in OrderedMap");
		}

		if (testCorrect[1]) {
			System.out.println("Test2 correct");
		} else {
			System.out.println("Test2 FAILED");
		}
		return timeMap;
	}
}
