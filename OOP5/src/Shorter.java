public interface Shorter<T extends Shorter<? super T>> {
	public boolean shorter(T compare);
}
