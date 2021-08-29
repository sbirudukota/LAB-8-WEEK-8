
/*Exercise 1
Modify the main method of the Driver class from Lab #7. In this method, do the following:
1. Create instances of an ArrayQ and a LinkedQueue
2. Enqueue the following int's onto the two queues: (1,7,3,4,9,2)
3. Dequeue all the elements from the queues, displaying each int as it's removed
*/
import java.util.NoSuchElementException;

public class DriverLinkedQueue<T> {
// Objects of the class Elem are used to store the elements of the
// list.

	public static class ElementValue<T> {
		private final T value;
		private ElementValue<T> previous;
		private ElementValue<T> next;

		private ElementValue(T value, ElementValue<T> previous, ElementValue<T> next) {
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
	}

	private final ElementValue<T> headVersion;
	private int size;

	public DriverLinkedQueue() {
		headVersion = new ElementValue<T>(null, null, null);
		headVersion.next = headVersion;
		headVersion.previous = headVersion;
		size = 0;
	}

	// Returns the size of the list.

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return headVersion == null;
	}

	public T first() {
		if (headVersion == null)
			return null;
		return headVersion.value;
	}

	private void addAfter(ElementValue<T> before, T object) {
		ElementValue<T> after = before.next;
		before.next = new ElementValue<T>(object, before, after);
		after.previous = before.next;
		size++;
	}

	// Inserts the specified element at the beginning of this list.

	public void addFirst(T object) {
		if (object == null) {
			throw new NullPointerException();
		}

		addAfter(headVersion, object);

	}

	// Inserts the specified element at the end of this list.

	public void enqueue(T object) {

		if (object == null) {
			throw new NullPointerException();
		}

		addAfter(headVersion.previous, object);
	}

// Helper method. Removes the specified node.
	private void remove(ElementValue<T> current) {
		ElementValue<T> before = current.previous, after = current.next;
		before.next = after;
		after.previous = before;
		size--;
	}

	// Removes the first element from this list.

	public void dequeue() {
		if (size == 0) {
			throw new NoSuchElementException();
		}
		remove(headVersion.next);
	}

	// Returns a String representation of this list.

	public String toString() {
		StringBuffer stringBuffer = new StringBuffer("{");
		ElementValue<T> elementValue = headVersion.next;
		while (elementValue != headVersion) {
			stringBuffer.append(elementValue.value);
			if (elementValue.next != headVersion) {
				stringBuffer.append(",");
			}
			elementValue = elementValue.next;
		}
		stringBuffer.append("}");
		return stringBuffer.toString();
	}

	public static void main(String args[]) {
		DriverLinkedQueue<Integer> driverLinkedQueue = new DriverLinkedQueue<Integer>();
		driverLinkedQueue.enqueue(1);
		driverLinkedQueue.enqueue(7);
		driverLinkedQueue.enqueue(3);
		driverLinkedQueue.enqueue(4);
		driverLinkedQueue.enqueue(9);
		driverLinkedQueue.enqueue(2);

		System.out.println("Display Queued elements");
		System.out.println(driverLinkedQueue.toString());
		driverLinkedQueue.dequeue();
		System.out.println("Display After removing first element:");
		System.out.println(driverLinkedQueue.toString());

	}
}
