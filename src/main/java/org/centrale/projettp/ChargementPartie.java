package org.centrale.projettp;

import java.io.*;
import java.util.*;

public class ChargementPartie {
    String nomSauvegarde;
    // BufferedReader bfrd;
    List<String> listCreaturePossible;
    List<String> listObjetPossible;

    private ChargementPartie(String nomSauvegarde) {
        this.nomSauvegarde = nomSauvegarde;
        this.listCreaturePossible = Arrays.asList("Archer", "Paysan", "Mage", "Guerrier", "Loup", "Lapin");
        this.listObjetPossible = Arrays.asList("Soin", "Mana");
    }

    protected World chargerPartie() {
        World returnWorld = new World();
        return returnWorld;

    }
}
