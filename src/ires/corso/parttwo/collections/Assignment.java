package ires.corso.parttwo.collections;

import java.util.Scanner;

public class Assignment {
    private String titolo;
    private String descrizione;

    Scanner in = new Scanner(System.in);

    public Assignment(String titolo, String descrizione) {
        this.titolo = titolo;
        this.descrizione = descrizione;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

}
