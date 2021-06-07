package ires.corso.partone;

public class ImputTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s= new String[3];
        s[0]="Primo";
        s[1]="Secondo";
        s[2]="Terzo";

        System.out.println("Inserisci il primo numero: ");
        int n1 = in.nextInt();

        System.out.println("Inserisci il secondo numero: ");
        int n2 = in.nextInt();

        System.out.println("Inserisci il terzo numero: ");
        int n3 = in.nextInt();

        if(n1>n2){
            if(n1>n3){
                System.out.println("Il numero maggiore che hai inserito e il "+ s[0] + ": "+ n1);
            }
            else{
                System.out.println("Il numero maggiore che hai inserito e il "+ s[2] + ": "+ n3);
            }
        }
        else{
            if(n2>n3){
                System.out.println("Il numero maggiore che hai inserito e il "+ s[1] + ": "+ n2);
            }
            else{
                System.out.println("Il numero maggiore che hai inserito e il "+ s[2] + ": "+ n3);
            }
        }
    }
}
