package ires.corso.partone;

public class StringTest {
    //scrivere un programma in java che:
    //1. accetta in input 3 stringhe (da riga di comando)
    //2. verifica che le stringhe siano 3
    //3. calcola la lunghezza di ciascuna stringa
    //4. trova il carattere iniziale e finale di ciascuna stringa
    //5. per tutte e 3 le stringhe stampa un report "La stringa" ..." ha lunghezza " ... "e finisce per"
    //
    public static void main(String[] args){
        if(args.length == 3){
            int[] l = new int[3];
            char[] ci = new char[3];
            char[] cf = new char[3];

            for(int i =0; i< args.length; i++){
                l[i]=args[i].length();


                for(int x=0; x<l[i]; x++){
                    ci[i]=args[i].charAt(0);
                    cf[i]=args[i].charAt(l[i]-1);
                }
            }

            for(int z = 0; z< args.length; z++) {
                System.out.println("la stringa " + args[z] + " ha la lunghezza " + l[z] + " inizia per " + ci[z] + " finisce per " + cf[z]);
            }


        }else{
            System.out.println("Non hai inserito 3 stringhe");
        }

    }
}
