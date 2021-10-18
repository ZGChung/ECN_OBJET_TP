package org.centrale.projettp;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
import java.lang.*;
import java.lang.reflect.Constructor;

public class ChargementPartie<T extends ElementDeJeu> {
    private String nomSauvegarde;
    // BufferedReader bfrd;
    protected List<String> listCreaturePossible;
    protected List<String> listObjetPossible;
    protected List<Creature> listCreature;
    protected List<Objet> listObjet;
    Class<T> type;

    protected ChargementPartie(String nomSauvegarde) {
        this.nomSauvegarde = nomSauvegarde;
        // this.listCreaturePossible = Arrays.asList("Archer", "Paysan", "Mage",
        // "Guerrier", "Loup", "Lapin");
        // this.listObjetPossible = Arrays.asList("Soin", "Mana");
        this.listCreature = new ArrayList<Creature>();
        this.listCreature.add(new Archer());
        this.listCreature.add(new Paysan());
        this.listCreature.add(new Mage());
        this.listCreature.add(new Guerrier());
        this.listCreature.add(new Loup());
        this.listCreature.add(new Lapin());

        this.listObjet = new ArrayList<Objet>();
        this.listObjet.add(new Soin());
        this.listObjet.add(new Mana());

        this.listCreaturePossible = new ArrayList<String>();
        this.listCreature.forEach(i -> {
            listCreaturePossible.add(i.getClass().getName());
        });

        this.listObjetPossible = new ArrayList<String>();
        this.listObjet.forEach(i -> {
            listObjetPossible.add(i.getClass().getName());
        });

        this.type = null;
    }

    protected World2 chargerPartie() {
        int nCreature = 0;
        int nObjet = 0;
        int nJoueur = 0;
        World2 returnWorld = new World2(100, 100);
        String className;
        Class cls;
        int indexList = 0;

        // read the file
        String delimiteurs = " ,.;";
        try {
            String ligne;
            BufferedReader fichier = new BufferedReader(new FileReader(this.nomSauvegarde));
            ligne = fichier.readLine();
            while (ligne != null) {
                // System.out.println(ligne);
                // if read a line successfully
                StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs);
                // deal with the first word in each line
                String mot = tokenizer.nextToken();
                System.out.println(mot);
                if (this.listCreaturePossible.contains("org.centrale.projettp." + mot)) {
                    // line of info for a creature
                    System.out.println("line of a creature");
                    className = "org.centrale.projettp." + mot;
                    cls = Class.forName(className);
                    indexList = listCreaturePossible.indexOf("org.centrale.projettp." + mot);
                    System.out.println(indexList);
                    type = cls;
                    ElementDeJeu crea = type.cast(listCreature.get(indexList));

                    nCreature = nCreature + 1;
                    returnWorld.listCreature.put(nCreature, (Creature) crea);

                } else if (this.listObjetPossible.contains("org.centrale.projettp." + mot)) {
                    // line of an object
                    System.out.println("line of an object");
                    className = "org.centrale.projettp." + mot;
                    cls = Class.forName(className);
                    indexList = listObjetPossible.indexOf("org.centrale.projettp." + mot);
                    type = cls;
                    ElementDeJeu obj = type.cast(listObjet.get(indexList));
                    nObjet = nObjet + 1;

                    returnWorld.listObjet.put(nObjet, (Objet) obj);

                } else if (mot.equals("Largeur") || mot.equals("Hauteur")) {
                    // first 2 lines
                    System.out.println("line of a L / H");
                    // System.out.println(mot);
                } else {
                    // must be a line of joueur
                    System.out.println("line of a player");
                    System.out.println(mot);
                }
                // System.out.println("FIRST WORD!" + mot);
                // end of the process of the first word of the line
                while (tokenizer.hasMoreTokens()) {
                    mot = tokenizer.nextToken();

                    // System.out.println(mot);
                }
                ligne = fichier.readLine();
            }
            fichier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("End 1");
        for (int i = 0; i < returnWorld.listCreature.size(); i++) {
            System.out.print(returnWorld.listCreature.get(i).getClass().getName());
        }
        for (int i = 0; i < returnWorld.listObjet.size(); i++) {
            System.out.print(returnWorld.listObjet.get(i).getClass().getName());
        }
        System.out.print("End 2");
        return returnWorld;

    }
}
