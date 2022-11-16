
package feudeforet;

import java.util.ArrayList;
/**
 *
 * @author Camille LAVERIE
 */
class Case{
    
    
    private final int MAX_DEF_ROW = Config.height;
    private final int MAX_DEF_COLUMN = Config.width;
        
    
    
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
