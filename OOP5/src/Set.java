import java.util.Iterator;
import java.util.NoSuchElementException;

public class Set<T> implements Iterable<T> {
	private Item<T> head = null;
	
	public void insert(T value) {
		head = new Item<T>(value, head);
	}

	public Iterator<T> iterator() {
		return new ItemIterator<T>(head);
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
	}
	
	private static class ItemIterator<T> implements Iterator<T> {
		private Item<T> current;
		
		public ItemIterator(Item<T> current) {
			this.current = current;
		}
		
		@Override
		public boolean hasNext() {
			return current.getNext() != null;
		}

		@Override
		public T next() {
			if (current == null)
				throw new NoSuchElementException();
			
			T result = current.getValue();
			current = current.getNext();
			
			return result;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}
		
	}
}
