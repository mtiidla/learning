package ee.mtiidla.cci.graphs;

public class Graph {

    Node[] nodes;

    public static class Node {
        int data;
        Node[] children;
        boolean visited;
    }

}
