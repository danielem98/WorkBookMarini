package ires.corso.parttwo.classes;

public class Quadrato extends MasterShape{
    private double l;

    public Quadrato(double l){
        this.l=l;
    }

    @Override
    public double computeArea(){
        return l*l;
    }

    @Override
    public double computePerimeter(){
        return l*4;
    }

    public double getL() {
        return l;
    }

    public void setL(double l) {
        this.l = l;
    }

    public void showArea(){
        System.out.printf("\nArea del quadrato:%.2f ",computeArea());
    }
}
