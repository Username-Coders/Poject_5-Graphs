import javax.swing.text.AbstractDocument.BranchElement;

public class MatrixGraph {
    
    private boolean[][] edges;      // edges[i][j] is true if there is a vertex from i to j
    private char[] labels;           // labels[i] contains the label for vertex i

    public MatrixGraph(int n) {
        edges = new boolean[n][n];  // All values initially false
        labels = new char[n];        // All values initially null
    }
 
    public boolean isEdge(int source, int target) {
        
        return edges[source][target];

    }

    public void addEdge(int source, int target) {

        edges[source][target] = true;

    }

    public char getLabel(int vertex) {

        return labels[vertex];        

    }

    public int[] neighbors(int vertex) {
        
        //int i;
        int count = 0;
        int[] answer;
        
        for (int i = 0; i < labels.length; i++) {
            if (edges[vertex][i]) {
                count++;
            }
        }

        answer = new int[count];
        count = 0;
        for (int i = 0; i < labels.length; i++) {
            if (edges[vertex][i]) {
                answer[count++] = i;
            }
        }

        return answer;
        
    }

    // Remove an edge
    public void removeEdge(int source, int target) {

        edges[source][target] = false;

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

        for (int k = 0; k < labels.length; k++) {
            
                System.out.print(labels[k] + "      ");

        }
        System.out.println();


        for (int i = 0; i < edges.length; i++) {
            
            for (int j = 0; j < edges[0].length; j++) {
                if (edges[i][j] == false) {
                    System.out.print(edges[i][j] + "  ");
                } else {
                    System.out.print(edges[i][j] + "   ");
                }

                
            }
            System.out.println();
        }

    }


    /**
     * Performs breath first traversal on this graph using a queue.
     * @param origin The vertex from which to start the traversal.
     * @return A LinkedQueue containing the traversal order.
     */
    public LinkedQueue getBreathFirstTraversal(int origin) {
       
            LinkedQueue traversalOrder = new LinkedQueue();     // queue for traversal order
            LinkedQueue vertexQueue = new LinkedQueue();       // queue holds visted vertices
            int visitedCounter = 0 ;
            int[] visited = new int[labels.length];
            
             traversalOrder.enqueue(origin);                // adding vertex to queues
             vertexQueue.enqueue(origin);
            
             while (!vertexQueue.isEmpty()){                    
              int frontVertex = vertexQueue.dequeue();             //removal or vertex in vertex queue
              int[] neighbors = neighbors(frontVertex);             //count of neighbors
              int neighborIndex = 0;

                while (neighborIndex != neighbors.length){              //index of next neighbors 
                   int nextNeighbors = neighbors[neighborIndex];

                  if(isVisited(visited,nextNeighbors) == false) {       // if neighbors is not "visited", 
                    visit(visited, nextNeighbors, visitedCounter);      // then mark as "visited"
                    traversalOrder.enqueue(nextNeighbors);          // add next neightbors to queues
                    vertexQueue.enqueue(nextNeighbors);
                  }
                  neighborIndex++;
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

        LinkedQueue traversalOrder = new LinkedQueue();         // Create queue to track traversal
        LinkedStack vertexStack = new LinkedStack();            // Create stack to track vertex travel
        
        int visitedCounter = 0;                                 // Keeps track of how many visited veteces there are
        int[] visited = new int[labels.length];                 // Array that contains visited verteces

        traversalOrder.enqueue(origin);
        vertexStack.push(origin);

        while (!vertexStack.isEmpty()) {

            int topVertex = vertexStack.peek();
            int[] neighbors = neighbors(topVertex);             // Gets the neighbors of topVertex

            
            if (hasAnUnvisited(visited, neighbors)) {           // Proceed if atleast one neighbor is unvisited 

                // get the nextNeighbor which is unvisited
                int nextNeighbor = neighbors[getUnvisited(visited, neighbors)]; 

                visit(visited, nextNeighbor, visitedCounter);   // Mark nextNeighbor as visited
                visitedCounter++;                               // Increment number of visited

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


}
