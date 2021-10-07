/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;

import java.util.Random;
import java.util.*; 

/**
 *classe world du tp4
 * @author uble, zgchung
 */
public class World2 {
    protected LinkedList<Personnage> listePerso;
    protected LinkedList<Monstre> listeMonstre;
    protected LinkedList<Potion> listePotion;
    protected int tailleMonde;
    
    Random generateurAleatoire = new Random();

    /**
     *constructeur avec listes
     * @param listePerso
     * @param listePotion
     * @param listeMonstre
     * @param tailleMonde
     */
    public World2(LinkedList<Personnage> listePerso, LinkedList<Potion> listePotion,LinkedList<Monstre> listeMonstre, int tailleMonde) {
        this.listePerso = listePerso;
        this.listeMonstre = listeMonstre;
        this.listePotion = listePotion;
        this.tailleMonde = tailleMonde;
    }
    
    /**
     *constructeur listes vides
     * @param tailleMonde
     */
    public World2(int tailleMonde) {
        this.listePerso = new LinkedList<>();
        this.listePotion = new LinkedList<>();
        this.listeMonstre = new LinkedList<>();
        this.tailleMonde = tailleMonde;
    }
    
    /**
     *méthode pour vérifier la superposition
     * @param a
     * @param list
     * @return
     */
    public boolean estSuperpose(Point2D a, List<Point2D> list){
        for (int i = 0; i < list.size(); i++){
            if (a.equals(list.get(i))){
                return true;
                }
            }
        return false;
    }
    
    /**
     *création de monde aléatoire
     * @param nbPerso
     * @param nbMonstre
     * @param nbPotion
    
     */
    public void creeMondeAlea(int nbPerso, int nbMonstre, int nbPotion){
        //On crée 20% de chaque perso et 50% de chaque Monstre pour avoir un monde équilibré
        List<Point2D> listCreated;
        listCreated = new ArrayList<>();
        Point2D ptTemp = new Point2D();
        for(int i = 0; i < Math.round(nbPerso*0.2); i++){
            Archer archer = new Archer();
            
            ptTemp.Affiche();
            
            Point2D a = new Point2D(archer.getPos().getX(),
                archer.getPos().getY());
            // si la distance est trop grande, on refaire le generation du nombre aleatoir

            while(a.distance(ptTemp)>5 || this.estSuperpose(a, listCreated)){
                // regenerer une position
                
                a.SetPosition(generateurAleatoire.nextInt(tailleMonde),generateurAleatoire.nextInt(tailleMonde));
                // parcourir tous les positions generees
            }

            archer.setPos(a);
            listePerso.add(archer);
            listCreated.add(archer.getPos());
            ptTemp=archer.getPos();
            
        }
        for(int i = 0; i < Math.round(nbPerso*0.2); i++){
            Paysan pay = new Paysan();
            
            Point2D a = new Point2D(pay.getPos().getX(),
                pay.getPos().getY());
            
            while(a.distance(ptTemp)>3 || this.estSuperpose(a, listCreated)){
            // regenerer une position
                a.SetPosition(generateurAleatoire.nextInt(tailleMonde),generateurAleatoire.nextInt(tailleMonde));
            // parcourir tous les positions generees
            }
            pay.setPos(a);
            ptTemp = pay.pos;
            listePerso.add(pay);
            listCreated.add(ptTemp);
            
        }
        for(int i = 0; i < Math.round(nbPerso*0.2); i++){
            Mage pay = new Mage();
            
            Point2D a = new Point2D(pay.getPos().getX()+generateurAleatoire.nextInt(3),
                pay.getPos().getY()+generateurAleatoire.nextInt(3));
            
            while(a.distance(ptTemp)>3 || this.estSuperpose(a, listCreated)){
            // regenerer une position
            a.SetPosition(generateurAleatoire.nextInt(tailleMonde),generateurAleatoire.nextInt(tailleMonde));
            // parcourir tous les positions generees
            }
            pay.setPos(a);
            ptTemp = pay.pos;
            listePerso.add(pay);
            listCreated.add(ptTemp);
            
        }
        for(int i = 0; i < Math.round(nbPerso*0.2); i++){
            Guerrier pay = new Guerrier();
            
            Point2D a = new Point2D(pay.getPos().getX()+generateurAleatoire.nextInt(3),
                pay.getPos().getY()+generateurAleatoire.nextInt(3));
            
            while(a.distance(ptTemp)>3 || this.estSuperpose(a, listCreated)){
            // regenerer une position
            a.SetPosition(generateurAleatoire.nextInt(tailleMonde),generateurAleatoire.nextInt(tailleMonde));
            // parcourir tous les positions generees
            }
            pay.setPos(a);
            ptTemp = pay.pos;
            listePerso.add(pay);
            listCreated.add(ptTemp);
            
        }
        for(int i = 0; i < Math.round(nbPerso*0.5); i++){
            Loup loup = new Loup();
            
            Point2D a = new Point2D(loup.getPos().getX()+generateurAleatoire.nextInt(3),
                loup.getPos().getY()+generateurAleatoire.nextInt(3));
            
            while(a.distance(ptTemp)>3 || this.estSuperpose(a, listCreated)){
            // regenerer une position
            a.SetPosition(generateurAleatoire.nextInt(tailleMonde),generateurAleatoire.nextInt(tailleMonde));
            // parcourir tous les positions generees
            }
            loup.setPos(a);
            ptTemp = loup.pos;
            listeMonstre.add(loup);
            listCreated.add(ptTemp);
            
        }
        for(int i = 0; i < nbPerso-Math.round(nbPerso*0.5); i++){
            Lapin pay = new Lapin();
            
            Point2D a = new Point2D(pay.getPos().getX()+generateurAleatoire.nextInt(3),
                pay.getPos().getY()+generateurAleatoire.nextInt(3));
            
            while(a.distance(ptTemp)>3 || this.estSuperpose(a, listCreated)){
            // regenerer une position
            a.SetPosition(generateurAleatoire.nextInt(tailleMonde),generateurAleatoire.nextInt(tailleMonde));
            // parcourir tous les positions generees
            }
            pay.setPos(a);
            ptTemp = pay.pos;
            listeMonstre.add(pay);
            listCreated.add(ptTemp);
            
        }
    }
    
