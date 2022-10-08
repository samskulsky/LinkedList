import java.util.Objects;

// Implements a singly-linked list.


public class SinglyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int nodeCount;

	// Constructor: creates an empty list
	public SinglyLinkedList() {
		nodeCount = 0;
		head = null;
		tail = null;
	}

	// Constructor: creates a list that contains
	// all elements from the array values, in the same order
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SinglyLinkedList(Object[] values) {
		if (values.length == 0) {
			nodeCount = 0;
			head = null;
			tail = null;
		} else {
			nodeCount = 1;
			head = new ListNode(values[0]);

			ListNode last = head;

			for (int i = 1; i < values.length; i++) {
				ListNode ln = new ListNode(values[i]);
				last.setNext(ln);

				if (i == values.length - 1)
					tail = ln;
				else
					last = ln;

				nodeCount++;
			}
		}
	}

	public ListNode<E> getHead() {
		return head;
	}

	public ListNode<E> getTail() {
		return tail;
	}

	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty() {
		return nodeCount == 0;
	}

	// Returns the number of elements in this list.
	public int size() {
		return nodeCount;
	}

	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(E obj) {
		for (ListNode node = head; node != null; node = node.getNext()) {
			if (Objects.equals(node.getValue(),equals(obj))) return true;
		}

		return false;
	}

	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(E obj) {
		int i = 0;

		for (ListNode node = head; node != null; node = node.getNext()) {
			if (node.getValue().equals(obj)) return i;
			i++;
		}

		return -1;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	@SuppressWarnings("rawtypes")
	public boolean add(E obj) {
		ListNode newLN = new ListNode(obj);

		if (nodeCount == 0) {
			head = newLN;
			tail = newLN;
			nodeCount++;
			return true;
		}

		tail.setNext(newLN);

		tail = newLN;

		nodeCount++;

		return true;
	}

	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	@SuppressWarnings("unchecked")
	public boolean remove(E obj) {
		ListNode last = head;

		if (Objects.equals(head.getValue(), obj)) {
			head = head.getNext();
			return true;
		}

		for (ListNode<E> node = head.getNext(); node != null; node = node.getNext()) {
			if (Objects.equals(node.getValue(), obj) && node.getNext() != null) {
				last.setNext(node.getNext());
				nodeCount--;
				return true;
			} else if (Objects.equals(node.getValue(), obj)) {
				tail = last;
				last.setNext(null);
				nodeCount--;
				return true;
			}

			last = node;
		}

		return false;
	}

	// Returns the i-th element.               
	@SuppressWarnings("unchecked")
	public E get(int i) {
		if (i > nodeCount) throw new IndexOutOfBoundsException();

		int j = 0;

		for (ListNode<E> node = head; node != null; node = node.getNext()) {
			if (i == j)
				return node.getValue();
			j++;
		}

		return null;
	}

	// Replaces the i-th element with obj and returns the old value.
	@SuppressWarnings("unchecked")
	public E set(int i, Object obj) {
		int j = 0;

		E old = null;

		ListNode last = head;

		for (ListNode<E> node = head; node != null; node = node.getNext()) {
			if (i == j) {
				old = node.getValue();
				ListNode ln = new ListNode(obj);
				last.setNext(ln);
				ln.setNext(node.getNext());
				break;
			}
			last = node;
			j++;
		}

		return old;
	}

	// Inserts obj to become the i-th element. Increments the size
	// of the list by one.
	@SuppressWarnings("unchecked")
	public void add(int i, Object obj) {
		int j = 0;

		ListNode last = head;

		for (ListNode<E> node = head; node != null; node = node.getNext()) {
			if (i == j) {
				ListNode ln = new ListNode(obj);
				last.setNext(ln);
				ln.setNext(node);
				nodeCount++;
				break;
			}
			last = node;
			j++;
		}
	}

	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	@SuppressWarnings("unchecked")
	public E remove(int i) {
		ListNode last = head, old = null;
		
		int  j = 1;

		if (i == 0) {
			old = head;
			head = head.getNext();
			return (E) old.getValue();
		}

		for (ListNode<E> node = head.getNext(); node != null; node = node.getNext()) {
			if (i == j && node.getNext() != null) {
				old = node;
				last.setNext(node.getNext());
				nodeCount--;
				return (E) old.getValue();
			} else if (i == j) {
				old = node;
				tail = last;
				last.setNext(null);
				nodeCount--;
				return (E) old.getValue();
			}

			last = node;
			j++;
		}

		return null;
	}

	// Returns a string representation of this list exactly like that for MyArrayList.
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (ListNode<E> node = head; node != null; node = node.getNext()) {
			sb.append(node.getValue());
			if (node.getNext() != null)
				sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}


}
