import java.util.Iterator;
import java.util.NoSuchElementException;

public class OrderedMap<K extends Shorter<K>, V> extends OrderedSet<K> {
	protected Entry<K, V> head = null;
	protected Entry<K, V> tail = null;

	@Override
	public void insert(K key) {
		if (contains(key))
			return;

		if (isEmpty()) {
			head = new Entry<K, V>(key);
			tail = head;
			return;
		}

		if (!head.getKey().shorter(key)) {
			Entry<K, V> item = new Entry<K, V>(key);
			item.setNext(head);
			head = item;
			return;
		}

		Entry<K, V> current = this.head;

		while (current.getNext() != null) {
			if (!current.getNext().getKey().shorter(key)) {
				Entry<K, V> item = new Entry<K, V>(key);
				item.setNext(current.getNext());
				current.setNext(item);
				return;
			}

			current = current.getNext();
		}

		Entry<K, V> item = new Entry<K, V>(key);
		current.setNext(item);
		tail = item;
	}

	@Override
	public Iterator<K> iterator() {
		return new EntryIterator<K, V>(this);
	}

	private static class Entry<K, V> {
		private K key;
		private Set<V> value;
		private Entry<K, V> next;

		public Entry(K key) {
			this.key = key;
			this.value = new Set<V>();
			this.next = null;
		}

		public K getKey() {
			return key;
		}

		public Set<V> getValue() {
			return value;
		}

		public void setNext(Entry<K, V> next) {
			this.next = next;
		}

		public Entry<K, V> getNext() {
			return next;
		}

		public void insert(K key) {
			if (next == null) {
				next = new Entry<K, V>(key);
			} else {
				next.insert(key);
			}
		}
	}

	private static class EntryIterator<K extends Shorter<K>, V> extends ItemIterator<K> implements Iterable<V> {
		protected Entry<K, V> current = null;
		protected Entry<K, V> previous = null;
		protected boolean removed = false;
		protected final OrderedMap<K, V> set;

		public EntryIterator(OrderedMap<K, V> set) {
			super(set);
			this.set = set;
		}

		@Override
		public boolean hasNext() {
			return current == null ? set.head != null : current.getNext() != null;
		}

		@Override
		public K next() {
			previous = current;
			current = current == null ? set.head : current.getNext();

			if (current == null)
				throw new NoSuchElementException();

			removed = false;

			return current.getKey();
		}

		@Override
		public void remove() {
			if (current == null || removed)
				throw new IllegalStateException();

			if (previous == null)
				set.head = current.getNext();
			else
				previous.setNext(current.getNext());

			removed = true;
		}

		@Override
		public Iterator<V> iterator() {
			return new EntrySetIterator<V>(current.getValue());
		}
	}

	private static class EntrySetIterator<V> extends ItemIterator<V> {

		public EntrySetIterator(Set<V> set) {
			super(set);
		}

		public void add(V element) {
			Item<V> item = new Item<V>(element);
			item.setNext(current);
			if (previous != null) {
				previous.setNext(item);
			} else {
				set.setHead(item);
			}
		}

		@Override
		public void remove() {
			if (previous != null) {
				previous.setNext(current.getNext());
			} else {
				set.setHead(current.getNext());
			}
		}
	}
}
