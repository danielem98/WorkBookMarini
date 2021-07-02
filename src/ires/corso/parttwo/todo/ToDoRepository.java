package ires.corso.parttwo.todo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// GRUPPO 4:
public class ToDoRepository implements Serializable
{
    /* GESTORE DELL'ARCHIVIO DEI TO-DO == DATABASE */

    // Contiene una HashMap di tutti i TO-DO a sistema:
    // - implementa il metodo di salvataggio su file
    // - implementa il metodo di caricamento da file
    // - metodi per individuare, aggiungere, eliminare un TO-DO
    // - restituisce una copia di tutti i TO-DO come ArrayList, da
    //   usare per le visualizzazioni di ToDoList

    // Serializzabile con la funzione writeObject()


    protected static ToDoRepository _repository = null;
    protected Map<Long, ToDo> toDoMap = new HashMap<>();
    private static String _fileName;
    private static boolean _init = false;

    private static long idSeed;

    //costruttore privato
    private ToDoRepository(){
    }

    public static boolean init(String fileName){
        try{
            Path p = Paths.get(fileName);
            _fileName = p.toString();
            _init = true;
        }
        catch (InvalidPathException ipe){

        }

        return _init;
    }

    //Generatore di ID
    public static long getNewId(){
        return ++idSeed;
    }

    public static ToDoRepository getToDoRepository() throws Exception {
        // Restituisce sempre la stessa istanza (quella serializzata/deserializzata da file)
        if(!_init){
            throw new Exception("To Do repository has not been inizialized");
        }

        if(_repository==null)
            if(!Files.exists(Paths.get(_fileName)))
                _repository= new ToDoRepository();
            else
                loadFromFile();
        return _repository;
    }

    //Eliminazione di un to-do
    public void delete(Long ID) {
        toDoMap.remove(ID);
    }

    //aggiunta di un to-do
    public static void add(ToDo t) {
        // si deve entrare nell'oggetto t e leggere il suo ID
        // per poi salvarlo nella mappa correttamente (con put(ID, t))

        t.id = getNewId();

        _repository.toDoMap.put(t.getId(),t);
    }

    //aggiornamento di un to-do
    public static void update(ToDo t) {
        // si prende l'ID dall'oggetto t
        // si recupera dalla mappa il TO-DO corrispondente con get(t), per controllo
        // si sostituisce con put(ID, t)

        if(_repository.toDoMap.containsKey(t.getId()))
            _repository.toDoMap.put(t.getId(),t);
        else
            System.out.println("id non presente");
    }

    public List<ToDo> getToDoList() {
        // restituisce lista di tutti i TO-DO esistenti
        ArrayList<ToDo> toDoList = new ArrayList<>();
        for(ToDo t : toDoMap.values()){
            toDoList.add(t);
        }
        return toDoList;
    }

    public static void writeToFile(String fileName) {
        // Salva tutta l'istanza del repository (compresi gli oggetti
        // TO-DO presenti in mappa) in un file tramite il metodo
        // writeObject di ObjectOutputStream.
        // Anche il membro idSeed è salvato su file (è variabile di istanza).
        // serializzazione su file con writeObject: cfr. hints/InputOutput
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(_repository);
            out.writeObject(idSeed);

            System.out.println("Object has been serialized");
        }
        catch(IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    public static void loadFromFile() throws IOException,ClassNotFoundException{
        // Individua il file e lo deserializza con readObject
        // _repository = ...
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(_fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            _repository = (ToDoRepository) in.readObject();

            System.out.println("Object has been deserialized ");

        }
        catch(IOException ex) {
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}