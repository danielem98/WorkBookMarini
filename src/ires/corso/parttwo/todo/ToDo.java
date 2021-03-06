package ires.corso.parttwo.todo;

import java.io.Serializable;
import java.time.LocalDate;

import static ires.corso.parttwo.todo.ToDoRepository.*;

public class ToDo implements Serializable, Cloneable
{
    protected long id;
    protected String titolo;
    protected LocalDate dataInserimento;
    protected LocalDate dataConsegna;
    protected String descrizione;
    public Stato stato;
    public Priorita priorita;

    public enum Priorita{
        ALTA,
        MEDIA,
        BASSA
    }

    public enum Stato{
        DA_FARE,
        IN_ESECUZIONE,
        COMPLETATA,
        ANNULLATA
    }

    protected ToDo (){
        this.dataInserimento = LocalDate.now();
    }

    protected ToDo(String titolo, LocalDate dataConsegna, String descrizione, Priorita priorita, Stato stato) {
        this.titolo = titolo;
        this.dataInserimento = dataInserimento.now();
        this.dataConsegna = dataConsegna;
        this.descrizione = descrizione;
        this.priorita = priorita;
        this.stato = stato;
    }


    public ToDo cloneForUpdate() {
        // fabbrica una copia esatta del To-Do (compreso l'ID)
        ToDo clone = null;
        try{
            clone = (ToDo) clone();
        }catch(CloneNotSupportedException cnse){
            System.out.println("Errore ");
        }

        return clone;
    }

    //metodi getter
    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getDataInserimento() {
        return dataInserimento;
    }

    public LocalDate getDataConsegna() {
        return dataConsegna;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Stato getStato() {
        return stato;
    }

    public Priorita getPriorita() {
        return priorita;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setDataConsegna(LocalDate dataConsegna) {
        this.dataConsegna = dataConsegna;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setStato(Stato stato) {
        this.stato =stato;
    }

    public void setPriorita(Priorita priorita) {
        this.priorita = priorita;
    }

    public String prettyPrint(){
        String s = String.format(" ID: %d \n TITOLO: %s \n DESCRIZIONE: %s \n CREATO IL: %s \n CON SCADENZA IL: %s \n CON PRIORIT??: %s \n CON STATO: %s",
                getId(), getTitolo(), getDescrizione(), getDataInserimento().toString(), getDataConsegna().toString(), getPriorita().toString(),
                getStato().toString());
        return s;
    }
}
