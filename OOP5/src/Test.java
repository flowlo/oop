import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		Set<Integer> set = new Set<Integer>();
		set.insert(1);
		set.insert(2);
		set.insert(3);
		
		for (Iterator<Integer> iter = set.iterator(); iter.hasNext();) {
			Integer item = iter.next();
			System.out.println(item);
		}
		
		for (Iterator<Integer> iter = set.iterator(); iter.hasNext();) {
			Integer item = iter.next();
			if (item == 3) {
				
				iter.remove();
			}
		}
		
		System.out.println("\n");
		
		for (Iterator<Integer> iter = set.iterator(); iter.hasNext();) {
			Integer item = iter.next();
			System.out.println(item);
		}
	}
	
	private static boolean test1() {
		OrderedSet<Description> set = new OrderedSet<Description>();
		set.insert(new Description("c"));
		set.insert(new Description("a"));
		set.insert(new Description("b"));
		
		int lines1 = 0;
		for (Description item : set)
			lines1 += item.getLines();
		
		set.insert(new Description("a\n"));
		
		int lines2 = 0;
		for (Description item : set)
			lines2 += item.getLines();
		
		return lines2 == lines1 + 1;
	}
	
	private static boolean test2() {
		OrderedMap<MeanElapsedTime, CompositeTime> map = new OrderedMap<MeanElapsedTime, CompositeTime>();
		//map.insert(new MeanElapsedTime(), new CompositeTime());
		//map.insert(new MeanElapsedTime(), new CompositeTime());
		//map.insert(new MeanElapsedTime(), new CompositeTime());
		return false;
	}
}
