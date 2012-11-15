import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		OrderedSet<Description> set = new OrderedSet<Description>();
		set.insert(new Description("12345"));
		set.insert(new Description("12"));
		set.insert(new Description("1"));
		set.insert(new Description("1234"));
		set.insert(new Description("123"));
		
		for (Description item : set)
			System.out.println(item);
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
		//OrderedMap<MeanElapsedTime, CompositeTime> map = new OrderedMap<MeanElapsedTime, CompositeTime>();
		//map.insert(new MeanElapsedTime(), new CompositeTime());
		//map.insert(new MeanElapsedTime(), new CompositeTime());
		//map.insert(new MeanElapsedTime(), new CompositeTime());
		return false;
	}
}
