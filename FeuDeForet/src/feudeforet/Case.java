/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feudeforet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Camille LAVERIE
 */
class Case {
    
    private List<Feu> feu=new ArrayList<>();
    private List<Brasier> brasier=new ArrayList<>();
    
    
     // ajouter un feu à une case
     public void ajouteFeu(Feu feu) {
          feu.add(feu);
     }
 
     // changer le feu en brasier
     public void supprimeFeu(Feu feu, Brasier brasier) {
          feu.remove(feu);
          brasier.add(brasier);
     }
 
}
