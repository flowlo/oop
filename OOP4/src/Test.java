public class Test {
	public static void main(String[] args) {
		

		AbstractBox[][] boxes =new AbstractBox[][]{
				new AbstractBox[]{new ClearBox(1,1), new DarkBox(3,4,'o'), new ClearBox(2,4)},
				new AbstractBox[]{new ClearBox(5,5), new DarkBox(4,2,'o'), new ClearBox(5,5)}
		};
		
		Scaled<AbstractBox> r=new Scaled<AbstractBox>(boxes);
		System.out.println(r);
		r.scale(0.5);
		
		System.out.println(r);
	/*	new ClearBox()
		Pict[][] picts = new Pict[][] {
				new Pict[] { new Box(3, 3), new ClearBox(4, 4), new DarkBox(3, 5, '~'), new Box(6, 6), new ClearBox(7, 5) },
				new Pict[] { new DarkBox(7, 6, 'X'), new Box(4, 4), new ClearBox(3, 5), new Box(7, 2), new Box(2, 2) },
				new Pict[] { new Box(1, 1), new Box(1, 2), new Box(2, 1), new Box(2, 2), new ClearBox(2, 2)},
				new Pict[] { new Box(3, 3), new ClearBox(4, 4), new DarkBox(3, 5, '~'), new Box(6, 6), new ClearBox(7, 5) },
				new Pict[] { new DarkBox(7, 6, 'X'), new Box(4, 4), new ClearBox(3, 5), new Box(7, 2), new Box(2, 2) },
			};*/
	
		
	//	Repeated<Pict> r = new Repeated<Pict>(picts);
	//	System.out.println(r.toString());
	}
}
