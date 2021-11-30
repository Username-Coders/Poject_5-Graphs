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
    
   public LinkedQueue getBreadthFirstTraversal(int origin) {
        
       return null;
   }
                 
    /**
     * Performs depth first traversal on this graph using a stack.
     * @param origin The vertex from which to start the traversal.
     * @return A LinkedQueue containing the traversal order.
     */
     public LinkedQueue getDepthFirstTraversal(int origin) {

      LinkedQueue traversalOrder = new LinkedQueue;
      LinkedStack vertexQueue =   new LinkedStack;

      int visitedCounter = 0;
      int[] visited = new int[labels.length];

      traversalOrder.enqueue(origin);
      vertexStack.push(origin);

      while (!vertexStack.isEmpty())
      {
        int topVertex = vertexStack.peek();
        int[] neighbors = neighbors(topVertex);

        if(hasAnUnVisited(visited, neighbors))
        {
            int nextNeighbor = neighbors[getUnvisited(visited, neighbors)];

            visit(visited, nextNeighbor, visitedCounter);
            visitedCounter++;
            
            traversalOrder.enqueue(nextNeighbor);
            vertexQueue.push(nextNeighbor);
        }

      }
      else
      {
        vertexQueue.pop();
      }
        
    }
    return traversalOrder;  
    public LinkedQueue getDepthFirstTraversal(int origin) {

       
    }


    private void visit(int[] visitedArray, int vertex , int index) {

        visitedArray[index] = vertex;

    }

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
