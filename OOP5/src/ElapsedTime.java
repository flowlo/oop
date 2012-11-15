public interface ElapsedTime extends Shorter<ElapsedTime> {
	@Override
	public boolean shorter(ElapsedTime elapsedTime);

	public int count();
}
