import java.util.Iterator;
import java.util.NoSuchElementException;

public class Set<T> implements Iterable<T> {
	private Item<T> head = null;

	public void insert(T value) {
		for (T item : this)
			if (item == value)
				return;
		
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
		private Item<T> current = null;
		private Item<T> previous = null;
		private final Set<T> set;

		public ItemIterator(Set<T> set) {
			this.set = set;
		}

		@Override
		public boolean hasNext() {
			return current == null ? set.head != null : current.getNext() != null;
		}

		@Override
		public T next() {
			previous = current;
			current = current == null ? set.head : current.getNext();
			
			if (current == null)
				throw new NoSuchElementException();
			
			return current.getValue();
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
