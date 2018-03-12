import java.util.ArrayList;

/**
 * Created by lucas on 26/02/2018.
 */
public class Voyageur {

    public static void main(String[] args) {

        Node paris = new Node("Paris");
        Node lyon = new Node("Lyon");
        Node marseille = new Node("Marseille");
        Node toulouse = new Node("Toulouse");
        Node lille = new Node("Lille");
        Node nantes = new Node("Nantes");
        Node strasbourg = new Node("Strasbourg");

        ArrayList<Edge> listeEdgeParis = new ArrayList<>();
        listeEdgeParis.add(new Edge(paris,nantes,385));
        listeEdgeParis.add(new Edge(paris,lyon,312));
        listeEdgeParis.add(new Edge(paris, strasbourg, 492));
        listeEdgeParis.add(new Edge(paris, lille, 225));

        ArrayList<Edge> listeEdgeLyon = new ArrayList<>();
        listeEdgeLyon.add(new Edge(lyon, paris, 312));
        listeEdgeLyon.add(new Edge(lyon, marseille, 301));
        listeEdgeLyon.add(new Edge(lyon, strasbourg, 340));
        listeEdgeLyon.add(new Edge(lyon, nantes, 686));

        ArrayList<Edge> listeEdgeMarseille = new ArrayList<>();
        listeEdgeMarseille.add(new Edge(marseille, toulouse, 403));
        listeEdgeMarseille.add(new Edge(marseille, lyon, 301));

        ArrayList<Edge> listeEdgeToulouse = new ArrayList<>();
        listeEdgeToulouse.add(new Edge(toulouse, marseille, 403));
        listeEdgeToulouse.add(new Edge(toulouse, nantes, 585));
        listeEdgeToulouse.add(new Edge(toulouse, paris, 679));

        ArrayList<Edge> listeEdgeLille = new ArrayList<>();
        listeEdgeLille.add(new Edge(lille, paris, 225));
        listeEdgeLille.add(new Edge(lille, strasbourg, 525));

        ArrayList<Edge> listeEdgeNantes = new ArrayList<>();
        listeEdgeNantes.add(new Edge(nantes, paris, 385));
        listeEdgeNantes.add(new Edge(nantes, lyon, 686));
        listeEdgeNantes.add(new Edge(nantes, toulouse, 403));

        ArrayList<Edge> listeEdgeStrasbourg = new ArrayList<>();
        listeEdgeStrasbourg.add(new Edge(strasbourg, paris, 492));
        listeEdgeStrasbourg.add(new Edge(strasbourg, lille, 525));
        listeEdgeStrasbourg.add(new Edge(strasbourg, lyon, 492));

        paris.setConnections(listeEdgeParis);
        lyon.setConnections(listeEdgeLyon);
        marseille.setConnections(listeEdgeMarseille);
        toulouse.setConnections(listeEdgeToulouse);
        lille.setConnections(listeEdgeLille);
        nantes.setConnections(listeEdgeNantes);
        strasbourg.setConnections(listeEdgeStrasbourg);

        ArrayList<Node> listeNoeuds = new ArrayList<>();

        listeNoeuds.add(paris);
        listeNoeuds.add(lyon);
        listeNoeuds.add(marseille);
        listeNoeuds.add(toulouse);
        listeNoeuds.add(lille);
        listeNoeuds.add(nantes);
        listeNoeuds.add(strasbourg);

        Graph graph = new Graph(listeNoeuds);

        boolean[] estMarque = new boolean[graph.getNoeux().size()];

        System.out.println(Graph.estConnexe(graph, graph.getNoeux().get(0), estMarque));


    }


}
