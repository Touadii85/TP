public class ArbreBinaire {
    private Integer clef;
    private ArbreBinaire droite;
    private ArbreBinaire gauche;

    // Attribut statique pour l'instance unique de l'arbre vide
    private static final ArbreBinaire arbreVide = new ArbreBinaire();

    public ArbreBinaire() {
        this.clef = null;
        this.droite = null;
        this.gauche = null;
    }

    public Integer getClef() {
        return clef;
    }

    public void setClef(Integer clef) {
        this.clef = clef;
    }

    public ArbreBinaire getDroite() {
        return droite;
    }

    public void setDroite(ArbreBinaire droite) {
        this.droite = droite;
    }

    public ArbreBinaire getGauche() {
        return gauche;
    }

    public void setGauche(ArbreBinaire gauche) {
        this.gauche = gauche;
    }

    public static ArbreBinaire creer(){
        return arbreVide;
    }

    public boolean estVide(){
        return this.clef == null && this.gauche == null && this.droite == null;
    }

    public int taille(){
        if(this.estVide()){
            return 0;
        }else {
            int tailleGauche = (this.gauche == null) ? 0 : this.gauche.taille();
            int tailleDroite = (this.droite == null) ? 0 : this.droite.taille();
            return 1 + tailleGauche + tailleDroite; // 1 pour le noeud courant
        }
    }

    public  boolean rechercher(int valeur){
        if(this.estVide()) {
            return false;
        }
        if (this.clef != null && this.clef ==valeur) {
            return true;
        }
            boolean rechercheGauche = (this.gauche == null) ? false : this.gauche.rechercher(valeur);
            boolean rechercheDroite = (this.droite == null) ? false : this.droite.rechercher(valeur);
            return rechercheGauche || rechercheDroite;

    }

    public static void main(String[] args){
        ArbreBinaire arbre = new ArbreBinaire();

        //Création de noueds
        ArbreBinaire noueds1 = new ArbreBinaire();
        ArbreBinaire noueds2 = new ArbreBinaire();
        ArbreBinaire noueds3 = new ArbreBinaire();

        //Insertion de valeur avec les setters
        noueds1.setClef(5);
        noueds2.setClef(40);
        noueds3.setClef(20);

        // Construction manuelle de l'arbre
        arbre.setDroite(noueds1);
        arbre.setGauche(noueds2);
        noueds1.setDroite(noueds3);

        // Affichage de l'arbre
        // Comme il n'y a pas de méthode d'affichage, nous affichons manuellement les valeurs
        System.out.println("Valeur du noeud racine: " + arbre.getClef());
        System.out.println("Valeur du noeud gauche: " + arbre.getGauche().getClef());
        System.out.println("Valeur du noeud droit: " + arbre.getDroite().getClef());
        System.out.println("Valeur du sous-noeud droite du noeud droite: " + arbre.getDroite().getDroite().getClef());
    }
}