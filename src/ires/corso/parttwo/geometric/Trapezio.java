package ires.corso.parttwo.geometric;

import ires.corso.parttwo.geometric.MasterShape;

public class Trapezio extends MasterShape {
    private double bMag,bMin,h,l1,l2;

    public Trapezio(double bMag,double bMin,double h,double l1, double l2){
        this.bMag = bMag;
        this.bMin = bMin;
        this.h = h;
        this.l1 = l1;
        this.l2 = l2;
    }

    @Override
    public double computeArea(){
        return ((bMag+bMin)*h)/2;
    }

    @Override
    public double computePerimeter(){
        return bMin+bMag+l1+l2;
    }

    public double getbMag() {
        return bMag;
    }

    public void setbMag(double bMag) {
        this.bMag = bMag;
    }

    public double getbMin() {
        return bMin;
    }

    public void setbMin(double bMin) {
        this.bMin = bMin;
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

    public void setLo1(double l1) {
        this.l1 = l1;
    }

    public double getL2() {
        return l2;
    }

    public void setLo2(double l2) {
        this.l2 = l2;
    }

    public void showArea(){
        System.out.printf("\nArea del trapezio:%.2f ",computeArea());
    }
}
