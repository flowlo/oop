public class CompositeTime implements ElapsedTime {

	private Double[] measurements;

	public CompositeTime(Double[] measurements) {

	}

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

	public Double getShortestTime() {
		return 0d;
	}
}
