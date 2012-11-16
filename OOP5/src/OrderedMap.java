import java.util.Iterator;

public class OrderedMap<K extends Shorter<K>, V> extends OrderedSet<OrderedMap.Entry<K, V>> {

	private Entry<K, V> entries = null;

	@Override
	public void insert(K key) {
		if (contains(key))
			return;
		super.insert(key);

	}

	public void insert(K key, V value) {
	}

	@Override
	public Iterator<Entry<K, V>> iterator() {
		return null;
	}

	public static class Entry<K extends Shorter<K>, V> implements Shorter<K> {
		private Entry<K, V> next = null;
		private K key = null;
		private V value = null;

		public Entry(K key, V value, Entry<K, V> next) {
			this.value = value;
			this.next = next;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public Entry<K, V> getNext() {
			return next;
		}

		public void setNext(Entry<K, V> next) {
			this.next = next;
		}

		@Override
		public boolean shorter(K compare) {
			return key.shorter(compare);
		}
	}

	private static class EntryIterator<K, V> {
		public EntryIterator() {

		}
	}
}
