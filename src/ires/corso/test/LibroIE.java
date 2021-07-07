package ires.corso.test;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LibroIE {

    private static String convertToString(Libro l) {
        String conversione = String.format("%s$%s$%s$%s$%s$%s$%s$%s", l.getTitolo(), l.getAutore(), l.getSinossi(), l.getIsbn(), l.getDataPubblicazine().toString(),
                l.getGenere().toString(), l.getGiudizio().toString(), l.getAvanzamento());

        return conversione;
    }


    public static void exportToFile() throws IOException{

        System.out.println("Inserisci il nome del file su cui esportare: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        try (PrintWriter outputStream = new PrintWriter(new FileWriter(fileName)))
        {

            List<Libro> libroL = BibliotecaRepositry.getBibliotecaRepostory().getLibroList();
            Iterator<Libro> li = libroL.iterator();

            while (li.hasNext()) {
                String sLibro = convertToString(li.next());
                outputStream.println(sLibro);
            }
        }catch (Exception e) {
            System.out.println("Error export file ");
        }
    }

    public static void importFromFile() throws Exception {
        System.out.println("Inserisci il nome del file dal quale importare: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();

        ArrayList<String> fileLines = new ArrayList<>();

        try (BufferedReader inputStream = new BufferedReader(new FileReader(fileName))) {
            String l;
            while ((l = inputStream.readLine()) != null) {
                fileLines.add(l);
            }
        }

        Iterator<String> itr = fileLines.iterator();
        int numToDo = 0;
        while(itr.hasNext()){
            String[] splitString = itr.next().split("\\$");


            String titolo = null;
            String autore = null;
            String sinossi = null;
            String isbn = null;
            LocalDate dataPubblicazine = null;
            Libro.Genere genere = null;
            Libro.GiudizioPersonale giudizio = null;
            Integer avanzamento = null;


            //controlli sui valori delle properties
            if(splitString[1] != null)
                titolo = splitString[1];
            else
                System.out.println("titolo nullo");

            if(splitString[2] != null)
                autore = splitString[2];
            else
                System.out.println("autore nullo");

            if(splitString[3] != null)
                sinossi = splitString[3];
            else
                System.out.println("sinossi nulla");

            if(splitString[4] != null)
                isbn = splitString[4];
            else
                System.out.println("isbn nulla");

            if(splitString[5] != null)
                dataPubblicazine = LocalDate.parse(splitString[5]);
            else
                System.out.println("sinossi nulla");

            if(splitString[6].equals("BIOGRAFIA")){
                genere = Libro.Genere.BIOGRAFIA;
            }
            else if(splitString[6].equals("ROMANZO")){
                genere = Libro.Genere.ROMANZO;
            }
            else if(splitString[6].equals("GIALLO")){
                genere = Libro.Genere.GIALLO;
            }
            else if(splitString[6].equals("FANTASY")){
                genere = Libro.Genere.FANTASY;
            }
            else
                System.out.println("genere non valida");

            if(splitString[7].equals("BUONO")){
                giudizio = Libro.GiudizioPersonale.BUONO;
            }
            else if(splitString[7].equals("NON_DATO")){
                giudizio = Libro.GiudizioPersonale.NON_DATO;
            }
            else if(splitString[7].equals("NON_SUFFICIETE")){
                giudizio = Libro.GiudizioPersonale.NON_SUFFICIENTE;
            }
            else if(splitString[7].equals("OTTIMO")){
                giudizio = Libro.GiudizioPersonale.OTTIMO;
            }
            else if(splitString[7].equals("SUFFICIENTE")){
                giudizio = Libro.GiudizioPersonale.SUFFICIENTE;
            }
            else if(splitString[7].equals("PESSIMO")){
                giudizio = Libro.GiudizioPersonale.PESSIMO;
            }
            else
                System.out.println("giudizio non valido");

            if(splitString[8] != null)
                avanzamento = Integer.valueOf(splitString[8]);
            else
                System.out.println("avanzamento nullo");


            Libro importLibro = new Libro(titolo,autore,sinossi,isbn,dataPubblicazine,genere,giudizio,avanzamento);

            BibliotecaRepositry.getBibliotecaRepostory().add(importLibro);
        }

    }




}
