package ires.corso.parttwo.collections;

import java.util.HashMap;
import java.util.Map;

public class Course {
    private String titolo;
    private String settore;
    private String descrizione;

    public Map<Assignment,HashMap> Assignment= new HashMap<>();

    public Course(String titolo, String settore, String descrizione) {
        this.titolo = titolo;
        this.settore = settore;
        this.descrizione = descrizione;
    }

    public Map<Assignment, HashMap> getAssignment() {
        return Assignment;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getSettore() {
        return settore;
    }

    public String getDescrizione() {
        return descrizione;
    }

}
