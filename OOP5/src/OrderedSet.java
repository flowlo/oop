public class OrderedSet<T extends Shorter<? super T>> extends Set<T> {
	@Override
	public void insert(T value) {
		if (contains(value))
			return;

		if (isEmpty()) {
			head = new Item<T>(value);
			tail = head;
			return;
		}

		if (!head.getValue().shorter(value)) {
			Item<T> item = new Item<T>(value);
			item.setNext(head);
			head = item;
			return;
		}

		Item<T> current = this.head;

		while (current.getNext() != null) {
			if (!current.getNext().getValue().shorter(value)) {
				Item<T> item = new Item<T>(value);
				item.setNext(current.getNext());
				current.setNext(item);
				return;
			}

			current = current.getNext();
		}

		Item<T> item = new Item<T>(value);
		current.setNext(item);
		tail = item;
	}
}
