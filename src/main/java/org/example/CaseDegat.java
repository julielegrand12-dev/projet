package org.example;

/**
 * Dans cette classe, nous implémentons les informations de chaque case de notre jeu qui subit un dégat: un bateau à cet endroit a été touché.
 */

public class CaseDegat extends Case {

    private boolean destruction;

    // getter et setter

    public void setDestruction(boolean destruction) {
        this.destruction = destruction;
    }

    public boolean isDestruction() {
        return destruction;
    }


    // méthodes


}
