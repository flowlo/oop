import java.util.Iterator;
import java.util.NoSuchElementException;

public class Set<T> implements Iterable<T> {
	private Item<T> head = null;

	public void insert(T value) {
		head = new Item<T>(value, head);
	}

	public Iterator<T> iterator() {
		return new ItemIterator<T>(this);
	}

	private static class Item<T> {
		private Item<T> next = null;
		private T value = null;

		public Item(T value, Item<T> next) {
			this.value = value;
			this.next = next;
		}

		public T getValue() {
			return value;
		}

		public Item<T> getNext() {
			return next;
		}
		
		public void setNext(Item<T> value) {
			next = value;
		}
	}

	private static class ItemIterator<T> implements Iterator<T> {
		private Item<T> current;
		private Item<T> previous = null;;
		private Set<T> set;

		public ItemIterator(Set<T> set) {
			this.set = set;
			this.current = set.head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (current == null)
				throw new NoSuchElementException();

			T result = current.getValue();
			previous = current;
			current = current.getNext();

			return result;
		}

		@Override
		public void remove() {
			if (current != null)
				if (previous == null)
					set.head = current.getNext();
				else
					previous.setNext(current.getNext());
		}
	}
}
