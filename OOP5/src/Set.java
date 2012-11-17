import java.util.Iterator;
import java.util.NoSuchElementException;

public class Set<T> implements Iterable<T> {
	protected Item<T> head = null;
	protected Item<T> tail = null;

	public void insert(T value) {
		if (!contains(value)) {
			if (isEmpty()) {
				head = new Item<T>(value);
				tail = head;
			} else {
				Item<T> item = new Item<T>(value);
				tail.setNext(item);
				tail = item;
			}
		}
	}

	public void setHead(Item<T> newHead) {
		this.head = newHead;
		Item<T> current = head;
		while (current.getNext() != null) {
			current = current.getNext();
		}
		tail = current;
	}

	@Override
	public Iterator<T> iterator() {
		return new ItemIterator<T>(this);
	}

	protected boolean contains(T value) {
		for (T item : this)
			if (item == value)
				return true;

		return false;
	}

	protected boolean isEmpty() {
		return head == null;
	}

	protected static class Item<T> {
		private Item<T> next = null;
		private T value = null;

		public Item(T value) {
			this.value = value;
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

	protected static class ItemIterator<T> implements Iterator<T> {
		protected Item<T> current = null;
		protected Item<T> previous = null;
		protected boolean removed = false;
		protected final Set<T> set;

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

			removed = false;

			return current.getValue();
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
	}
}
