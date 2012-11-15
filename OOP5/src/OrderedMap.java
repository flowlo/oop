import java.util.Iterator;

public class OrderedMap<K, V> extends OrderedSet<K> {
	public void insert(K key, V value) {
	}
	
	public Iterator<Entry<K, V>> iterator() {
		return new EntryIterator();
	}
	
	public static class Entry<K, V> {
		
	}
	
	private static class EntryIterator<K, V> {
		public EntryIterator() {
			
		}
	}
}
