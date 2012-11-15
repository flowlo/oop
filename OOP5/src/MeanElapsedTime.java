public class MeanElapsedTime implements ElapsedTime {

	private Set<Double> measurements = new Set<Double>();

	@Override
	public boolean shorter(ElapsedTime elapsedTime) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void add(Double m) {

	}

	public Double getMax() {
		return 0d;
	}

}
