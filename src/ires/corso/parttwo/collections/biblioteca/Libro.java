package ires.corso.parttwo.collections.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    //num. pagine, num. volumi, num. capitoli
    private String autore;
    private String dataPubblicazione;
    private int numPagine;
    private int numVolumi;
    private int numCapitoli;

    public ArrayList<Categoria> categorie = new ArrayList<>();

    public Libro(String autore, String dataPubblicazione, int numPagine, int numVolumi, int numCapitoli) {
        this.autore = autore;
        this.dataPubblicazione = dataPubblicazione;
        this.numPagine = numPagine;
        this.numVolumi = numVolumi;
        this.numCapitoli = numCapitoli;
    }

    public String getAutore() {
        return autore;
    }

    public String getDataPubblicazione() {
        return dataPubblicazione;
    }

    public int getNumPagine() {
        return numPagine;
    }

    public int getNumVolumi() {
        return numVolumi;
    }

    public int getNumCapitoli() {
        return numCapitoli;
    }

    public ArrayList<Categoria> getCategorie() {
        return categorie;
    }
}
