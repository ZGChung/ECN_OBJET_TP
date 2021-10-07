/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

import java.util.Random;

import java.util.*; 

/**
 *Classe du nuage toxique
 * @author uble
 */
public class NuageToxique extends Objet implements Combattant, Deplacable{

    /**
     *liste des Cases de nuage
     */
    protected ArrayList<Point2D> listeCase;

    /**
     *dégat d'attaque du nuage
     */
    protected int degAtt;
    
    Random generateurAleatoire = new Random();

    /**
     *constructeur taille aléatoire
     */
    public NuageToxique(){
        this.degAtt=generateurAleatoire.nextInt(100);
        int taille = generateurAleatoire.nextInt(100);
        this.listeCase = new ArrayList<>();
        Point2D origine=new Point2D(generateurAleatoire.nextInt(5),generateurAleatoire.nextInt(5));
        for(int i = 0; i < Math.round(taille/4); i++){
            //On étend le nuage en cercle
        
            for (int j=0; j<=i;j++){
                listeCase.add(new Point2D(origine.getX()+i,origine.getY()+j)); 
                listeCase.add(new Point2D(origine.getX()+j,origine.getY()+i)); 
                    
            }
        }
        
    }
    
    /**
     *getter Liste Case
     * @return
     */
    public ArrayList<Point2D> getListeCase() {
        return listeCase;
    }

    /**
     *Constructeur avec taille définie
     * @param taille
     */
    public NuageToxique(int taille){
        this.degAtt=generateurAleatoire.nextInt(100);
        
        this.listeCase = new ArrayList<>();
        Point2D origine=new Point2D(generateurAleatoire.nextInt(5),generateurAleatoire.nextInt(5));
        listeCase.add(new Point2D(origine.getX(),origine.getY()));
        for(int i = 1; i < Math.round(taille); i++){
            //On étend le nuage en carré
            for (int j=0; j<=i;j++){
                listeCase.add(new Point2D(origine.getX()+i,origine.getY()+j)); 
                listeCase.add(new Point2D(origine.getX()+j,origine.getY()+i)); 
                    
            }
            
                }
        }
        
    
        

    

    /**
     *Setter 
     * @param listeCase
     */
    public void setListeCase(ArrayList<Point2D> listeCase) {
        this.listeCase = listeCase;
    }

    /**
     *getter dégât d'attaque
     * @return
     */
    public int getdegAtt() {
        return degAtt;
    }

    /**
     *setter dégâts Attaque
     * @param degAtt
     */
    public void setdegAtt(int degAtt) {
        this.degAtt = degAtt;
    }
    
    
    /**
     *Combat pour le nuage
     * Si le joueur passe dessous (donc distance néagtive), il attaque de la même façon qu'un guerrier en prenant en compte les points
     * @param c
     */
    
    @Override
    public void combattre(Creature c){
        boolean attaque = false ;
        //System.out.println("Le nuage vous fait de l'oeil !");
        for(int i = 0; i < listeCase.size(); i++){
            //System.out.println(""+this.getListeCase());
            //System.out.println(""+c.getPos());
            if ((this.getListeCase().get(i).getX()==c.getPos().getX()) & (this.getListeCase().get(i).getY()==c.getPos().getY()) ){
                System.out.println("Le nuage vous fait de l'oeil !");
                System.out.println("Le nuage inflige "+this.getdegAtt()+" à la créature");
                c.setPtVie(c.getPtVie()-this.getdegAtt());
                attaque=true;
            }
            
        }   
                
            
        
        if (attaque==false){
            System.out.println("La créature n'est pas dans la zone");
        }
    }
    
    /**
     *Déplacement pour le nuage
     */

    

   

    /**
     * Déplacement pour le nuage
     * @param x
     * @param y
     */
    @Override
    public void deplacer(int x, int y){
        for(int i = 0; i < listeCase.size(); i++){
            ArrayList<Point2D> listeTransi= this.getListeCase() ;
            listeTransi.set(i, new Point2D(listeTransi.get(i).getX()+x,listeTransi.get(i).getY()+y));
        }
            
            
        }
    }

