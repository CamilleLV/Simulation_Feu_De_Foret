/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feudeforet;

/**
 *
 * @author etulyon1
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JFenetre extends JFrame {
    
    
    
    private final double probabilité = 0.6;
    private final int MAX_DEF_ROW = 20;
    private final int MAX_DEF_COLUMN = 30;
    
    
    
    private boolean isFinished = false;
    private Case[][] cases;
    private JButton btn = new JButton("Etape suivante");
    
    public JFenetre(Case[][] cases) {
        super("Simulation feu");
        this.cases = cases;
        btn.addActionListener(new nextStepAction());
        
        constrFen();
    }
    
    private void constrFen() {
        setSize(800,600);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(constrPan(cases));
        setVisible(true);
    }
    
    private JPanel constrPan(Case[][] cases) {
        
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        
        JPanel header = new JPanel();
        
        header.add(btn);
        
        if(isFinished) {
            header.add(new JLabel("Terminé !"));
        } else {
            header.add(new JLabel("INCENDIE !!!"));
            
        }
        header.setMaximumSize(new Dimension(800,75));
        
        main.add(header);
        
       
       JPanel forestPanel = new JPanel();
       GridLayout myLayout = new GridLayout(MAX_DEF_ROW,MAX_DEF_COLUMN);
       forestPanel.setLayout(myLayout);
       
       JPanel casePanel; // JPanel qui composent les cases du forestPanel.
       
       
       for (int i=0;i<this.MAX_DEF_ROW;i++) {
           for (int j=0;j<this.MAX_DEF_COLUMN;j++) {
               
              
               casePanel = new JPanel();
               
               switch (cases[i][j].getState()) {
                   case 1:
                       casePanel.setBackground(Color.red);
                       break;
                   case 2:
                       casePanel.setBackground(Color.gray);
                       break;
                   default:
                       casePanel.setBackground(Color.green);
                       break;
               }
               
               forestPanel.add(casePanel);
           }
       }
       
       main.add(forestPanel);
       
       return main;
       
    }
    
    public void update() {
        this.setContentPane(this.constrPan(cases));
        setVisible(true);
    }
    
    private class nextStepAction implements ActionListener{
        public void actionPerformed(ActionEvent clic) {
            nextStep();
        }
    }
    
    private void nextStep() {
        
        
            ArrayList<Case> listVoisins = new ArrayList();
            
            for(int row=0; row<cases.length; row++) {
             for(int column=0; column<cases[row].length; column++) {
                 if(cases[row][column].getState() == 1) {
                     listVoisins.addAll(cases[row][column].getVoisins(cases)); //Ca rajoute les voisins en feu sans écraser les anciennes valeurs
                     cases[row][column].setState(2);
                     
                 }
             }
                 
        }
        for(Case c : listVoisins){
            
            if(Math.random()<probabilité && c.getState() == 0){ //Math.random() initialement entre 0 et 1.
                c.setState(1);
            }
            
            
        }
        
        //Création d'un boolean pour le Label si il n'y a plus de feu.
        if (listVoisins.isEmpty()) {
            isFinished=true;
            System.out.println("La foret ne brulera pas plus");
        }
        
        
        //Print du tableau dans la console
        for (int row = 0; row<MAX_DEF_ROW;row++) {
            System.out.println("");
            for (int column = 0; column<MAX_DEF_COLUMN;column++) {
                
                System.out.print(cases[row][column].getState()+" ");
                
            }
            
       }
                   System.out.println("");   
                   
             update();
                   
      }

    
}