public class CompositeTime implements ElapsedTime {

	private Double[] measurements;

	public CompositeTime(Double[] measurements) {
		this.measurements = measurements;
	}

	@Override
	public boolean shorter(ElapsedTime elapsedTime) {
		return getTime() < elapsedTime.getTime();
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

	@Override
	public double getTime() {
		double total = 0.0;

		for (double item : measurements)
			total += item;

		return total;
	}
}
