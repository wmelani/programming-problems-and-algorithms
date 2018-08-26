package datastructures;

import lombok.Getter;
import lombok.Setter;

public class Graph<T> {

    @Getter
    private DynamicList<GraphNode<T>> allNodes;


    Graph() {
        this.allNodes = new DynamicList<>();
    }

    void addNode(GraphNode<T> node) {
        this.allNodes.add(node);
    }

    @Getter
    @Setter
    public static class GraphNode<T> {
        private T value;
        private DynamicList<GraphNode<T>> nodes;

        GraphNode(T value) {
            this(value, new DynamicList<>());
        }

        GraphNode(T value, DynamicList<GraphNode<T>> nodes) {
            this.value = value;
            this.nodes = nodes;
        }
    }
}
