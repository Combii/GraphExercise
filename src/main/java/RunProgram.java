/**
 * Created by David Stovlbaek
 * 30 March 2017.
 */
public class RunProgram {

    public static void main(String[] args) {
        CitiesGraph citiesList = new CitiesGraph();

        citiesList.addVertex("KBH");
        citiesList.addVertex("Helsingør");
        citiesList.addVertex("Slagelse");
        citiesList.addVertex("Nyborg");
        citiesList.addVertex("Odense");
        citiesList.addVertex("Vejle");
        citiesList.addVertex("Aarhus");


        citiesList.addEdge("KBH", "Helsingør", 120);
        citiesList.addEdge("KBH", "Slagelse", 140);
        citiesList.addEdge("KBH", "Odense", 260);
        citiesList.addEdge("Helsingør", "Odense", 380);
        citiesList.addEdge("Slagelse", "Nyborg", 90);
        citiesList.addEdge("Slagelse", "Aarhus", 370);
        citiesList.addEdge("Nyborg", "Odense", 30);
        citiesList.addEdge("Nyborg", "Vejle", 90);
        citiesList.addEdge("Nyborg", "Aarhus", 280);
        citiesList.addEdge("Odense", "Vejle", 60);
        citiesList.addEdge("Vejle", "Aarhus", 190);


        System.out.println(citiesList);

    }
}
