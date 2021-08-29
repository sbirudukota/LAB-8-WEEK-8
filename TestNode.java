class Node {
	int key;
	Node next;

// constructor
	public Node(int key) {
		this.key = key;
		this.next = null;
	}
}

public class TestNode {
	Node front, rear;
	public int size;

	public TestNode() {
		this.front = null;
		this.rear = null;
		this.size = 0;
	}

// Method to add an key to the queue.
	void enqueue(int key) {
// Create a Linked List node
		Node node = new Node(key);
// For empty, new node is front and rear both
		if (this.rear == null) {
			this.front = node;
			this.rear = node;
			this.size++;
			return;
		}
		System.out.println("Enqueued item in LinkedQueue is " + key);
		this.rear.next = node;
		this.rear = node;
		this.size++;
	}

// Method to remove an key from queue.
	Node dequeue() {
// If queue is empty, return NULL.
		if (this.front == null)
			throw new NullPointerException("LinkedQueue is empty.");
// Store previous node to front and delete current front
		Node node = this.front;
		System.out.println("Dequeued item from LinkedQueue is " + this.front.key);
		this.front = this.front.next;
		if (this.front == null)
			this.rear = null;
		this.size--;
		return node;
	}

// Get Size
	public int getSize() {
		return this.size;
	}

	public void removeMiddle() {
		Node curr = front;
		int length = 0;
		Node middle = front;
		while (curr.next != null) {
			length++;
			if (length % 2 == 0) {
				middle = middle.next;
			}
			curr = curr.next;
		}
		if (length % 2 == 1) {
			middle = middle.next;
		}
		System.out.println("middle element of LinkedQueue : " + middle.key);
	}



}