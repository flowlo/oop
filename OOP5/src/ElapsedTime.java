public interface ElapsedTime<K> extends Shorter<K> {
	@Override
	public boolean shorter(K elapsedTime);

	public double getTime();

	public int count();
}
