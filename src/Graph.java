import java.util.List;

/**
 * Created by lucas on 26/02/2018.
 */
public class Graph {

    List<Node> noeux;

    public Graph(List<Node> noeux) {
        this.noeux = noeux;
    }

    public List<Node> getNoeux() {
        return noeux;
    }

    public void setNoeux(List<Node> noeux) {
        this.noeux = noeux;
    }

    public static boolean estConnexe(Graph graph, Node node, boolean[] estMarque){
        for (int i = 0; i < estMarque.length; i++) {
            if (node.equals(graph.getNoeux().get(i))){
                estMarque[i] = true;
            }
        }

        for (Edge edge : node.getConnections()){
            for (int i = 0; i < estMarque.length; i++) {
                if (edge.getEnd().equals(graph.getNoeux().get(i))){
                    //System.out.println("je passe la");
                    if (!estMarque[i]){
                        //System.out.println("je passe ici");
                        estConnexe(graph, edge.getEnd(), estMarque);
                    }
                }
            }
        }

        for (boolean b : estMarque){
            if (!b) return false;

        }

        return true;


    }
}
