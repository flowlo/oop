public class MeanElapsedTime implements ElapsedTime {

	private Set<Double> measurements = new Set<Double>();

	@Override
	public boolean shorter(ElapsedTime elapsedTime) {
		return getTime() < elapsedTime.getTime();
	}

	@Override
	public int count() {
		int count = 0;

		for (Double item : measurements)
			count++;
		
		return count;
	}

	public void add(double value) {
		measurements.insert(value);
	}

	public double getMax() {
		double max = Double.NEGATIVE_INFINITY;
		
		for (Double item : measurements)
			if (item > max)
				max = item;
		
		return max;
	}

	@Override
	public double getTime() {
		double total = 0.0;
		int count = 0;
		
		for (Double item : measurements) {
			count++;
			total += item;
		}
		
		return total / count;
	}
}
