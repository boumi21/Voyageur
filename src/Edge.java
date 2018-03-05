/**
 * Created by lucas on 26/02/2018.
 */
public class Edge {

    public Node start;
    public Node end;
    public double valeur;

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
