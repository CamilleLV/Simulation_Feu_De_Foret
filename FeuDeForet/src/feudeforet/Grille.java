/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feudeforet;

import java.util.ResourceBundle;

/**
 *
 * @author Camille LAVERIE
 */
public class Grille {
    
    private final Case[][] cases;
    
    ResourceBundle bundle = ResourceBundle.getBundle("feudeforet.porperties.values");
    String tempLargeur = bundle.getString("values.largeur");
    String tempHauteur = bundle.getString("values.hauteur");
    
    int dimLargeur = Integer.parseInt(tempLargeur);
    int dimHauteur = Integer.parseInt(tempHauteur);
    
    
    public Grille() {
        // initialisation du tableau :
        cases = new Case[dimLargeur][dimHauteur];
        
        for(int i=0; i<cases.length; i++) {
             for(int j=0; j<cases[i].length; j++) {
                 cases[i][j]=new Case();
             }
        }
    }
}
