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
public class Main {

    /**
     * @param args the command line arguments
     */
    
    ResourceBundle bundle = ResourceBundle.getBundle("feudeforet.porperties.values");
    String dimLargeur = bundle.getString("values.largeur");
    String dimHauteur = bundle.getString("values.hauteur");
    String posCasesEnFeux = bundle.getString("values.positionscaseenfeu");
    String proba = bundle.getString("values.probabilité");
    
   
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
