public class Scaled<P extends Pict> extends Repeated<Pict> implements Pict {

	public Scaled(Pict[][] array) {
		super(array);
	}

	@Override
	public void scale(double factor) {
		for (Pict[] row : array)
			for (Pict item : row)
				item.scale(factor);
	}
}