    /**
     *affichage du monde
     */
    public void afficheMonde(){
        int i;
        System.out.println("Constitution du monde :");
        System.out.println("Nombre de Personnages :");
        System.out.println(listePerso.size());
        System.out.println("Nombre de Monstres :");
        System.out.println(listeMonstre.size());
        
        String[][] grid = new String[tailleMonde][tailleMonde];
        for(int k = 0; k < tailleMonde; k++){
            for(int j = 0; j < tailleMonde; j++){
                grid[k][j] = "          |";
            }
        }
        for (i=0 ; i < listePerso.size(); i++){
            grid[listePerso.get(i).pos.getX()][listePerso.get(i).pos.getY()] = "Perso"+i;
        }
        for (i=0 ; i < listeMonstre.size(); i++){
            grid[listeMonstre.get(i).pos.getX()][listeMonstre.get(i).pos.getY()] = "paysan"+i;
        }
        
        
        for(int k = 0; k < tailleMonde; k++){
            for(int j = 0; j < tailleMonde; j++){
                System.out.print(grid[k][j]);
            }
            System.out.println("");
        }
        System.out.println("-------** EN DETAILS **----------");
        
        System.out.println("Nombre de Persos :");
        System.out.println(listePerso.size());
        for (i=0 ; i < listePerso.size(); i++){
            System.out.println("-----------------------------------");
            System.out.println("Ce perso fait partie du monde :");
            
            listePerso.get(i).affiche();
            System.out.println("---------------****----------------");
        }
        System.out.println("Nombre de Monstres :");
        System.out.println(listeMonstre.size());
        for (i=0 ; i < listeMonstre.size(); i++){
            System.out.println("-----------------------------------");
            System.out.println("Ce monstre fait partie du monde :");
            
            listeMonstre.get(i).affiche();
            System.out.println("---------------****----------------");
        }
        
    }
}
