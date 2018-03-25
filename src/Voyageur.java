import java.util.ArrayList;

public class Voyageur {

    public static void main(String[] args) {

        //Création du graph test
        Node paris = new Node(0, "Paris");
        Node lyon = new Node(1, "Lyon");
        Node marseille = new Node(2,"Marseille");
        Node toulouse = new Node(3,"Toulouse");
        Node lille = new Node(4,"Lille");
        Node nantes = new Node(5,"Nantes");
        Node strasbourg = new Node(6,"Strasbourg");

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

        System.out.println(Graph.estConnexe(graph, paris, estMarque)); //Affiche si le graph est connexe ou non

        int[][] listeDistance = new int[listeNoeuds.size()][listeNoeuds.size()];

        //Remplissage du tableau des distances entre les villes avec la méthode naïve
        for (int i = 0; i < listeNoeuds.size(); i++) {
            for (int j = 0; j < listeNoeuds.size(); j++) {
                listeDistance[i][j] = Graph.plusCourtCheminSimple(graph, listeNoeuds.get(i), listeNoeuds.get(j));
            }
        }

        //Affchage des résultats en forme de matrice
        System.out.print("              ");
        for (Node node : listeNoeuds){
            System.out.print(node + "    ");
        }
        System.out.println();
        for (int i = 0; i < listeNoeuds.size(); i++) {
            String affichage = ""+listeNoeuds.get(i);
            System.out.print(affichage);

            for (int espace = 0; espace < 14-affichage.length(); espace++) {
                System.out.print(" ");
            }

            for (int j = 0; j < listeNoeuds.size(); j++) {
                affichage = listeDistance[i][j]+"";
                String chainePourAlligne = listeNoeuds.get(j)+"    ";
                int taille = chainePourAlligne.length();
                System.out.print(affichage);
                for (int espace = 0; espace < taille - affichage.length(); espace++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }



    }


}
