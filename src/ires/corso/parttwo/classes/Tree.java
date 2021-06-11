package ires.corso.parttwo.classes;

public class Tree {
    private static int counter=0;
    private int id;
    private String specie;
    private int eta;
    private boolean sempreVerde;

    public Tree(String specie, boolean semopreVerde){
        this.specie = specie;
        this.sempreVerde = semopreVerde;
        this.id = counter;
        counter++;

    }

    public String getSpecie() {
        return this.specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public int getEta() {
        return this.eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public boolean isSempreVerde() {
        return this.sempreVerde;
    }

    public void setSempreVerde(boolean sempreVerde) {
        this.sempreVerde = sempreVerde;
    }

    public void prettyPrint(){
        System.out.println("--------------------------------------");
        System.out.println("l'albero: " + specie + "ID: " + this.id);
        System.out.println("Ha: "+ eta + " anni");
        if(sempreVerde == true){
            System.out.println("ed è sempreverde");
        }else{
            System.out.println("ma non è sempreverde");
        }

    }
}
