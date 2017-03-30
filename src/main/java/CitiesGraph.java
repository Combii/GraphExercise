import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.ListenableUndirectedWeightedGraph;

/**
 * Created by David Stovlbaek
 * 30 March 2017.
 */
class CitiesGraph {

    private final ListenableUndirectedWeightedGraph<String, DefaultWeightedEdge> graph = new ListenableUndirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);

    CitiesGraph() {
    }

    void addVertex(String city){
        graph.addVertex(city);
    }

    void addEdge(String city1, String city2, int weight){
        DefaultWeightedEdge edge = graph.addEdge(city1, city2);
        graph.setEdgeWeight(edge, weight);
    }

    @Override
    public String toString() {
        return graph.toString();
    }
}
