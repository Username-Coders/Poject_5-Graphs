public class AdjGraph {
    
    private boolean[][] edges;      // edges[i][j] is true if there is a vertex from i to j
    private int[] labels;           // labels[i] contains the label for vertex i

    public AdjGraph(int n) {
        edges = new boolean[n][n];  // All values initially false
        labels = new int[n];        // All values initially null
    }
 
    public boolean isEdge(int source, int target) {
        
        return edges[source][target];

    }

    public void addEdge(int source, int target) {

        edges[source][target] = true;

    }

    public int getLabel(int vertex) {

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
    public void setLabel(int vertex, int newLabel) {

        labels[vertex] = newLabel;

    }

    // Accessor method to determine the number of vertices in this graph
    public int getSize() {

        return labels.length;

    }

    public Queue getBreathFirstTraversal(int origin) {


        return null;
    }

    public Queue getDepthFirstTraversal(int origin) {



        return null;
    }

}
