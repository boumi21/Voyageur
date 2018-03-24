/**
 * Created by lucas on 26/02/2018.
 */
public class Edge {

    private Node start;
    private Node end;
    private double valeur;

    public Edge(Node start, Node end, double valeur) {
        this.start = start;
        this.end = end;
        this.valeur = valeur;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
}
