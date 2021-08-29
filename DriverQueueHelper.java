
public class DriverQueueHelper {

	public static void main(String[] args) {
		System.out.println(" Linked Queue ");
		TestNode testNode = new TestNode();

		testNode.enqueue(3);
		testNode.enqueue(7);
		testNode.enqueue(2);
		testNode.enqueue(4);
		testNode.enqueue(5);
		
		testNode.removeMiddle();
		testNode.dequeue();
		testNode.dequeue();
		System.out.println("Array Queue");
		ArrayQueue queue = new ArrayQueue(4);
		queue.enqueue(2);
//		queue.dequeue();
		queue.enqueue(9);
		queue.enqueue(1);
		queue.enqueue(4);
		queue.dequeue();
		queue.dequeue();

	}

}
