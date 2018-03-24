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

    public static void plusCourtChemin(Graph graph, Node start, Node end){
        double[] distanceMin = new double[graph.getNoeux().size()];
        ArrayList<Node> noeuxVisite = new ArrayList<>();
        ArrayList<Node> predecesseur = new ArrayList<>();
        Node noeuxCourant;

        for (int i = 0; i < distanceMin.length; i++){
            if (graph.getNoeux().get(i).equals(start)){
                distanceMin[i] = 0;
            }
        }

        noeuxCourant = start;
        noeuxVisite.add(noeuxCourant);

        while (noeuxVisite.size() < graph.getNoeux().size()){
            Node noeuxLePlusProche = null;
            double valeurMin = 100000;
            for (Edge edge : noeuxCourant.getConnections()){
                if (edge.getValeur() < valeurMin && !(noeuxVisite.contains(edge))){
                    valeurMin = edge.getValeur();
                    noeuxLePlusProche = edge.getEnd();
                }
            }

            noeuxCourant = noeuxLePlusProche;
            noeuxVisite.add(noeuxCourant);

            if (noeuxCourant.equals(end)){
                break;
            }

            for (Edge edge : noeuxCourant.getConnections()){
                double distance = 0;

                for (int i = 0; i < distanceMin.length; i++){
                    if (noeuxCourant.equals(graph.getNoeux().get(i))){
                        distance = distanceMin[i] + edge.getValeur();
                    }
                }
                for (int i = 0; i < distanceMin.length; i++){
                    if (edge.getEnd().equals(graph.getNoeux().get(i))){
                        if (distance < distanceMin[i]){
                            distanceMin[i] = distance;
                            predecesseur.add(noeuxCourant);

                        }
                    }
                }
            }
        }

        ArrayList<Node> chemin = new ArrayList<>();

        for(Edge edge : end.getConnections()){
            if (predecesseur.contains(edge.getEnd())){
                noeuxCourant = end;
                chemin.add(end);

                while (testPredecesseur(predecesseur, noeuxCourant)){
                    chemin.add(noeuxCourant);

                }
            }
        }
    }


    public static boolean testPredecesseur(ArrayList<Node> predecesseur, Node noeuxCourant){
        for (Edge edge : noeuxCourant.getConnections()){
            if (predecesseur.contains(edge.getEnd())){
                return true;
            }
        }
        return false;
    }

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
