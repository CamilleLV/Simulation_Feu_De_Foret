package feudeforet;

import java.util.ArrayList;

/**
 * Cette classe est la représentation d'une case qui compose le tableau, elle possède une position, 
 * un état (Se référer à {@link feudeforet.JFenetre#nextStep() cette méthode}),
 * et une liste de cases voisines.
 * @author Camille LAVERIE
 * @version 1.0
 */
public class Case {

//ATTRIBUTS
    // **************************************************
    // Constantes
    // **************************************************
    /**
     * Instanciation des Constantes récupérées depuis la classe Config (Se référer à {@link feudeforet.Config cette classe}).
     */
    private final int MAX_DEF_ROW = Config.height;
    private final int MAX_DEF_COLUMN = Config.width;

    // **************************************************
    // Variables
    // **************************************************
    /**
     * Les 3 variables représentant la position sur la ligne, la position sur sur la colonne et 
     * l'état de la case (Se référer à {@link feudeforet.JFenetre#nextStep() cette méthode}).
     */
    private int column;
    private int row;
    private int state;

    /**
     * Instanciation d'une liste de voisins qui sont eux-mêmes des Cases.
     */
    ArrayList<Case> voisins = new ArrayList<Case>();

//CONSTRUCTEUR
    
    /**
     * Voici le constructeur d'une case, avec un état et sa position.
     */
    Case(int state, int row, int column) {
        this.state = state;
        this.row = row;
        this.column = column;
    }
    
//METHODES DE CLASSES
    /**
     * La méthode getVoisins permet de récupérer les cases voisines de la case en paramètre, 
     * elle récupère uniquement les voisins des 4 points cardinaux comme par exemple : 
     * <pre>{@code
     *     if (column < MAX_DEF_COLUMN - 1) {
     *         listVoisin.add(cases[row][column + 1]);
     *     }
     * }</pre>
     * @param cases Une case
     * @return La liste de voisins de la case en paramètre.
     */
    
    public ArrayList<Case> getVoisins(Case[][] cases) {

        ArrayList<Case> listVoisin = new ArrayList();

        if (column < MAX_DEF_COLUMN - 1) {
            listVoisin.add(cases[row][column + 1]);
        }
        if (column > 0) {
            listVoisin.add(cases[row][column - 1]);
        }
        if (row < MAX_DEF_ROW - 1) {
            listVoisin.add(cases[row + 1][column]);
        }
        if (row > 0) {
            listVoisin.add(cases[row - 1][column]);
        }

        return listVoisin;

    }

    /**
     * La méthode getState permet de récupérer l'etat de la case.
     * Le code invoque l'instruction : 
     * <pre>{@code 
     *   return state;
     * }</pre>
     * @return L'etat de la case.
     */
    public int getState() {
        return state;
    }

    /**
     * La méthode getVoisins permet de modifier l'état de la case.
     * Le code invoque l'instruction :
     * <pre>{@code 
     *     this.state = state;
     * }</pre>
     * @param state Etat que l'on souhaite pour la case en question
     */
    public void setState(int state) {
        this.state = state;
    }

}
