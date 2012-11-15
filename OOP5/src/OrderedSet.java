public class OrderedSet<T extends Shorter<T>> extends Set<T> {
	public void insert(T value) {
		if (contains(value))
			return;
		
		if (isEmpty()) {
			head = new Item<T>(value, null);
			return;
		}
		
		if (!head.getValue().shorter(value)) {
			head = new Item<T>(value, head);
			return;
		}
		
		Item<T> current = this.head;
		
		while (current.getNext() != null) {
			if (!current.getNext().getValue().shorter(value)) {
				current.setNext(new Item<T>(value, current.getNext()));
				return;
			}
			
			current = current.getNext();
		}
		
		current.setNext(new Item<T>(value, null));
	}
}
