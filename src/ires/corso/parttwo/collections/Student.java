package ires.corso.parttwo.collections;

public class Student {
    private String nome;
    private String cognome;
    private String codiceStudente;

    public Student(String nome, String cognome, String codiceStudente) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceStudente = codiceStudente;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceStudente() {
        return codiceStudente;
    }
}
