import java.util.List;

public class Node {

    int id;
    private String nom;
    private List<Edge> connections;

    public Node(int id, String nom, List<Edge> connections) {
        this.id = id;
        this.nom = nom;
        this.connections = connections;
    }

    public Node(int id, String nom) {
        this.id = id;
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

    @Override
    public String toString() {
        return nom;
    }
}
