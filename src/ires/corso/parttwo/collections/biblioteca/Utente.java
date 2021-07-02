package ires.corso.parttwo.collections.biblioteca;

public class Utente {
    private String nome;
    private String cognome;
    public Prestito prestito = new Prestito();
    private static int ID;

    public Utente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
        this.ID ++;
    }

    public void setPrestito(Prestito prestito) {
        this.prestito = prestito;
    }

    public Prestito getPrestito() {
        return prestito;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public static int getID() {
        return ID;
    }
}
