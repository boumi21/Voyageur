import java.util.List;

/**
 * Created by lucas on 26/02/2018.
 */
public class Node {

    public String nom;
    public List<Edge> connections;

    public Node(String nom, List<Edge> connections) {
        this.nom = nom;
        this.connections = connections;
    }

    public Node(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Edge> getConnections() {
        return connections;
    }

    public void setConnections(List<Edge> connections) {
        this.connections = connections;
    }
}
