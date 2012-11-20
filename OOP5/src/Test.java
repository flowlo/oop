import java.util.NoSuchElementException;

public class Test {
	public static void main(String[] args) {

		boolean[] testCorrect = new boolean[4];
		test1(testCorrect);
		OrderedMap<MeanElapsedTime,CompositeTime> mapFromTest2=test2(testCorrect);
		test4(testCorrect,mapFromTest2);
		System.out.println("-----------------------");
		if(testCorrect[0]&&testCorrect[1]&&testCorrect[3])
		{
			System.out.println("All tests correct! (test3 is combined with test2)");
		}
		else System.out.println("TESTS FAILED");
		// Test3 wird int test2() getestet
	
	}
	
	private static void test4(boolean[] testCorrect, OrderedMap<MeanElapsedTime,CompositeTime> inMap)
	{
		System.out.println("\nStart Test 4");
		testCorrect[3]=true;
		OrderedMap.EntryIterator<MeanElapsedTime, CompositeTime> it = inMap.iterator();
		OrderedSet<ElapsedTime> oSet=new OrderedSet<ElapsedTime>();
		
		while(it.hasNext())
		{
			MeanElapsedTime met=it.next();
			oSet.insert(met);
			
			OrderedMap.EntrySetIterator<CompositeTime> innerit = it.iterator();
			
			while(innerit.hasNext())
			{
				CompositeTime ct=innerit.next();
				oSet.insert(ct);
			}
			
		}
		
		int count=0;
		for(ElapsedTime time : oSet)
		{	
			if(count==0)
			{	//Fuer korrekte Werte vergleiche mit Test2
				if(time.getTime()==3.5&&time.count()==3)
					System.out.println("Correct: count is "+time.count());
				else testCorrect[3]=false;
			}
			else if(count==1)
			{
				if(time.getTime()==4.5&&time.count()==3)
					System.out.println("Correct: count is "+time.count());
				else testCorrect[3]=false;
			}
			else if(count==2)
			{
				if(time.getTime()==5.2&&time.count()==2)
					System.out.println("Correct: count is "+time.count());
				else testCorrect[3]=false;
			}
			else if(count==3)
			{
				if(time.getTime()==5.5&&time.count()==3)
					System.out.println("Correct: count is "+time.count());
				else testCorrect[3]=false;
			}
			else if(count==4)
			{
				if(time.getTime()==6.0&&time.count()==3)
					System.out.println("Correct: count is "+time.count());
				else testCorrect[3]=false;
			}
			else if(count==5)
			{
				if(time.getTime()==7.5&&time.count()==4)
					System.out.println("Correct: count is "+time.count());
				else testCorrect[3]=false;
			}
			else if(count==6)
			{
				if(time.getTime()-17.4<0.00001&&time.count()==4) //Rundungsfehler von double
					System.out.println("Correct: count is "+time.count());
				else testCorrect[3]=false;
			}
			else if(count==7)
			{
				if(time.getTime()-17.4<0.00001&&time.count()==4)
					System.out.println("Correct: count is "+time.count());
				else testCorrect[3]=false;
			}
			else if(count==8)
			{
				if(time.getTime()==23.0&&time.count()==4)
					System.out.println("Correct: count is "+time.count());
				else testCorrect[3]=false;
			}
			count++;
		}	
		
		if(testCorrect[3])
			System.out.println("Test 4 correct");
		else System.out.println("Test 4 FAILED");
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
		met1.add(2.5);	//Schnitt 3.5
		met1.add(4.5);
		met1.add(3.5);
		MeanElapsedTime met2 = new MeanElapsedTime();
		met2.add(4.5);	//Schnitt 5.5
		met2.add(6.5);
		met2.add(5.5);
		MeanElapsedTime met3 = new MeanElapsedTime();
		met3.add(3.5);	//Schnitt 4.5
		met3.add(5.5);
		met3.add(4.5);
		timeMap.insert(met1);
		timeMap.insert(met2);
		timeMap.insert(met3);

		OrderedMap.EntryIterator<MeanElapsedTime, CompositeTime> it = timeMap.iterator();
		Double time;
		try {
			if ((time = it.next().getMax()) != 4.5) {
				testCorrect[1] = false;
				System.out.println("  WRONG: Max should be 4.5, but is " + time);
			} else {
				System.out.println("  Correct: Max is 4.5");
			}
			OrderedMap.EntrySetIterator<CompositeTime> innerit = it.iterator();
			innerit.add(new CompositeTime(new Double[] { 2.0, 1.0, 3.0 }));	//Total = 6.0
			innerit.add(new CompositeTime(new Double[] { 5.4, 7.3, 2.8, 7.5 }));	//Total = 23.0
			if ((time = it.next().getMax()) != 5.5) {
				testCorrect[1] = false;
				System.out.println("  WRONG: Max should be 5.5, but is " + time);
			} else {
				System.out.println("  Correct: Max is 5.5");
			}
			innerit = it.iterator();
			innerit.add(new CompositeTime(new Double[] { 1.8, 3.4, 9.4, 2.8 }));	// Total =17.4
			innerit.add(new CompositeTime(new Double[] { 6.4, 0.3, -0.5, 1.3 }));	// Total = 7.5
			innerit.add(new CompositeTime(new Double[] { 6.9, 4.0, 1.3, 5.2 }));	// Total = 17.4
			if ((time = it.next().getMax()) != 6.5) {
				testCorrect[1] = false;
				System.out.println("  WRONG: Max should be 6.5, but is " + time);
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
		met4.add(5.0);	//Schnitt 5.2
		met4.add(5.4);
		timeMap.insert(met4);

		it = timeMap.iterator();
		try {
			if ((time = it.next().getMax()) != 4.5) {
				testCorrect[1] = false;
				System.out.println("  WRONG: Max should be 4.5, but is " + time);
			} else {
				System.out.println("  Correct: Max is 4.5");
			}
			OrderedMap.EntrySetIterator<CompositeTime> innerit = it.iterator();
			try {
				if ((time = innerit.next().getMin()) != 1.0) {
					testCorrect[1] = false;
					System.out.println("    WRONG: Min should be 1.0, but is " + time);
				} else {
					System.out.println("    Correct: Min is 1.0");
				}
				if ((time = innerit.next().getMin()) != 2.8) {
					testCorrect[1] = false;
					System.out.println("    WRONG: Min should be 2.8, but is " + time);
				} else {
					System.out.println("    Correct: Min is 2.8");
				}
				try {
					innerit.next();
					testCorrect[1] = false;
					System.out.println("    WRONG: Too much elements in second iterator of OrderedMap");
				} catch (NoSuchElementException e) {
					System.out.println("    Correct: Two elements in second iterator of OrderedMap");
				}
			} catch (NoSuchElementException e) {
				testCorrect[1] = false;
				System.out.println("    WRONG: Too less elements in second iterator of OrderedMap");
			}
			if ((time = it.next().getMax()) != 5.5) {
				testCorrect[1] = false;
				System.out.println("  WRONG: Max should be 5.5, but is " + time);
			} else {
				System.out.println("  Correct: Max is 5.5");
			}
			innerit = it.iterator();
			try {
				if ((time = innerit.next().getMin()) != 1.8) {
					testCorrect[1] = false;
					System.out.println("    WRONG: Min should be 1.8, but is " + time);
				} else {
					System.out.println("    Correct: Min is 1.8");
				}
				if ((time = innerit.next().getMin()) != -0.5) {
					testCorrect[1] = false;
					System.out.println("    WRONG: Min should be -0.5, but is " + time);
				} else {
					System.out.println("    Correct: Min is -0.5");
				}
				if ((time = innerit.next().getMin()) != 1.3) {
					testCorrect[1] = false;
					System.out.println("    WRONG: Min should be 1.3, but is " + time);
				} else {
					System.out.println("    Correct: Min is 1.3");
				}
				try {
					innerit.next();
					testCorrect[1] = false;
					System.out.println("    WRONG: Too much elements in second iterator of OrderedMap");
				} catch (NoSuchElementException e) {
					System.out.println("    Correct: Three elements in second iterator of OrderedMap");
				}
			} catch (NoSuchElementException e) {
				testCorrect[1] = false;
				System.out.println("    WRONG: Too less elements in second iterator of OrderedMap");
			}
			if ((time = it.next().getMax()) != 5.4) {
				testCorrect[1] = false;
				System.out.println("  WRONG: Max should be 5.4, but is " + time);
			} else {
				System.out.println("  Correct: Max is 5.4");
			}
			if ((time = it.next().getMax()) != 6.5) {
				testCorrect[1] = false;
				System.out.println("  WRONG: Max should be 6.5, but is " + time);
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
