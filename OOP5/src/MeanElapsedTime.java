public class MeanElapsedTime implements ElapsedTime {

	private Set<Double> measurements = new Set<Double>();

	@Override
	public boolean shorter(ElapsedTime elapsedTime) {
		// TODO Auto-generated method stub
		return false;
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

}
