package ires.corso.parttwo.geometric;

public class MasterShape {
    protected int id;
    private static int counter=0;

    protected MasterShape(){
        this.id = ++counter;
    }

    protected int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public double computeArea(){
        return 0.0;
    }

    public double computePerimeter(){
        return 0.0;
    }

    public void showArea(){};
}
