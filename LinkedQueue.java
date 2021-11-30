import java.util.NoSuchElementException;

public class LinkedQueue 
{
   private Node firstNode; // References node at front of queue
   private Node lastNode;  // References node at back of queue
  	
	public LinkedQueue()
	{
		firstNode = null;
		lastNode = null;
	} // end default constructor

//  < Implementations of the queue operations go here. >
//  . . .

	private class Node
	{
		private int  data; // Entry in queue
		private Node next; // Link to next node
      
		private Node(int dataPortion)
		{
			data = dataPortion;
			next = null;
		} // end constructor
		
		private Node(int dataPortion, Node linkPortion)
		{
			data = dataPortion;
			next = linkPortion;
		} // end constructor
      
		private int getData()
		{
			return data;
		} // end getData
      
		private void setData(int newData)
		{
			data = newData;
		} // end setData
      
		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode
	} // end Node
	
	/** Adds a new entry to the back of this queue.
	 @param newEntry  An object to be added. */
	public void enqueue(int newEntry) {
		
		Node newNode = new Node(newEntry,null);

		if (isEmpty()) {
			firstNode = newNode;
		} else {
			lastNode.setNextNode(newNode);
		}

		lastNode = newNode;
		
	}

	/** Removes and returns the entry at the front of this queue.
		 @return  The object at the front of the queue. 
		@throws  EmptyQueueException if the queue is empty before the operation. */
	public int dequeue() {

		int front = getFront();

		//firstNode.setData(null);
		firstNode = firstNode.getNextNode();

		if (firstNode == null) {
			lastNode = null;
		}

	return front;
	}
	
	/**  Retrieves the entry at the front of this queue.
		 @return  The object at the front of the queue.
		@throws  EmptyQueueException if the queue is empty. */
	public int getFront() {

		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return firstNode.getData();
		}

	}

	public int getBack() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return lastNode.getData();
		}
	}
	
	/** Detects whether this queue is empty.
		 @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty() {

		return (firstNode == null) && (lastNode == null);

	}
	
	/** Removes all entries from this queue. */
	public void clear() {

		firstNode = null;
		lastNode = null;

	}





} // end LinkedQueue