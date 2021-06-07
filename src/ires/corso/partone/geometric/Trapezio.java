package ires.corso.partone.geometric;
import ires.corso.partone.geometric.Trapezio;

public class Trapezio {

    public static double computerArea(double bmaj, double bmin, double height) {
        double area = ((bmaj + bmin) * height)/2;
        return area;
    }
}
