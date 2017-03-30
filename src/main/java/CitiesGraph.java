import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.ListenableUndirectedWeightedGraph;

import java.util.Set;

/**
 * Created by David Stovlbaek
 * 30 March 2017.
 */
class CitiesGraph {

    private final ListenableUndirectedWeightedGraph<String, DefaultWeightedEdge> graph = new ListenableUndirectedWeightedGraph<>(DefaultWeightedEdge.class);

    CitiesGraph() {
    }

    ListenableUndirectedWeightedGraph<String, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    void addVertex(String city){
        graph.addVertex(city);
    }

    void addEdge(String city1, String city2, int weight){
        DefaultWeightedEdge edge = graph.addEdge(city1, city2);
        graph.setEdgeWeight(edge, weight);
    }


    String getAdjacentVertices(String city){
        StringBuilder rString = new StringBuilder(city + ":\n");

        Set<DefaultWeightedEdge> vertex =  graph.edgesOf(city);

        for(DefaultWeightedEdge edge : vertex){
            if(graph.getEdgeTarget(edge).equals(city))
                rString.append(graph.getEdgeSource(edge) + " " + graph.getEdgeWeight(edge) + "\n");
            else
            rString.append(graph.getEdgeTarget(edge) + " " + graph.getEdgeWeight(edge) + "\n");
        }
        return rString.toString();
    }

    @Override
    public String toString() {
        return graph.toString();
    }
}
