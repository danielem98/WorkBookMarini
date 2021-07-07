package ires.corso.test;



import java.io.Serializable;
import java.time.LocalDate;

public class Libro implements Serializable, Cloneable {
    protected long id;
    private String titolo;
    private String autore;
    private String sinossi;
    private String isbn;
    private LocalDate dataPubblicazine;
    private Genere genere;
    private GiudizioPersonale giudizio = GiudizioPersonale.NON_DATO;
    private Integer avanzamento = 0;


    public enum Genere{FANTASY, GIALLO, ROMANZO, BIOGRAFIA}
    public enum GiudizioPersonale{OTTIMO, BUONO, SUFFICIENTE, NON_SUFFICIENTE, PESSIMO, NON_DATO}

    public Libro(){}

    public Libro(String titolo, String autore, String sinossi, String isbn,LocalDate dataPubblicazine, Genere genere, GiudizioPersonale giudizio, Integer avanzamento) {
        this.titolo = titolo;
        this.autore = autore;
        this.sinossi = sinossi;
        this.dataPubblicazine = dataPubblicazine;
        this.isbn = isbn;
        this.genere = genere;
        this.giudizio = giudizio;
        this.avanzamento = avanzamento;
    }

    public Libro cloneForUpdate() {
        // fabbrica una copia esatta del To-Do (compreso l'ID)
        Libro clone = null;
        try{
            clone = (Libro) clone();
        }catch(CloneNotSupportedException cnse){
            System.out.println("Errore clone");
        }
        return clone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getSinossi() {
        return sinossi;
    }

    public void setSinossi(String sinossi) {
        this.sinossi = sinossi;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public GiudizioPersonale getGiudizio() {
        return giudizio;
    }

    public void setGiudizio(GiudizioPersonale giudizio) {
        this.giudizio = giudizio;
    }

    public int getAvanzamento() {
        return avanzamento;
    }

    public void setAvanzamento(int avanzamento) {
        avanzamento = avanzamento;
    }

    public LocalDate getDataPubblicazine() {
        return dataPubblicazine;
    }

    public void setDataPubblicazine(LocalDate dataPubblicazine) {
        this.dataPubblicazine = dataPubblicazine;
    }

    public String prettyprint(){
        String s = String.format(" ID: %s \n TITOLO: %s \n AUTORE: %s \n SINOSSI: %s \n ISBN: %s \n DATA PUBBLICAZIONE: %s \n GENERE: %s \n GIUDIZIO PERSONALE: %s \n AVANZAMENTO LETTURA: %s",
                getId(), getTitolo(), getAutore(), getSinossi(), getIsbn(), getDataPubblicazine().toString(), getGenere().toString(), getGiudizio().toString(), getAvanzamento());
        return s;
    }
}
