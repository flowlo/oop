public interface ElapsedTime extends Shorter<ElapsedTime> {
	@Override
	public boolean shorter(ElapsedTime elapsedTime);

	public double getTime();

	public int count();
}
