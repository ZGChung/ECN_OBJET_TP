/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projettp;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.Date;

/**
 * Class de sauvegarde de partie
 * @author uble
 */
public class SauvegardePartie {
    String nomFichier;
    BufferedWriter buffer;

    /**
     *
     * @return
     */
    public String getNomFichier() {
        return nomFichier;
    }

    /**
     *
     * @param nomFichier
     */
    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    /**
     *
     * @return
     */
    public BufferedWriter getBuffer() {
        return buffer;
    }

    /**
     *
     * @param buffer
     */
    public void setBuffer(BufferedWriter buffer) {
        this.buffer = buffer;
    }
    
    /**
     *
     * @param nomFichier
     */
    public SauvegardePartie(String nomFichier) {
        this.nomFichier = nomFichier;
    }
    
    /**
     *Sauvegarde vide
     */
    public SauvegardePartie() {
        this.nomFichier = null;
    }
    
    /**
     * Méthode de sauvegarde
     * @param monde
     */
    public void sauvegarderPartie(World2 monde){
        Scanner sc= new Scanner(System.in); //standard input stream  
        
        System.out.println("Voulez-vous personnaliser le nom du fichier de sauvegarde ? [oui/non]");  
        String rep= sc.nextLine();
        System.out.println("Le nom que vous avez choisi est : " + rep);
        if ("oui".equals(rep)){
            System.out.println("Entrez le nom de votre sauvegarde");  
            nomFichier= sc.nextLine()+".txt";          //reads string
        }
        else{
            //sans nom spécifique on utilise la date
            Date maintenant = new Date();
            SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy_HH'h'mm'm'ss's'");
            this.nomFichier = "save_";
            this.nomFichier += formater.format(maintenant);
            this.nomFichier += ".txt";
        }
        
        
        try{
           //buffer
           buffer= new BufferedWriter (new FileWriter(this.nomFichier));
           //On commence par la taille du monde
           buffer.write("Largeur " + monde.getMondeLargeur());
           buffer.newLine();
           buffer.write("Hauteur " + monde.getMondeLongueur());
           buffer.newLine();
           Integer nbrCreature = monde.listCreature.size();
           //puis les créa
           for (Creature c: monde.listCreature.values()){
               buffer.write(c.creerSauvegarde());
               buffer.newLine();
                }
           //les objets
           for (Objet o: monde.listObjet.values()){
               buffer.write(o.creerSauvegarde());
               buffer.newLine();
           }
           //et les joueurs
           for (Joueur j: monde.listJoueurs.values()){
               buffer.write(j.creerSauvegarde());
               buffer.newLine();
           }
           
           
        }
        // on attrape l'exception si on a pas pu creer le fichier
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        // on attrape l'exception si il y a un probleme lors de l'ecriture dans le fichier
        catch (IOException ex) {
            ex.printStackTrace();
        }
        // on ferme le fichier
        finally {
            try {
                if (buffer != null) {
                    // je force l'écriture dans le fichier
                    buffer.flush();
                    // puis je le ferme
                    buffer.close();
                }
            }
            // on attrape l'exception potentielle 
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
}
