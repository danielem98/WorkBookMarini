package ires.corso.test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BibliotecaRepositry {

    protected static BibliotecaRepositry repository = null;

    protected Map<Long, Libro> Libri = new HashMap<>();

    private static String _fileName;

    private static boolean _init = false;

    private long id ;


    private BibliotecaRepositry() {

    }


    public static boolean init(String fileName){
        try{
            Path p = Paths.get(fileName);
            _fileName = p.toString();
            _init = true;
        }
        catch (InvalidPathException ipe){
            System.out.println("Invalid path ");
        }

        return _init;
    }

    public static BibliotecaRepositry getBibliotecaRepostory() throws Exception {
        if(!_init){
            throw new Exception("To Do repository has not been inizialized");
        }

        if(repository == null)
            if(!Files.exists(Paths.get(_fileName)))
                repository= new BibliotecaRepositry();
            else
                loadFromFile();
        return repository;
    }

    public long getNewId(){
        return ++id;
    }



    public void add(Libro l){
        Long newid = getNewId();
        l.setId(newid);
        Libri.put(newid,l);
    }

    public void update(Libro l){
       if(Libri.containsKey(l.getId()))
           Libri.put(l.getId(),l);
       else
           System.out.println("id non presente");
   }

    public void delete(Long ID) {
        Libri.remove(ID);
    }



    public static void writeToFile(String fileName) {
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(repository);

            System.out.println("Object has been serialized");
        }
        catch(IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    public static void loadFromFile() {
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(_fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            repository = (BibliotecaRepositry) in.readObject();

            System.out.println("Object has been deserialized ");

        }
        catch(IOException ex) {
            System.out.println("IOException is caught");
        }
        catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    public static List<Libro> getLibroList() {
        // restituisce lista di tutti i TO-DO esistenti
        ArrayList<Libro> libroList = new ArrayList<>();
        for (Libro l : repository.Libri.values()) {
            libroList.add(l);
        }
        return libroList;
    }

}
