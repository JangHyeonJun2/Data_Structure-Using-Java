package 상속;

import com.sun.tools.corba.se.idl.constExpr.Not;

public class Notebook extends Computer{

    public double screenSize;
    public double weight;

    public Notebook(String manufacturer, String processor, int ramSize, int diskSize, double processorSpeed,double screenSize, double weight) {
        super(manufacturer,processor,ramSize,diskSize,processorSpeed);
        this.screenSize = screenSize;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "screenSize=" + screenSize +
                ", weight=" + weight +
                super.toString() +
                '}';
    }

    public static void main(String[] args) {
        Notebook notebook = new Notebook("Dell","i7",8,128,3.2,15.6,12);
        System.out.println(notebook.toString());
    }
}
