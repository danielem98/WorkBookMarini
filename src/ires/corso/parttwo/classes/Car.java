package ires.corso.parttwo.classes;

public class Car {
    private String targa;
    private String marca;
    private String colore;
    private int postiASedere;
    private boolean cerchiInLega;

    public Car(String targa, String marca, int postiASedere){
        this.targa = targa;
        this.marca = marca;
        this.postiASedere = postiASedere;
    }

    public String getColore(){
        return this.colore;
    }

    public void setColore(String colore){
        this.colore = colore;
    }


    public String getTarga(){
        return this.targa;
    }

    public void setTarga(String targa){
        this.targa = targa;
    }

    public String getMarca(){
        return this.marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public int getPostiASedere(){
        return this.postiASedere;
    }

    public void setPostiASedere(int postiASedere){
        this.postiASedere=postiASedere;
    }

    public boolean getCerchiInLega(){
        return this.cerchiInLega;
    }

    public void setCerchiInLega(boolean cerchiInLega){
        this.cerchiInLega=getCerchiInLega();
    }

    public void prettyPrint(){
        System.out.println("targa: " + targa);
        System.out.println("marca: " + marca);
        System.out.println("colore: " + colore);
        System.out.println("la macchina ha "+ postiASedere +" posti a sedere");
    }
}
