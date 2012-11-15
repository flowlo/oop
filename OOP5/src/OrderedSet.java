public class OrderedSet<T extends Shorter> extends Set<T> {
	public void insert(T value) {
		if (contains(value))
			return;
		
		if (isEmpty()) {
			head = new Item<T>(value, null);
			return;
		}
		
		Item<T> current = this.head;
		
		while (true) {
			if (current.getNext() == null) {
				current.setNext(new Item<T>(value, null));
				return;
			}
			
			if (!current.getNext().getValue().shorter(value)) {
				
			}
		}
	}
}
