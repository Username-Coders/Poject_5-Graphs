import java.util.Arrays;

public class ListGraph {

    //private Node firstNode;
    private Node[] vertexLists;
    private char[] labels;

    // Default constructor
    public ListGraph(int n) {

        labels = new char[n];
        vertexLists = new Node[n];

        for (int i = 0; i < n; i++) {
            //Node newNode = new Node();

            vertexLists[i] = new Node(i);
        }

        
    }

    public boolean isEdge(int source, int target) {
        boolean itsAnEdge = false;
        
        
        for (int i = 0; i < vertexLists.length; i++) {
            Node temp = vertexLists[source].next;

            while (temp != null) {

                if (temp.data == target) {
                    itsAnEdge = true;
                    break;
                }

                temp = temp.next;
            }

            if (itsAnEdge) {
                break;
            }

        }

        return itsAnEdge;

    }

    public void addEdge(int source, int target) {

        Node sourceLink = vertexLists[source];
        Node newEdge = new Node(target);
        
        if (sourceLink.next == null) {

            sourceLink.next = newEdge;

        } else {

            Node temp = sourceLink.next;
            sourceLink.next = newEdge;
            newEdge.next = temp;

        }

    }

    public char getLabel(int vertex) {

        return labels[vertex];

    }

    /**
     * 
     * @param vertex
     * @return
     */
    public int[] neighbors(int vertex) {
        
        int[] answer;
        int counter = 0;
        Node vertexPointer = vertexLists[vertex];

        int edgeListSize = 0;
        Node temp = vertexPointer;
        while (temp.next != null) {
            temp = temp.next;
            edgeListSize++;
        }

        answer = new int[edgeListSize];

        while (vertexPointer.next != null) {
           answer[counter] = vertexPointer.next.data;
           vertexPointer = vertexPointer.next;
           counter++;
        }

        Arrays.sort(answer,0,edgeListSize);

        return answer;
    }

    // Remove an edge
    public void removeEdge(int source, int target) {
 
        Node sourceLink = vertexLists[source];
        boolean nodeFound = false;

        if (sourceLink.next != null) {
            Node nodePointer = sourceLink.next;
            Node prevNode = sourceLink;

            while (nodePointer != null && nodeFound == false) {
                


                if (nodePointer.data == target) {
                    
                    nodeFound = true;
                    Node temp = nodePointer.next;
                    prevNode.next = temp;
                    

                } else {
                    prevNode = nodePointer;
                    nodePointer = nodePointer.next;
                }

            }

        }
       
    }

    // Change the label of a vertex of this graph
    public void setLabel(int vertex, char newLabel) {

        labels[vertex] = newLabel;

    }

    // Accessor method to determine the number of vertices in this graph
    public int getSize() {

        return labels.length;
        
    }

    public void printGraph() {

        for (int i = 0; i < vertexLists.length; i++) {
            Node temp = vertexLists[i].next;
            
            while (temp != null) {

                System.out.print(labels[temp.data] + " ");

                temp = temp.next;
            }
            System.out.println();

        }

    }

    /**
     * Performs breath first traversal on this graph using a queue.
     * @param origin The vertex from which to start the traversal.
     * @return A LinkedQueue containing the traversal order.
     */
    public LinkedQueue getBreadthFirstTraversal(int origin) {

        LinkedQueue traversalOrder = new LinkedQueue();           // queue for traversal order
        LinkedQueue vertexQueue = new LinkedQueue();            // queue for vertex queue order
        int visitedCounter = 0 ;
        int[] visited = new int[labels.length];
        
         traversalOrder.enqueue(origin);                // adding vertex to queues
         vertexQueue.enqueue(origin);
        
         while (!vertexQueue.isEmpty()){
          int frontVertex = vertexQueue.dequeue();      //removal or vertex in vertex queue
          int[] neighbors = neighbors(frontVertex);     //count of neighbors
          int neighborIndex = 0;

            while (neighborIndex != neighbors.length){          //index of next neighbors 
                int nextNeighbors = neighbors[neighborIndex];

              if(isVisited(visited,nextNeighbors) == false) {           // if neighbors is not "visited",
                visit(visited, nextNeighbors, visitedCounter);          // then mark as "visited"
                traversalOrder.enqueue(nextNeighbors);                 // add next neightbors to queues
                vertexQueue.enqueue(nextNeighbors);
              }
              neighborIndex++;                  //increses of neighbor count 
        }
    }

    return traversalOrder;        
}


    /**
     * Performs depth first traversal on this graph using a stack.
     * @param origin The vertex from which to start the traversal.
     * @return A LinkedQueue containing the traversal order.
     */
    public LinkedQueue getDepthFirstTraversal(int origin) {

        LinkedQueue traversalOrder = new LinkedQueue();             // Create queue to track traversal
        LinkedStack vertexStack = new LinkedStack();                // Create stack to track vertex travel
        
        int visitedCounter = 0;                                     // Keeps track of how many visited veteces there are
        int[] visited = new int[labels.length];                     // Array that contains visited verteces

        traversalOrder.enqueue(origin);
        vertexStack.push(origin);

        while (!vertexStack.isEmpty()) {

            int topVertex = vertexStack.peek();
            int[] neighbors = neighbors(topVertex);                 // Gets the neighbors of topVertex

            
            if (hasAnUnvisited(visited, neighbors)) {               // Proceed if atleast one neighbor is unvisited

                int nextNeighbor = neighbors[getUnvisited(visited, neighbors)];

                visit(visited, nextNeighbor, visitedCounter);       // Mark nextNeighbor as visited
                visitedCounter++;                                   // Increment number of visited

                traversalOrder.enqueue(nextNeighbor);
                vertexStack.push(nextNeighbor);

            } else {
                vertexStack.pop();
            }

        }

        return traversalOrder;
    }


    // Adds a vertex to the visitedArray at a given index
    private void visit(int[] visitedArray, int vertex , int index) {

        visitedArray[index] = vertex;

    }


    // Checks if the given vertex is contained within visited
    private boolean isVisited(int[] visited, int vertex) {

        boolean result = false;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == vertex) {
                result = true;
                break;
            }
        }

        return result;
        
    }


    // Checks if at least one neighbor is not in visited
    private  boolean hasAnUnvisited(int[] visited, int[] neighbor) {
        
        boolean unvisitedExists = false;
        
        for (int i = 0; i < neighbor.length; i++) {
            int neighborChosen = neighbor[i];

            if (!isVisited(visited, neighborChosen)) {
                unvisitedExists = true;
            }


        }
        
        return unvisitedExists;

    }

    // gets the first neighbor that is unvisited
    private int getUnvisited(int[] visited, int[] neighbor) {

        int result = 0;

        for (int i = 0; i < neighbor.length; i++) {
            int neighborChosen = neighbor[i];

            if (!isVisited(visited, neighborChosen)) {
                result = i;
                break;
            }

        }

        return result;
    }

    // Member inner class Node for linked data
    private class Node {
        
        private int data;             // Data of the node
        private Node next;          // Reference to the next Node in chain

        // Default constructor
        private Node(int nodeData) {
            this(nodeData, null);   // Passes params to full contructor 
        }

        // More complete constructor that sets Node data
        private Node(int nodeData, Node nextNode) {
            data = nodeData;
            next = nextNode;
        }

    }
    
}
