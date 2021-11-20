public class ListGraph {

    //private Node firstNode;
    private Node[] vertexLists;
    private int[] labels;

    // Default constructor
    public ListGraph(int n) {

        labels = new int[n];
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

    public int getLabel(int vertex) {

        return labels[vertex];

    }

    public int[] neighbors(int vertex) {
        
       

        return null;
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
    public void setLabel(int vertex, int newLabel) {

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

                System.out.print(temp.data + " ");

                temp = temp.next;
            }
            System.out.println();

        }

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
