public class CompositeTime implements ElapsedTime {

	private Double[] measurements;

	public CompositeTime(Double[] measurements) {
		this.measurements = measurements;
	}

	@Override
	public boolean shorter(ElapsedTime elapsedTime) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() {
		return measurements.length;
	}

	public Double getMin() {
		double min = Double.POSITIVE_INFINITY;
		
		for (double item : measurements)
			if (item < min)
				min = item;
		
		return min;
	}
}
