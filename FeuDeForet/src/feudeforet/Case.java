/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feudeforet;

import java.util.ArrayList;
/**
 *
 * @author etulyon1
 */
class Case{
    
    
    private final int MAX_DEF_ROW = 20;
    private final int MAX_DEF_COLUMN = 30;
        
    
    
    private int column;
    private int row;
    private int state;
    
    ArrayList<Case> voisins = new ArrayList<Case>();

    public ArrayList<Case> getVoisins(Case[][] cases) {
        
        
    
        ArrayList<Case> listVoisin = new ArrayList();
        
        if(column < MAX_DEF_COLUMN - 1){
            listVoisin.add(cases[row][column + 1]);
        }
        if(column > 0){
            listVoisin.add(cases[row][column - 1]);
        }
        if(row < MAX_DEF_ROW - 1){
            listVoisin.add(cases[row + 1][column]);
        }
        if(row > 0){
            listVoisin.add(cases[row - 1][column]);
        }
        
        
        
        
        return listVoisin;
    
    }
    
    Case(int state, int row, int column) {
        this.state = state;
        this.row = row;
        this.column = column;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
}
