/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feudeforet;

import java.util.ArrayList;
import java.util.ResourceBundle;
import feudeforet.Case;

/**
 *
 * @author Camille LAVERIE
 */
public class Main {

    
    private static final int MAX_DEF_ROW = 20;
    private static final int MAX_DEF_COLUMN = 30;
    private static final int[][] tabFeu = {{1,7},{2,12}};
        
    
    /*ResourceBundle bundle = ResourceBundle.getBundle("feudeforet.porperties.values");
    String dimLargeur = bundle.getString("values.largeur");
    String dimHauteur = bundle.getString("values.hauteur");
    String posCasesEnFeux = bundle.getString("values.positionscaseenfeu");
    String proba = bundle.getString("values.probabilité");*/    
    /*ResourceBundle bundle = ResourceBundle.getBundle("feudeforet.porperties.values");
    String tempLargeur = bundle.getString("values.largeur");
    String tempHauteur = bundle.getString("values.hauteur");
    
    int dimLargeur = Integer.parseInt(tempLargeur);
    int dimHauteur = Integer.parseInt(tempHauteur);*/
    
    
        
    

    
    public static void main(String[] args) {
        System.out.println("Ca fonctionne");
        
                
        // initialisation du tableau :
        Case[][] cases = new Case[MAX_DEF_ROW][MAX_DEF_COLUMN];
        

        int state;
        
        for(int row=0; row<cases.length; row++) {
             for(int column=0; column<cases[row].length; column++) {
                 state = 0;
                 for(int[]feu : tabFeu){
                     if(row == feu[0] && column == feu[1]){
                         state = 1;
                     }
                 }
                 cases[row][column]=new Case(state, row, column);
             }
        }
        
        //Print du tableau
        for (int row = 0; row<MAX_DEF_ROW;row++) {
            System.out.println("");
            for (int column = 0; column<MAX_DEF_COLUMN;column++) {
                
                System.out.print(cases[row][column].getState()+" ");
                
            }
            
       }
        JFenetre fen = new JFenetre(cases);
        System.out.println("");
        
    } 
}