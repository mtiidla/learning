package ee.mtiidla.cci.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class GraphSearch {

    public Graph.Node depthFirstSearch(Graph graph, int value) {

        for (Graph.Node node : graph.nodes) {
            Graph.Node result = depthFirstSearch(node, value);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    private Graph.Node depthFirstSearch(Graph.Node node, int value) {
        if (node.data == value) {
            return node;
        }
        node.visited = true;
        for (Graph.Node child : node.children) {
            if (!child.visited) {
                Graph.Node result = depthFirstSearch(child, value);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    public Graph.Node breadthFirstSearch(Graph graph, int value) {
        for (Graph.Node node : graph.nodes) {
            Graph.Node result = breadthFirstSearch(node, value);
            if (result != null) {
                return result;
            }
        }

        return null;
    }

    private Graph.Node breadthFirstSearch(Graph.Node root, int value) {
        Queue<Graph.Node> queue = new LinkedList<>();
        root.visited = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            Graph.Node node = queue.poll();
            if (node.data == value) {
                return node;
            }
            for (Graph.Node child : node.children) {
                if (!child.visited) {
                    child.visited = true;
                    queue.add(child);
                }
            }
        }
        return null;
    }

}
