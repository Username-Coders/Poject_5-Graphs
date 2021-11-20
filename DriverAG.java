public class DriverAG {
  
    public static void main(String []args) {

        ListGraph graphList = new ListGraph(4);

        graphList.setLabel(0,0);
        graphList.setLabel(1,1);
        graphList.setLabel(2,2);
        graphList.setLabel(3,3);

        graphList.addEdge(0,0);
        graphList.addEdge(0,2);
        graphList.addEdge(1,0);
        graphList.addEdge(2,3);
        graphList.addEdge(3,0);
        graphList.addEdge(3,2);

        System.out.println(graphList.isEdge(0,2));

        //graphList.removeEdge(0, 2);

        System.out.println(graphList.isEdge(0, 2));

        graphList.printGraph();


    }

}
