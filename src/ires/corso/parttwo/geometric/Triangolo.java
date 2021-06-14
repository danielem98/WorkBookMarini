package ires.corso.parttwo.geometric;

public class Triangolo extends MasterShape {
    private double b,h,l1,l2;

    public Triangolo(double b, double h,double l1, double l2){
        this.b = b;
        this.h = h;
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    public double computeArea(){
        return (b*h)/2;
    }

    @Override
    public double computePerimeter() {
        return l1+l2+b;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getL1() {
        return l1;
    }

    public void setL1(double l1) {
        this.l1 = l1;
    }

    public double getL2() {
        return l2;
    }

    public void setL2(double l2) {
        this.l2 = l2;
    }

    public void showArea(){
        System.out.printf("\nArea del triangolo:%.2f ",computeArea());
    }
}
