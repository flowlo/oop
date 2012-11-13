public class Test {
	public static void main(String[] args) {
		Pict[][] picts = new Pict[][] {
				new Pict[] { new Box(3, 3), new ClearBox(4, 4), new DarkBox(3, 5, '~'), new Box(6, 6), new ClearBox(7, 5) },
				new Pict[] { new DarkBox(7, 6, 'X'), new Box(4, 4), new ClearBox(3, 5), new Box(7, 2), new Box(2, 2) },
				new Pict[] { new Box(1, 1), new Box(1, 2), new Box(2, 1), new Box(2, 2), new ClearBox(2, 2)},
				new Pict[] { new Box(3, 3), new ClearBox(4, 4), new DarkBox(3, 5, '~'), new Box(6, 6), new ClearBox(7, 5) },
				new Pict[] { new DarkBox(7, 6, 'X'), new Box(4, 4), new ClearBox(3, 5), new Box(7, 2), new Box(2, 2) },
			};
		
		Pict free = new FreeBox("1234\n5678");
		free.scale(1.5);
		System.out.println(free);
		
		Repeated<Pict> r = new Repeated<Pict>(picts);
		System.out.println(r.toString());
	}
}
