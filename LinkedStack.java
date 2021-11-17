import java.util.EmptyStackException;

public final class LinkedStack
{
	private Node topNode; // References the first node in the chain
  
   public LinkedStack()
   {
      topNode = null;
   } // end default constructor
  
//  < Implementations of the stack operations go here. >
//  . . .

	private class Node
	{
      private int    data; // Entry in stack
      private Node next; // Link to next node
      
      private Node(int dataPortion)
      {
         this(dataPortion, null);
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


      /** Adds newEntry to the top of the stack.
      * @param newEntry The entry being added to the top of the stack.
      */
      public void push(int newEntry) {

         Node newNode = new Node(newEntry, topNode);
         topNode = newNode;

      } // end push


      /** Remove the top of the stack and return the data of that element.
      * @return T The data of the element at the top of the stack.
      */
      public int pop() {
         
         int top = peek();    // Might throw EmptyStackException
         // Assertion: topNode != null;
         topNode = topNode.getNextNode();
         return top;

      } // end pop


      /** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
         @throws  EmptyStackException if the stack is empty. */
      public int peek() {

         if (isEmpty()) {
            throw new EmptyStackException();
         } else {
            return topNode.getData();
         }

      }// end peek


      /** Checks if the stack is empty.
      * @return boolean True if the stack is empty, false if not.
      */
      public boolean isEmpty() {

         return topNode == null;

      } // end isEmpty
      

      /**
      * Removes the topNode reference to the linked data, clearing the stack.
      */
      public void clear() {

         topNode = null;

      } // end clear


} // end LinkedStack