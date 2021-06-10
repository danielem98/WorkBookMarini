package ires.corso.partone;

import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        System.out.println("Inserisci un array (numeri separati da |, esempio: 1|2|3|...)");
        System.out.print("==>");
        Scanner in = new Scanner(System.in);
        String nl = in.nextLine();
        //String[] strArr = nl.split("\\|");
        String[] strArr = nl.split(" ");

        int[] intArr = new int[strArr.length];

        for(int j = 0; j < strArr.length; j++) {
            System.out.printf("Elemento %d-esimo dell'array ==> %s\n", j + 1, strArr[j]);
            intArr[j] = Integer.parseInt(strArr[j]);
        }

        System.out.print("Dimmi l'elemento da cercare: ");
        int j = in.nextInt();
        int p = elemPositionInArray(intArr, j);
        System.out.printf("L'elemento si trova in posizione %d\n", p);

        int[] arrWoD= removeDuplicates(intArr);
        System.out.println("l'array senza duplicati: ");
        for(int a :arrWoD){
            System.out.print(a + " ");
        }
    }

    public static int elemPositionInArray(int[] intArray, int elem) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    public static int[] removeDuplicates(int[] arrayWD){
        int length=arrayWD.length;

        for(int i=0; i<length;i++){
            for(int j=i+1; j<length;j++) {
                if (arrayWD[i] == arrayWD[j]) {
                    int shiftL = j;
                    for (int k = j + 1; k<length; k++) {
                        arrayWD[shiftL] = arrayWD[k];
                        shiftL++;
                    }
                    length--;
                    j--;
                }
            }
        }

        int[] newArray = new int[length];
        for(int i=0; i<length; i++){
            newArray[i]=arrayWD[i];
        }
        return newArray;

    }




}
