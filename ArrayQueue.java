
public class ArrayQueue {

	private int qCapacity;
	int qArr[];
	int front = 0;
	int rear = -1;
	int size = 0;

	public ArrayQueue(int size) {
		this.qCapacity = size;
		this.qArr = new int[this.qCapacity];
	}

	/**
	 * this method adds element at the end of the queue.
	 * 
	 * @param element
	 */
	public void enqueue(int element) {
		if (isFull()) {
			throw new IndexOutOfBoundsException("Overflow!! Cannot add more elements!!!");
		} else {
			rear++;
			if (rear == qCapacity - 1) {
				rear = 0;
			}

			qArr[rear] = element;
			this.size++;
		}
		System.out.println("Enqueued item is " + qArr[rear]);

		System.out.println("Queue Capacity:" + qCapacity + " Current Size:" + size);

	}

	/**
	 * this method removes an element from the top of the queue
	 */
	public void dequeue() {
		if (isEmpty()) {
			throw new NullPointerException("Queue is empty. More elements cannot be deleted!!!");
		} else {
			System.out.println("Dequeued item is " + qArr[front]);
			front++;
			if (front == qCapacity - 1)
				front = 0;
			this.size--;
			System.out.println("Queue Capacity:" + qCapacity + " Current Size:" + size);
		}
	}

	/**
	 * Queue Full Check
	 * 
	 * @return boolean
	 */
	public boolean isFull() {
		boolean status = false;
		if (size == qCapacity) {
			status = true;
		}
		return status;
	}

	/**
	 * Queue Empty Check
	 * 
	 * @return Boolean
	 */
	public boolean isEmpty() {
		boolean status = false;
		if (size == 0) {
			status = true;
		}
		return status;
	}

}
