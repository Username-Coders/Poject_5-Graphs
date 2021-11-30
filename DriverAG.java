public class DriverAG {
    
    public static void printTraversalLabels_forMatrix(MatrixGraph matrixGraph, LinkedQueue traversal) {

        for (int i = 0; i < matrixGraph.getSize(); i++) {
            int vertex = traversal.dequeue();
            char label = matrixGraph.getLabel(vertex);

            System.out.print(label + " ");
        }

        System.out.println();
    }

    public static void printTraversalLabels_forList(ListGraph listGraph, LinkedQueue traversal) {

        for (int i = 0; i < listGraph.getSize(); i++) {
            int vertex = traversal.dequeue();
            char label = listGraph.getLabel(vertex);

            System.out.print(label + " ");
        }

        System.out.println();
    }

    public static void main(String []args) {

        // Test code for ListGraph

        ListGraph graphList = new ListGraph(9);

        graphList.setLabel(0,'A');
        graphList.setLabel(1,'B');
        graphList.setLabel(2,'C');
        graphList.setLabel(3,'D');
        graphList.setLabel(4,'E');
        graphList.setLabel(5,'F');
        graphList.setLabel(6,'G');
        graphList.setLabel(7,'H');
        graphList.setLabel(8,'I');

        graphList.addEdge(0,3);
        graphList.addEdge(0,1);
        graphList.addEdge(0,4);

        graphList.addEdge(1,4);

        graphList.addEdge(2,1);

        graphList.addEdge(3,6);

        graphList.addEdge(4,7);
        graphList.addEdge(4,5);

        graphList.addEdge(5,2);
        graphList.addEdge(5,7);

        graphList.addEdge(6,7);

        graphList.addEdge(7,8);

        graphList.addEdge(8,5);

        //graphList.printGraph();

        LinkedQueue traversalBreadth1 = graphList.getBreadthFirstTraversal(0);

        printTraversalLabels_forList(graphList, traversalBreadth1);

        LinkedQueue traversalDepth1 = graphList.getDepthFirstTraversal(0);

        printTraversalLabels_forList(graphList, traversalDepth1);

        System.out.println();

        // Test code for MatrixGraph
        
        MatrixGraph matrixGraph = new MatrixGraph(9);

        matrixGraph.setLabel(0,'A');
        matrixGraph.setLabel(1,'B');
        matrixGraph.setLabel(2,'C');
        matrixGraph.setLabel(3,'D');
        matrixGraph.setLabel(4,'E');
        matrixGraph.setLabel(5,'F');
        matrixGraph.setLabel(6,'G');
        matrixGraph.setLabel(7,'H');
        matrixGraph.setLabel(8,'I');

        matrixGraph.addEdge(0,3);
        matrixGraph.addEdge(0,1);
        matrixGraph.addEdge(0,4);

        matrixGraph.addEdge(1,4);

        matrixGraph.addEdge(2,1);

        matrixGraph.addEdge(3,6);

        matrixGraph.addEdge(4,7);
        matrixGraph.addEdge(4,5);

        matrixGraph.addEdge(5,2);
        matrixGraph.addEdge(5,7);

        matrixGraph.addEdge(6,7);

        matrixGraph.addEdge(7,8);

        matrixGraph.addEdge(8,5);

        //matrixGraph.printGraph();

        LinkedQueue traversalBreadth2 = matrixGraph.getBreadthFirstTraversal(0);

        printTraversalLabels_forMatrix(matrixGraph, traversalBreadth2);

        LinkedQueue traversalDepth2 = matrixGraph.getDepthFirstTraversal(0);

        printTraversalLabels_forMatrix(matrixGraph, traversalDepth2);

        

    }

}
