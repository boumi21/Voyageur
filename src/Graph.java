import java.util.ArrayList;
import java.util.List;

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

    /**
     * Méthode récursive qui permet de savoir si un graph est connexe ou non
     * @param graph graphe à vérifier
     * @param node Noeud de départ
     * @param estMarque Tableau de boolean qui permet de marqué un noeud
     * @return true si le graphe est connexe, false sinon
     */
    public static boolean estConnexe(Graph graph, Node node, boolean[] estMarque){
        for (int i = 0; i < estMarque.length; i++) {
            if (node.equals(graph.getNoeux().get(i))){
                estMarque[i] = true;
            }
        }

        for (Edge edge : node.getConnections()){
            for (int i = 0; i < estMarque.length; i++) {
                if (edge.getEnd().equals(graph.getNoeux().get(i))){
                    if (!estMarque[i]){
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

    /**
     * Méthode qui permet de trouver le plus court chemin entre deux noeuds de façon naïve
     * Le résultat peut être faux dans certains cas, c'est pour ça qu'elle est qualfié de naïve
     * @param g Le graphe
     * @param start Le noeud de départ
     * @param end Le noeud d'arrivé
     * @return la distance entre les deux noeuds
     */
    public static int plusCourtCheminSimple(Graph g, Node start, Node end){
        ArrayList<Node> noeudVisite = new ArrayList<>();
        ArrayList<Node> cheminCourant = new ArrayList<>();

        Node noeudCourant = start;
        int distance = 0;

        noeudVisite.add(noeudCourant);
        cheminCourant.add(noeudCourant);

        while (!noeudCourant.equals(end) && noeudVisite.size() < g.getNoeux().size()){
            boolean avance = false;
            List<Edge> listeDesVoisins = noeudCourant.getConnections();
            triABulle(listeDesVoisins);
            for (Edge edge : listeDesVoisins) {
                if (!noeudVisite.contains(edge.getEnd())){
                    noeudCourant = edge.getEnd();
                    noeudVisite.add(noeudCourant);
                    cheminCourant.add(noeudCourant);
                    distance += edge.getValeur();
                    avance = true;
                    break;
                }
            }

            if (!avance){
                for (Edge edge : noeudCourant.getConnections()){
                    if (edge.getEnd().equals(cheminCourant.get(cheminCourant.size()-2))){
                        distance -= edge.getValeur();
                    }
                }
                noeudCourant = cheminCourant.get(cheminCourant.size()-2);
                cheminCourant.remove(cheminCourant.size()-1);
            }
        }

        System.out.println("Distance entre "+start+" et "+end+" est de : "+distance);
        return distance;
    }

    /**
     * Méthode qui permet de ranger une liste de voisin dans l'ordre croissant de leur distance
     * Elle permet de faciliter la recherche du voisin de plus proche non marqué
     * @param tab liste des voisins
     */
    public static void triABulle(List<Edge> tab){
        boolean tab_en_ordre = false;
        int taille = tab.size();
        while(!tab_en_ordre){
            tab_en_ordre = true;
            for(int i=0 ; i < taille-1 ; i++){
                if(tab.get(i).getValeur() > tab.get(i+1).getValeur()){

                    Edge tamp = tab.get(i);
                    tab.set(i, tab.get(i+1));
                    tab.set(i+1, tamp);

                    tab_en_ordre = false;
                }
            }
            taille--;
        }
    }
}
