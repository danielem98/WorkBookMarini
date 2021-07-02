package ires.corso.parttwo.collections.biblioteca;

import java.util.ArrayList;

public class Prestito {
    //private Utente utente;
    private ArrayList<Libro> prestito = new ArrayList<>();

    public Prestito() {
    }

    public ArrayList<Libro> getPrestito() {
        return prestito;
    }

    public void setPrestito(ArrayList<Libro> prestito) {
        this.prestito = prestito;
    }

}
