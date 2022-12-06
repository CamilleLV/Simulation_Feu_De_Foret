package feudeforet;

/**
 * Classe principale qui initialise le tableau et l'affiche dans la console.
 * @author Camille LAVERIE
 * @version 1.0
 */
public class Main {
    
//ATTRIBUTS
    // **************************************************
    // Constantes
    // **************************************************
    /**
     * Instanciation des Constantes récupérées depuis la classe Config (Se référer à {@link feudeforet.Config cette classe}).
     */
    private static final int[][] tabFeu = {{1, 7}, {2, 12}};
    private final int MAX_DEF_ROW;
    private final int MAX_DEF_COLUMN;
    private final double probabilite;

    public static void main(String[] args) {
        new Main();
    }

//CONSTRUCTEUR
    public Main() {
        Config.open();
        System.out.println("Ca fonctionne");

        MAX_DEF_ROW = Config.height;
        MAX_DEF_COLUMN = Config.width;
        probabilite = Config.probabilite;
        System.out.println(probabilite);

        /**
         * Initialisation du tableau.
         */
        Case[][] cases = new Case[MAX_DEF_ROW][MAX_DEF_COLUMN];

        int state;

        for (int row = 0; row < cases.length; row++) {
            for (int column = 0; column < cases[row].length; column++) {
                state = 0;
                for (int[] feu : tabFeu) {
                    if (row == feu[0] && column == feu[1]) {
                        state = 1;
                    }
                }
                cases[row][column] = new Case(state, row, column);
            }
        }

        /**
         * Print du tableau.
         */
        for (int row = 0; row < MAX_DEF_ROW; row++) {
            System.out.println("");
            for (int column = 0; column < MAX_DEF_COLUMN; column++) {

                System.out.print(cases[row][column].getState() + " ");

            }

        }
        JFenetre fen = new JFenetre(cases);
        System.out.println("");

    }
}
